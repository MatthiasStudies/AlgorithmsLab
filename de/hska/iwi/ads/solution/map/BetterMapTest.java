package de.hska.iwi.ads.solution.map;

import de.hska.iwi.ads.dictionary.MapTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BetterMapTest extends MapTest {
    @Test
    void testSize0() {
        Map<Integer, String> map = createMap();

        assertEquals(0, map.size());
    }

    @Test
    void shouldHandleEmptyMap() {
        Map<Integer, String> map = createMap();
        assertEquals(0, map.size());
    }

    @Test
    void shouldAddElementToMap() {
        Map<Integer, String> map = createMap();
        map.put(1, "One");
        assertEquals(1, map.size());
        assertEquals("One", map.get(1));
    }

    @Test
    void shouldUpdateExistingElementInMap() {
        Map<Integer, String> map = createMap();
        map.put(1, "One");
        map.put(1, "Updated One");
        assertEquals(1, map.size());
        assertEquals("Updated One", map.get(1));
    }

    @Test
    void shouldHandleMultipleElementsInMap() {
        Map<Integer, String> map = createMap();
        map.put(1, "One");
        map.put(2, "Two");
        assertEquals(2, map.size());
        assertEquals("One", map.get(1));
        assertEquals("Two", map.get(2));
    }

    @Test
    void shouldReturnNullForNonExistingKey() {
        Map<Integer, String> map = createMap();
        assertNull(map.get(1));
    }

    @Test
    void shouldThrowExceptionWhenAddingNullKey() {
        Map<Integer, String> map = createMap();
        assertThrows(NullPointerException.class, () -> map.put(null, "Null"));
    }

    @Test
    void shouldNotChangeSizeWhenAddingDuplicateKey() {
        Map<Integer, String> map = createMap();
        map.put(1, "One");
        map.put(1, "One");
        assertEquals(1, map.size());
    }

    @Test
    void shouldReturnPreviousValueWhenUpdating() {
        Map<Integer, String> map = createMap();
        map.put(1, "One");
        String previousValue = map.put(1, "Updated One");
        assertEquals("One", previousValue);

    }

    @Test
    void stringStringMap() {
        Map<String, String> map = createMap();
        map.put("a", "b");
        map.put("b", "c");
        map.put("c", "d");
        map.put("d", "e");
        map.put("e", "f");
        map.put("f", "g");
        map.put("g", "h");
        map.put("h", "i");
        map.put("i", "j");
        map.put("j", "k");
        map.put("k", "l");
        map.put("l", "m");
        map.put("m", "n");
        map.put("n", "o");
        map.put("o", "p");
        map.put("p", "q");
        map.put("q", "r");
        map.put("r", "s");
        map.put("s", "t");
        map.put("t", "u");
        map.put("u", "v");
        map.put("v", "w");
        map.put("w", "x");
        map.put("x", "y");
        map.put("y", "z");
        map.put("z", "a");
        assertEquals("b", map.get("a"));
        assertEquals("c", map.get("b"));
        assertEquals("d", map.get("c"));
        assertEquals("e", map.get("d"));
        assertEquals("f", map.get("e"));
        assertEquals("g", map.get("f"));
        assertEquals("h", map.get("g"));
        assertEquals("i", map.get("h"));
        assertEquals("j", map.get("i"));
        assertEquals("k", map.get("j"));
        assertEquals("l", map.get("k"));
        assertEquals("m", map.get("l"));
        assertEquals("n", map.get("m"));
        assertEquals("o", map.get("n"));
        assertEquals("p", map.get("o"));
        assertEquals("q", map.get("p"));
        assertEquals("r", map.get("q"));
        assertEquals("s", map.get("r"));
        assertEquals("t", map.get("s"));
        assertEquals("u", map.get("t"));
        assertEquals("v", map.get("u"));
        assertEquals("w", map.get("v"));
        assertEquals("x", map.get("w"));
        assertEquals("y", map.get("x"));
        assertEquals("z", map.get("y"));
        assertEquals("a", map.get("z"));
    }


    @Test
    void largeStringKey() {
        Map<String, String> map = createMap();
        String largeKey = "abcdefghijklmnopqrstuvwxyz0123456789";

        map.put(largeKey, "value");
        assertEquals("value", map.get(largeKey));

        map.put(largeKey, "updated value");
        assertEquals("updated value", map.get(largeKey));
    }

    @Test
    void veryLargeStringKey() {
        Map<String, String> map = createMap();
        String largeKey = "abcdefghijklmnopqrstuvwxyz0123456789";
        String veryLargeKey = largeKey.repeat(100);

        map.put(veryLargeKey, "value");
        assertEquals("value", map.get(veryLargeKey));

        map.put(veryLargeKey, "updated value");
        assertEquals("updated value", map.get(veryLargeKey));
    }

    @Test
    void dateKey() {
        Map<java.util.Date, String> map = createMap();
        java.util.Date date = new java.util.Date();
        map.put(date, "value");
        assertEquals("value", map.get(date));
    }
}
