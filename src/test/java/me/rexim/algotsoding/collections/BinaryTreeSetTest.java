package me.rexim.algotsoding.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class BinaryTreeSetTest {

    @Test
    public void deleteFromEmpty() throws Exception {
        Set<Integer> set = new BinaryTreeSet<>(Integer::compareTo);

        Assert.assertTrue(set.isEmpty());
        set.delete(20);
        Assert.assertTrue(set.isEmpty());
    }

    @Test
    public void delete() throws Exception {
        Integer[] xs = {10, 5, 20, 79, 15};
        Set<Integer> set = new BinaryTreeSet<>(Integer::compareTo);

        for (Integer x: xs) {
            set.add(x);
        }

        set.delete(15);

        Assert.assertEquals(Arrays.asList(5, 10, 20, 79), set.toList());
    }

    @Test
    public void contains() throws Exception {
        Set<Integer> set = new BinaryTreeSet<>(Integer::compareTo);

        set.add(10);
        set.add(5);
        set.add(3);

        Assert.assertTrue(set.contains(5));
        Assert.assertFalse(set.contains(22));
    }

    @Test
    public void isEmpty() throws Exception {
        Set<Integer> set = new BinaryTreeSet<>(Integer::compareTo);

        Assert.assertTrue(set.isEmpty());
        set.add(10);
        Assert.assertFalse(set.isEmpty());
    }

    @Test
    public void add() throws Exception {
        Integer[] xs = {10, 5, 20, 79, 15};

        Set<Integer> set = new BinaryTreeSet<>(Integer::compareTo);

        for (int x: xs) {
            set.add(x);
        }

        Arrays.sort(xs, Integer::compareTo);
        List<Integer> elements = set.toList();

        Assert.assertEquals(Arrays.asList(xs), elements);
    }
}