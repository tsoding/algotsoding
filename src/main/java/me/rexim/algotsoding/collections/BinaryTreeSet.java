package me.rexim.algotsoding.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeSet<E> implements Set<E> {
    /** A binary tree node that is only traversable down
     */
    private class DownNode {
        DownNode(E value, DownNode left, DownNode right) {
            this.value = value;
            this.left = left;
            this.right = right;

        }

        DownNode(E value) {
            this(value, null, null);
        }

        DownNode updateLeft(DownNode newLeft) {
            return new DownNode(this.value, newLeft, this.right);
        }

        DownNode updateRight(DownNode newRight) {
            return new DownNode(this.value, this.left, newRight);
        }

        DownNode updateValue(E newValue) {
            return new DownNode(newValue, this.left, this.right);
        }

        final E value;
        final DownNode left;
        final DownNode right;
    }

    BinaryTreeSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private DownNode add(DownNode currentRoot, DownNode node) {
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
        root = add(root, new DownNode(element));
    }

    private DownNode delete(DownNode currentRoot, E element) {
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

    private boolean contains(DownNode currentRoot, E element) {
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

    private void collectElements(DownNode currentNode, ArrayList<E> result) {
        if (currentNode != null) {
            collectElements(currentNode.left, result);
            result.add(currentNode.value);
            collectElements(currentNode.right, result);
        }
    }

    private void print(DownNode currentNode, int level) {
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

    private DownNode root = null;
    private Comparator<E> comparator = null;
}
