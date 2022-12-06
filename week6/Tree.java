package week6;

import static java.lang.System.arraycopy;
import static java.lang.System.out;

public class Tree {
    private static class TreeNode {
        int _n;
        TreeNode _left;
        TreeNode _right;

        TreeNode(int n) {
            _n = n;
            _left = _right = null;
        }

        int getNumber() {
            return _n;
        }

        void setLeftNode(int n) {
            _left = new TreeNode(n);
        }

        void setRightNode(int n) {
            _right = new TreeNode(n);
        }

        boolean isEmptyLeft() {
            return _left == null;
        }

        boolean isEmptyRight() {
            return _right == null;
        }
    }

    private TreeNode _rootNode;
    private int _numOfNodes;
    private int _leftInserts;
    private int _rightInserts;

    public Tree(int n) {
        _rootNode = new TreeNode(n);
        _numOfNodes = 1;
        _leftInserts = _rightInserts = 0;
    }

    public Tree(TreeNode node, int size) {
        _rootNode = node;
        _numOfNodes = size;
        _leftInserts = _rightInserts = 0;
    }

    public int numOfNodes() {
        return _numOfNodes;
    }

    public int size() {
        return _leftInserts > _rightInserts ? _leftInserts + 1 : _rightInserts + 1;
    }

    public void insert(int n) {
        class HelperCl {
            void insertHelper(TreeNode node) {
                if (n == node.getNumber())
                    return;
                if (n > node.getNumber() && node.isEmptyRight()) {
                    _rightInserts += 1;
                    node.setRightNode(n);
                } else if (n < node.getNumber() && node.isEmptyLeft()) {
                    _leftInserts += 1;
                    node.setLeftNode(n);
                } else if (n > node.getNumber())
                    insertHelper(node._right);
                else
                    insertHelper(node._left);
            }
        }
        _numOfNodes += 1;
        new HelperCl().insertHelper(_rootNode);
    }

    public int search(int n) {
        class HelperCl {
            int helperFn(TreeNode node) {
                if (node == null)
                    return -101;
                else if (n == node.getNumber())
                    return n;
                else if (n > node.getNumber())
                    return helperFn(node._right);
                else
                    return helperFn(node._left);
            }
        }
        return new HelperCl().helperFn(_rootNode);
    }

    public static void insertNode(TreeNode rootNode, TreeNode node) {
        if (node.getNumber() > rootNode.getNumber())
            rootNode._right = node;
        else
            rootNode._left = node;
    }

    public static TreeNode insertNodes(TreeNode rootNode, TreeNode left, TreeNode right) {
        rootNode._left = left;
        rootNode._right = right;
        return rootNode;
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
            void print(TreeNode node, int razmak) {
                if (node == null)
                    return;
                out.println(freeSpaces(razmak) + node.getNumber());
                print(node._left, razmak + 1);
                print(node._right, razmak + 1);
            }
        }
        new HelperCl().print(_rootNode, 0);
    }

    public static Tree makeTreeFromSortedArray(int[] arr) {
        class HelperCl {
            public TreeNode helperFn(int[] arr) {
                if (arr.length == 0)
                    return null;
                else if (arr.length == 1)
                    return new TreeNode(arr[0]);
                TreeNode resultTree = new TreeNode(arr[arr.length / 2]);
                int rightSize = arr.length % 2 == 1 ? arr.length / 2 : (arr.length / 2) - 1;
                int[] lefthalf = new int[arr.length / 2]; arraycopy(arr, 0, lefthalf, 0, arr.length / 2);
                int[] righthalf = new int[rightSize]; arraycopy(arr, (arr.length / 2) + 1, righthalf, 0, rightSize);
                return insertNodes(resultTree, helperFn(lefthalf), helperFn(righthalf));
            }
        }
        return new Tree(new HelperCl().helperFn(arr), arr.length);
    }

    public static void main(String[] args) {
        Tree T = new Tree(5);
        T.insert(4);
        T.insert(3);
        T.insert(2);
        T.insert(1);
        T.insert(6);
        T.insert(7);
        // out.println(T.size());
        // T.printTree();
        int[] arr = new int[]{-1, 0, 5, 4, 3, 2, 1, 6, 7, 8, 9};
        for (int i : arr)
            out.println(T.search(i));
    }
}
