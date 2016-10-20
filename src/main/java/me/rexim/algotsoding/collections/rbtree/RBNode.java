package me.rexim.algotsoding.collections.rbtree;

import java.util.Objects;

public class RBNode<E> {
    public RBNode(E value, Color color, RBNode<E> left, RBNode<E> right) {
        this.value = value;
        this.color = color;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof RBNode) {
            RBNode otherNode = (RBNode) o;
            return Objects.equals(value, otherNode.value) &&
                    Objects.equals(color, otherNode.color) &&
                    Objects.equals(left, otherNode.left) &&
                    Objects.equals(right, otherNode.right);
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("(%s %s %s %s)", value, color, left, right);
    }

    final E value;
    final Color color;
    final RBNode<E> left;
    final RBNode<E> right;
}
