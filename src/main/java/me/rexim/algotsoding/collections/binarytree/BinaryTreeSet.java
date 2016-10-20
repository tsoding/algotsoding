package me.rexim.algotsoding.collections.binarytree;

import me.rexim.algotsoding.collections.Set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeSet<E> implements Set<E> {
    BinaryTreeSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private DownNode<E> add(DownNode<E> currentRoot, DownNode<E> node) {
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
        root = add(root, new DownNode<>(element));
    }

    private DownNode<E> delete(DownNode<E> currentRoot, E element) {
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

    private boolean contains(DownNode<E> currentRoot, E element) {
        if (currentRoot != null) {
            int cmp = comparator.compare(currentRoot.value, element);

            if (cmp < 0) {
                return contains(currentRoot.right, element);
            } else {
                return cmp <= 0 || contains(currentRoot.left, element);
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
        ArrayList<E> result = new ArrayList<>();
        collectElements(root, result);
        return result;
    }

    private void collectElements(DownNode<E> currentNode, ArrayList<E> result) {
        if (currentNode != null) {
            collectElements(currentNode.left, result);
            result.add(currentNode.value);
            collectElements(currentNode.right, result);
        }
    }

    private DownNode<E> root = null;
    private Comparator<E> comparator = null;
}
