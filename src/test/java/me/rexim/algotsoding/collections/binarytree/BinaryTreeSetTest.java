package me.rexim.algotsoding.collections.binarytree;

import me.rexim.algotsoding.collections.Set;
import me.rexim.algotsoding.collections.SetTest;

public class BinaryTreeSetTest extends SetTest {
    @Override
    public Set<Integer> createSet() {
        return new BinaryTreeSet<>(Integer::compare);
    }
}