package me.rexim.algotsoding.collections;

/** A binary tree node that is only traversable down
 */
class DownNode<E> {
    DownNode(E value, DownNode<E> left, DownNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;

    }

    DownNode(E value) {
        this(value, null, null);
    }

    DownNode<E> updateLeft(DownNode<E> newLeft) {
        return new DownNode<>(this.value, newLeft, this.right);
    }

    DownNode<E> updateRight(DownNode<E> newRight) {
        return new DownNode<>(this.value, this.left, newRight);
    }

    final E value;
    final DownNode<E> left;
    final DownNode<E> right;
}