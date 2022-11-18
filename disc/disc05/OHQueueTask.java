package disc.disc05;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.System.out;

public class OHQueueTask {
    public static class OHRequest {
        public String description;
        public String name;
        public OHRequest next;

        public OHRequest(String description, String name, OHRequest next) {
            this.description = description;
            this.name = name;
            this.next = next;
        }
    }

    public static class OHQueue implements Iterable<OHRequest> {
        private final OHRequest _start;
        public OHQueue(OHRequest queue) {
            _start = queue;
        }

        @Override
        public Iterator<OHRequest> iterator() {
            return new TYIterator(_start).iterator();
        }
    }

    public static class OHIterator {
        OHRequest currentRequest;

        public OHIterator(OHRequest request) {
            currentRequest = request;
        }

        public boolean isGood(String description) {
            return description != null && description.length() > 5;
        }

        public Iterator<OHRequest> iterator() {
            class IteratorHelper implements Iterator<OHRequest> {
                @Override
                public boolean hasNext() {
                    return currentRequest != null;
                }
                @Override
                public OHRequest next() {
                    if (currentRequest == null)
                        throw new NoSuchElementException();
                    OHRequest tmp = currentRequest;
                    currentRequest = tmp.next;
                    if (isGood(tmp.description))
                        return tmp;
                    else
                        return this.next();
                }
            }
            return new IteratorHelper();
        }
    }

    public static class TYIterator extends OHIterator {
        private boolean ignoreNext;

        public TYIterator(OHRequest request) {
            super(request);
            ignoreNext = false;
        }

        @Override
        public boolean isGood(String description) {
            if (super.isGood(description)) {
                if (description.contains(("thank u"))) {
                    if (!ignoreNext)
                        return ignoreNext = true;
                    return ignoreNext = false;
                }
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        OHRequest s5 = new OHRequest("I deleted all of my files", "Allyson", null);
        OHRequest s4 = new OHRequest("conceptual: what is Java", "Omar", s5);
        OHRequest s3 = new OHRequest("git: I never did lab 1", "Connor", s4);
        OHRequest s2 = new OHRequest("help", "Hug", s3);
        OHRequest s1 = new OHRequest("no I haven't tried stepping through", "Itai", s2);

        OHRequest s14 = new OHRequest("help me", "Allyson", null);
        OHRequest s13 = new OHRequest("im bored", "Omar", s14);
        OHRequest s12 = new OHRequest("thank u", "Connor", s13);
        OHRequest s11 = new OHRequest("thank u", "Hug", s12);

        for (OHRequest request : new OHQueue(s1))
            out.print(request.name + " ");
        out.println();

        for (OHRequest request : new OHQueue(s11))
            out.print(request.name + " ");
        out.println();
    }
}
