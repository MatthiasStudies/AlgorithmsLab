package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.solution.map.BetterMapTest;

import java.util.Map;

public class DoubleLinkedListTest extends BetterMapTest {


    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new DoubleLinkedList<>();
    }


}
