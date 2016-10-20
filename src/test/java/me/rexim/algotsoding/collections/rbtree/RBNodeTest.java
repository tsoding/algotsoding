package me.rexim.algotsoding.collections.rbtree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.*;

public class RBNodeTest {
    @Test
    public void equalsTest() throws Exception {
        final RBNode<Integer> node1 = new RBNode<>(1, Color.RED,
                new RBNode<>(2, Color.BLACK, null, null),
                new RBNode<>(3, Color.RED, null, null));

        final RBNode<Integer> node2 = new RBNode<>(1, Color.RED,
                new RBNode<>(2, Color.BLACK, null, null),
                new RBNode<>(3, Color.RED, null, null));

        Assert.assertEquals(node1, node2);
    }

    @Test
    public void toStringTest() throws Exception {
        final RBNode<Integer> node = new RBNode<>(1, Color.RED,
                new RBNode<>(2, Color.BLACK, null, null),
                new RBNode<>(3, Color.RED, null, null));

        final String expectedSexp = "(1 RED (2 BLACK null null) (3 RED null null))";

        Assert.assertEquals(expectedSexp, node.toString());
    }
}