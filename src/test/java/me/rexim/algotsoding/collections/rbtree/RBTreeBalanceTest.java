package me.rexim.algotsoding.collections.rbtree;

import org.junit.Assert;
import org.junit.Test;

public class RBTreeBalanceTest {
    @Test
    public void balanceLeftLeft() throws Exception {
        final RBNode<Integer> node =
                new RBNode<>(1, Color.BLACK,
                        new RBNode<>(2, Color.RED,
                                new RBNode<>(3, Color.RED,
                                        null,
                                        null),
                                null),
                        null);

        final RBNode<Integer> expectedBalancedNode =
                new RBNode<>(2, Color.RED,
                        new RBNode<>(3, Color.BLACK,
                                null,
                                null),
                        new RBNode<>(1, Color.BLACK,
                                null,
                                null));

        final RBNode<Integer> balancedNode = RBTreeSet.balanceLeft(node);

        Assert.assertEquals(expectedBalancedNode, balancedNode);
    }

    @Test
    public void balanceLeftRight() throws Exception {
        final RBNode<Integer> node =
                new RBNode<>(1, Color.BLACK,
                        new RBNode<>(2, Color.RED,
                                null,
                                new RBNode<>(3, Color.RED,
                                        null,
                                        null)),
                        null);

        final RBNode<Integer> expectedBalancedNode =
                new RBNode<>(3, Color.RED,
                        new RBNode<>(2, Color.BLACK,
                                null,
                                null),
                        new RBNode<>(1, Color.BLACK,
                                null,
                                null));

        final RBNode<Integer> balancedNode = RBTreeSet.balanceLeft(node);

        Assert.assertEquals(expectedBalancedNode, balancedNode);
    }

    @Test
    public void balanceRightLeft() throws Exception {
        final RBNode<Integer> node =
                new RBNode<>(1, Color.BLACK,
                        null,
                        new RBNode<>(2, Color.RED,
                                new RBNode<>(3, Color.RED,
                                        null,
                                        null),
                                null));

        final RBNode<Integer> expectedBalancedNode =
                new RBNode<>(3, Color.RED,
                        new RBNode<>(1, Color.BLACK,
                                null,
                                null),
                        new RBNode<>(2, Color.BLACK,
                                null,
                                null));

        final RBNode<Integer> balancedNode = RBTreeSet.balanceRight(node);

        Assert.assertEquals(expectedBalancedNode, balancedNode);
    }

    @Test
    public void balanceRightRight() throws Exception {
        final RBNode<Integer> node =
                new RBNode<>(1, Color.BLACK,
                        null,
                        new RBNode<>(2, Color.RED,
                                null,
                                new RBNode<>(3, Color.RED,
                                        null,
                                        null)));

        final RBNode<Integer> expectedBalancedNode =
                new RBNode<>(2, Color.RED,
                        new RBNode<>(1, Color.BLACK,
                                null,
                                null),
                        new RBNode<>(3, Color.BLACK,
                                null,
                                null));

        final RBNode<Integer> balancedNode = RBTreeSet.balanceRight(node);

        Assert.assertEquals(expectedBalancedNode, balancedNode);
    }
}