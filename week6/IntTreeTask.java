package week6;

import static java.lang.System.out;

public class IntTreeTask {
    public static class IntTree {
        private static class IntTreeNode {
            int _n;
            IntTreeNode _left, _right;

            IntTreeNode() {
                _n = -101;
                _left = _right = null;
            }

            IntTreeNode(int n) {
                _n = n;
                _left = _right = null;
            }
        }

        private final IntTreeNode _sentinelNode;

        public IntTree() {
            _sentinelNode = new IntTreeNode();
        }

        public void add(int n) {
            if (_sentinelNode._left == null) {
                _sentinelNode._left = new IntTreeNode(n);
                return;
            }
            class HelperCl {
                IntTreeNode helperFn(IntTreeNode node) {
                    if (node == null)
                        return new IntTreeNode(n);
                    else if (n > node._n)
                        node._right = helperFn(node._right);
                    else
                        node._left = helperFn(node._left);
                    return node;
                }
            }
            new HelperCl().helperFn(_sentinelNode._left);
        }

        private String freeSpaces(int n) {
            if (n == 0)
                return "";
            StringBuilder result = new StringBuilder();
            for (; n > 0; n -= 1)
                result.append(" ");
            return result.toString();
        }

        public void printTree() {
            class HelperCl {
                void print(IntTreeNode node, int razmak) {
                    if (node == null)
                        return;
                    out.println(freeSpaces(razmak) + node._n);
                    print(node._left, razmak + 1);
                    print(node._right, razmak + 1);
                }
            }
            new HelperCl().print(_sentinelNode._left, 0);
        }

        public void mergeWithTree(IntTree T) {
            class HelperCl {
                IntTreeNode mergeFn(IntTreeNode node, IntTreeNode Tnode) {
                    if (node == null || Tnode == null)
                        return Tnode;
                    else if (node._n > Tnode._n) {
                        node._left = mergeFn(node._left, Tnode);
                        if (Tnode._right != null)
                            if (_sentinelNode._left._n > Tnode._right._n)
                                node._right = mergeFn(node._right, Tnode._right);
                            else
                                mergeFn(_sentinelNode._left._right, Tnode._right);
                    } else {
                        node._right = mergeFn(node._right, Tnode);
                        if (Tnode._right != null)
                            if (_sentinelNode._left._n > Tnode._right._n)
                                node._left = mergeFn(node._left, Tnode._right);
                            else
                                mergeFn(_sentinelNode._left._right, Tnode._right);
                    }
                    return node;
                }
            }
            new HelperCl().mergeFn(_sentinelNode._left, T._sentinelNode._left);
        }
    }

    public static void main(String[] args) {
        IntTree T1 = new IntTree();
        T1.add(12);
        T1.add(3);
        T1.add(16);
        T1.add(10);
        T1.add(8);
        T1.add(14);
        T1.add(27);

        IntTree T2 = new IntTree();
        T1.add(1);
        T1.add(11);
        T1.add(26);

        T1.mergeWithTree(T2);

        T1.printTree();
    }
}
