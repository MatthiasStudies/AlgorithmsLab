package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractDictionary;
import de.hska.iwi.ads.solution.map.BetterMapTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class HashtableTest extends BetterMapTest {

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new Hashtable<>(50);
    }
    public <K extends Comparable<K>, V> Map<K, V> createMap(int capacity) {
        return new Hashtable<>(capacity);
    }

    @Test
    void throwsDictionaryFullException() {
        Map<Integer, String> map = createMap(1);
        map.put(1, "One");
        assertThrows(AbstractDictionary.DictionaryFullException.class, () -> map.put(2, "Two"));
    }

    @Test
    void testDuplicatedHash1() {
        Map<Integer, String> map = createMap(10);
        map.put(1, "One");
        map.put(51, "FiftyOne");
        assertEquals("One", map.get(1));
        assertEquals("FiftyOne", map.get(51));
    }

    @Test
    void testDuplicatedHash2() {
        Map<Integer, String> map = createMap(100);
        map.put(1, "One");
        map.put(11, "Eleven");
        map.put(21, "TwentyOne");
        map.put(31, "ThirtyOne");
        map.put(41, "FortyOne");
        map.put(51, "FiftyOne");
        map.put(61, "SixtyOne");
        map.put(71, "SeventyOne");
        map.put(81, "EightyOne");
        map.put(91, "NinetyOne");

        assertEquals("One", map.get(1));
        assertEquals("Eleven", map.get(11));
        assertEquals("TwentyOne", map.get(21));
        assertEquals("ThirtyOne", map.get(31));
        assertEquals("FortyOne", map.get(41));
        assertEquals("FiftyOne", map.get(51));
        assertEquals("SixtyOne", map.get(61));
        assertEquals("SeventyOne", map.get(71));
        assertEquals("EightyOne", map.get(81));
        assertEquals("NinetyOne", map.get(91));
    }

}
