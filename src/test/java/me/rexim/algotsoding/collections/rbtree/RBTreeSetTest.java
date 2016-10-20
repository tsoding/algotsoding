package me.rexim.algotsoding.collections.rbtree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RBTreeSetTest {
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

    @Test
    public void addTest() throws Exception {

    }

    @Test
    public void deleteTest() throws Exception {

    }

    @Test
    public void isEmptyTest() throws Exception {
        RBTreeSet<Integer> rbTree = new RBTreeSet<>(Integer::compareTo);
        Assert.assertTrue(rbTree.isEmpty());
    }

    @Test
    public void containsTest() throws Exception {

    }

    @Test
    public void toListTest() throws Exception {

    }

}