package me.rexim.algotsoding.collections.rbtree;

import me.rexim.algotsoding.collections.Set;
import me.rexim.algotsoding.collections.SetTest;
import org.junit.Assume;

public class RBTreeSetTest extends SetTest {
    @Override
    protected Set<Integer> createSet() {
        return new RBTreeSet<>(Integer::compare);
    }

    @Override
    public void deleteTest() throws Exception {
        Assume.assumeTrue(false); // Ignore this test from SetTest "suite"
        // TODO(#13): implement RBTreeSet.delete() operation
    }
}
