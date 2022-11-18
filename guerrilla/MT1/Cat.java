package guerrilla.MT1;

import java.util.ArrayList;

public class Cat {
    private Cat parent;
    private ArrayList<Cat> kitties;
    private String name;

    public Cat(Cat parent, String name) {
        this.parent = parent;
        this.kitties = new ArrayList<Cat>();
        this.name = name;
    }

    public Cat copyCat() {
        Cat copy = new Cat(this.parent, this.name);
        for (int i = 0; i < this.kitties.size(); i += 1)
            copy.kitties.add(this.kitties.get(i).copyCat());
        return copy;
    }
}
