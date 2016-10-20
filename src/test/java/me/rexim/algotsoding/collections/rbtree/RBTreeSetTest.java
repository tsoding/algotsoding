package me.rexim.algotsoding.collections.rbtree;

import me.rexim.algotsoding.collections.Set;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        Integer[] xs = {10, 5, 20, 79, 15};

        Set<Integer> set = new RBTreeSet<>(Integer::compareTo);

        for (int x: xs) {
            set.add(x);
        }

        Arrays.sort(xs, Integer::compareTo);
        List<Integer> elements = set.toList();

        Assert.assertEquals(Arrays.asList(xs), elements);
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