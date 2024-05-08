package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.solution.map.BetterMapTest;

import java.util.Map;

public class BinarySearchTreeTest extends BetterMapTest {
    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new BinarySearchTree<>();
    }
}
