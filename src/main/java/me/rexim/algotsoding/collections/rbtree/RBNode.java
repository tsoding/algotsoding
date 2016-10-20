package me.rexim.algotsoding.collections.rbtree;

import java.util.Objects;

public class RBNode<E> {
    public RBNode(E value, Color color, RBNode<E> left, RBNode<E> right) {
        this.value = value;
        this.color = color;
        this.left = left;
        this.right = right;
    }

    public RBNode(E value) {
        this(value, Color.RED, null, null);
    }

    RBNode<E> updateNodes(RBNode<E> left, RBNode<E> right) {
        return new RBNode<>(this.value, this.color, left, right);
    }

    RBNode<E> updateLeft(RBNode<E> left) {
        return new RBNode<>(this.value, this.color, left, this.right);
    }

    RBNode<E> updateRight(RBNode<E> right) {
        return new RBNode<>(this.value, this.color, this.left, right);
    }

    RBNode<E> blacken() {
        return new RBNode<>(this.value, Color.BLACK, this.left, this.right);
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
