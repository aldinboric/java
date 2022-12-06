package lab.lab07;

import edu.princeton.cs.algs4.BST;

import java.util.*;

import static java.lang.System.out;
import static lab.lab07.BSTMapComparator.compareKeys;

public class BSTMap<KeyType, ValueType> implements Map61B<KeyType, ValueType> {
    private class BSTNode {
        KeyType _key;
        ValueType _value;
        int _total;
        BSTNode _left;
        BSTNode _right;

        BSTNode(KeyType key, ValueType value) {
            _key = key;
            _value = value;
            _total = 1;
            _left = _right = null;
        }
    }

    private BSTNode _root;
    private int _size;

    public BSTMap() {
        _root = null;
        _size = 0;
    }

    public BSTMap(KeyType key, ValueType value) {
        _root = new BSTNode(key, value);
        _size = 1;
    }

    @Override
    public void clear() {
        class HelperCl {
            BSTNode helperFn(BSTNode node) {
                if (node == null)
                    return null;
                node._left = helperFn(node._left);
                node._right = helperFn(node._right);
                return null;
            }
        }
        _size = 0;
        _root = new HelperCl().helperFn(_root);
    }

    @Override
    public boolean containsKey(KeyType key) {
        class HelperCl {
            boolean helperFn(BSTNode node) {
                if (node == null)
                    return false;
                else if (node._key.equals(key))
                    return true;
                else if (compareKeys(key, node._key) > 0)
                    return helperFn(node._right);
                else
                    return helperFn(node._left);
            }
        }
        return new HelperCl().helperFn(_root);
    }

    @Override
    public ValueType get(KeyType key) {
        class HelperCl {
            ValueType helperFn(BSTNode node) {
                if (node == null)
                    return null;
                else if (compareKeys(key, node._key) == 0)
                    return node._value;
                else if (compareKeys(key, node._key) > 0)
                    return helperFn(node._right);
                else
                    return helperFn(node._left);
            }
        }
        return new HelperCl().helperFn(_root);
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public void put(KeyType key, ValueType value) {
        class HelperCl {
            BSTNode putHelperFn(BSTNode node) {
                if (node == null)
                    return new BSTNode(key, value);
                else if (compareKeys(key, node._key) == 0)
                    if (node._value.equals(value))
                        node._total += 1;
                    else
                        node._value = value;
                else if (compareKeys(key, node._key) > 0)
                    node._right = putHelperFn(node._right);
                else
                    node._left = putHelperFn(node._left);
                return node;
            }
        }
        _size += 1;
        if (_root == null)
            _root = new BSTNode(key, value);
        else
            new HelperCl().putHelperFn(_root);
    }

    private ArrayList<KeyType> BSTMapKeysToArrayList() {
        ArrayList<KeyType> result = new ArrayList<>();
        class HelperCl {
            void helperFn(BSTNode node) {
                if (node == null)
                    return;
                result.add(node._key);
                helperFn(node._left);
                helperFn(node._right);
            }
        }
        new HelperCl().helperFn(_root);
        return result;
    }

    @Override
    public Set<KeyType> keySet() {
        return new HashSet<KeyType>(BSTMapKeysToArrayList());
    }

    private ValueType findBiggestNodeInLeftTree(BSTNode rootNode) {
        class HelperCl {
            ValueType find(BSTNode prev, BSTNode curr) {
                if (curr._right == null) {
                    if (prev != rootNode)
                        prev._right = curr._left;
                    else
                        prev._left = curr._left;
                    ValueType tmp = rootNode._value;
                    rootNode._key = curr._key;
                    rootNode._value = curr._value;
                    return tmp;
                } else
                    return find(curr, curr._right);
            }
        }
        return new HelperCl().find(rootNode, rootNode._left);
    }

    private ValueType findSmallestNodeInRightTree(BSTNode rootNode) {
        class HelperCl {
            ValueType find(BSTNode prev, BSTNode curr) {
                if (curr._left == null) {
                    if (prev != rootNode)
                        prev._left = curr._right;
                    else
                        prev._right = curr._right;
                    ValueType tmp = rootNode._value;
                    rootNode._key = curr._key;
                    rootNode._value = curr._value;
                    return tmp;
                } else
                    return find(curr, curr._left);
            }
        }
        return new HelperCl().find(rootNode, rootNode._right);
    }

    @Override
    public ValueType remove(KeyType key) {
        class HelperCl {
            ValueType helperFn(BSTNode curr, BSTNode prev) {
                if (curr == null)
                    return null;
                else if (curr._key.equals(key)) {
                    if (curr._left == null && curr._right == null) {
                        if (curr == _root) {
                            _root = null;
                        } else if (prev._right == curr)
                            prev._right = null;
                        else
                            prev._left = null;
                        return curr._value;
                    } else if (curr._right == null)
                        return findBiggestNodeInLeftTree(curr);
                    else
                        return findSmallestNodeInRightTree(curr);
                } else if (compareKeys(key, curr._key) > 0)
                    return helperFn(curr._right, curr);
                else
                    return helperFn(curr._left, curr);
            }
        }
        _size -= 1;
        return new HelperCl().helperFn(_root, _root);
    }

    @Override
    public ValueType remove(KeyType key, ValueType value) {
        class HelperCl {
            ValueType helperFn(BSTNode node) {
                if (node == null)
                    return null;
                if (node._key.equals(key)) {
                    ValueType tmp = node._value;
                    node._value = null;
                    return tmp;
                }
                else if (compareKeys(key, node._key) > 0)
                    return helperFn(node._right);
                else
                    return helperFn(node._left);
            }
        }
        return new HelperCl().helperFn(_root);
    }

    @Override
    public Iterator<KeyType> iterator() {
        class IteratorClass implements Iterator<KeyType>{
            final ArrayList<KeyType> arrayListOfKeys = BSTMapKeysToArrayList();
            int index = 0;
            @Override
            public boolean hasNext() {
                return index != arrayListOfKeys.size();
            }

            @Override
            public KeyType next() {
                return arrayListOfKeys.get((index += 1) - 1);
            }
        }
        return new IteratorClass();
    }

    private static String freeSpaces(int n) {
        if (n == 0)
            return "";
        StringBuilder result = new StringBuilder();
        for (; n > 0; n -= 1)
            result.append(" ");
        return result.toString();
    }

    private StringBuilder toStrFn(BSTNode node, int spacesNumber, int spacesIncrement, String last) {
        if (node == null)
            return new StringBuilder("");
        StringBuilder result = new StringBuilder(freeSpaces(spacesNumber) + node._key + " : " + node._value + last);
        result.append(toStrFn(node._left, spacesNumber + spacesIncrement, spacesIncrement, last).toString());
        result.append(toStrFn(node._right, spacesNumber + spacesIncrement, spacesIncrement, last).toString());
        return result;
    }

    @Override
    public String toString() {
        return toStrFn(_root, 0, 1,"\n").toString();
    }

    public void printInOrder() {
        out.println("{" + toStrFn(_root, 0, 0, " | ").toString() + "}");
    }

    public static void main(String[] args) {
        BSTMap<Integer, String> BST = new BSTMap<>();
        BST.put(6, "Aldin");
        BST.put(3, "Nordin");
        BST.put(2, "Irma");
        BST.put(4, "Amir");
        BST.put(8, "Pupi");
        BST.put(7, "Medo");

        // out.println(BST);
        // BST.printInOrder();

        List<Integer> arr = BST.BSTMapKeysToArrayList();
        // out.println(arr);

        Set<Integer> set = BST.keySet();
        // out.println(set);

        for (Integer key : BST)
            out.print(key + ", ");
        out.println();
    }
}
