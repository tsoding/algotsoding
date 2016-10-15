package me.rexim.algotsoding.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeSet<E> implements Set<E> {
    private class Node {
        Node(E value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;

        }

        Node(E value) {
            this(value, null, null);
        }

        Node updateLeft(Node newLeft) {
            return new Node(this.value, newLeft, this.right);
        }

        Node updateRight(Node newRight) {
            return new Node(this.value, this.left, newRight);
        }

        Node updateValue(E newValue) {
            return new Node(newValue, this.left, this.right);
        }

        final E value;
        final Node left;
        final Node right;
    }

    BinaryTreeSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private Node add(Node currentRoot, Node node) {
        if (currentRoot == null) {
            return node;
        } else {
            int cmp = comparator.compare(currentRoot.value, node.value);

            if (cmp < 0) {
                return currentRoot.updateRight(add(currentRoot.right, node));
            } else if (cmp > 0) {
                return currentRoot.updateLeft(add(currentRoot.left, node));
            }

            return currentRoot;
        }
    }

    @Override
    public void add(E element) {
        root = add(root, new Node(element));
    }

    private Node delete(Node currentRoot, E element) {
        if (currentRoot != null) {
            int cmp = comparator.compare(currentRoot.value, element);

            if (cmp < 0) {
                return currentRoot.updateRight(delete(currentRoot.right, element));
            } else if (cmp > 0) {
                return currentRoot.updateLeft(delete(currentRoot.left, element));
            } else {
                return add(currentRoot.left, currentRoot.right);
            }

        } else {
            return null;
        }
    }

    @Override
    public void delete(E element) {
        root = delete(root, element);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private boolean contains(Node currentRoot, E element) {
        if (currentRoot != null) {
            int cmp = comparator.compare(currentRoot.value, element);

            if (cmp < 0) {
                return contains(currentRoot.right, element);
            } else if (cmp > 0) {
                return contains(currentRoot.left, element);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(E element) {
        return contains(root, element);
    }

    @Override
    public List<E> toList() {
        ArrayList<E> result = new ArrayList<E>();
        collectElements(root, result);
        return result;
    }

    private void collectElements(Node currentNode, ArrayList<E> result) {
        if (currentNode != null) {
            collectElements(currentNode.left, result);
            result.add(currentNode.value);
            collectElements(currentNode.right, result);
        }
    }

    private void print(Node currentNode, int level) {
        if (currentNode != null) {
            print(currentNode.left, level + 1);

            for (int i = 0; i < level; ++i) {
                System.out.print(' ');
            }
            System.out.println(currentNode.value.toString());

            print(currentNode.right, level + 1);
        }
    }

    public void print() {
        print(root, 0);
    }

    private Node root = null;
    private Comparator<E> comparator = null;
}
