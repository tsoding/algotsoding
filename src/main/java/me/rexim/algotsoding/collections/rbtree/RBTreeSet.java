package me.rexim.algotsoding.collections.rbtree;

import me.rexim.algotsoding.collections.Set;

import java.util.Comparator;
import java.util.List;

public class RBTreeSet<E> implements Set<E> {
    public RBTreeSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    static <E> RBNode<E> balanceLeft(RBNode<E> node1) {
        if (node1 == null || node1.color != Color.BLACK) {
            return node1;
        }

        final RBNode<E> node2 = node1.left;

        if (node2 == null || node2.color != Color.RED) {
            return node1;
        }

        if (node2.left != null && node2.left.color == Color.RED) {
            final RBNode<E> node3 = node2.left;

            return node2.updateNodes(
                    node3.blacken(),
                    node1.updateLeft(node2.right)
            );
        }

        if (node2.right != null && node2.right.color == Color.RED) {
            final RBNode<E> node3 = node2.right;

            return node3.updateNodes(
                    node2.updateRight(node3.left).blacken(),
                    node1.updateLeft(node3.right)
            );
        }

        return node1;
    }

    static <E> RBNode<E> balanceRight(RBNode<E> node1) {
        if (node1 == null || node1.color != Color.BLACK) {
            return node1;
        }

        final RBNode<E> node2 = node1.right;
        if (node2 == null || node2.color != Color.RED) {
            return node1;
        }

        if (node2.left != null && node2.left.color == Color.RED) {
            final RBNode<E> node3 = node2.left;

            return node3.updateNodes(
                    node1.updateRight(node3.left),
                    node2.updateLeft(node3.right).blacken()
            );
        }

        if (node2.right != null && node2.right.color == Color.RED) {
            final RBNode<E> node3 = node2.right;

            return node2.updateNodes(
                    node1.updateRight(node2.left),
                    node3.blacken()
            );
        }

        return node1;
    }

    @Override
    public void add(E element) {
        root = balancedAdd(root, new RBNode<>(element)).blacken();
    }

    private RBNode<E> balancedAdd(RBNode<E> root, RBNode<E> node) {
        if (root == null) {
            return node;
        } else {
            int cmp = comparator.compare(root.value, node.value);

            if (cmp < 0) {
                return balanceRight(root.updateRight(balancedAdd(root.right, node)));
            } else if (cmp > 0) {
                return balanceLeft(root.updateLeft(balancedAdd(root.left, node)));
            } else {
                return root;
            }
        }
    }

    @Override
    public void delete(E element) {

    }

    @Override
    public boolean isEmpty() {
        return null == root;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public List<E> toList() {
        return null;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private RBNode<E> root = null;
    private Comparator<E> comparator;
}
