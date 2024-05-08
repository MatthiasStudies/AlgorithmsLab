package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseArrayTest {
    @Test
    void testReverseIntArray() {
        ReverseArray<Integer> reverseArray = new ReverseArray<>();
        Integer[] a = {1, 2, 3, 4, 5};

        reverseArray.reverse(a, 0, 4);

        assertArrayEquals(a, new Integer[]{5, 4, 3, 2, 1});
    }

    @Test
    void testReverseStringArray() {
        ReverseArray<String> reverseArray = new ReverseArray<>();
        String[] a = {"a", "b", "c"};

        reverseArray.reverse(a, 0, 2);

        assertArrayEquals(a, new String[]{"c", "b", "a"});
    }

    @Test
    void testReverseHalfIntArray() {
        ReverseArray<Integer> reverseArray = new ReverseArray<>();
        Integer[] a = {1, 2, 3, 4, 5};

        reverseArray.reverse(a, 0, 2);

        assertArrayEquals(a, new Integer[]{3, 2, 1, 4, 5});
    }

    @Test
    void testNullArray() {
        ReverseArray<Integer> reverseArray = new ReverseArray<>();
        Integer[] a = null;

        assertThrows(NullPointerException.class, () -> reverseArray.reverse(a, 0, 2));
    }

    @Test
    void testNegativeFrom() {
        ReverseArray<Integer> reverseArray = new ReverseArray<>();
        Integer[] a = {1, 2, 3, 4, 5};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> reverseArray.reverse(a, -1, 2));
    }

    @Test
    void testNegativeTo() {
        ReverseArray<Integer> reverseArray = new ReverseArray<>();
        Integer[] a = {1, 2, 3, 4, 5};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> reverseArray.reverse(a, 0, -2));
    }

    @Test
    void testOutOfBoundsFrom() {
        ReverseArray<Integer> reverseArray = new ReverseArray<>();
        Integer[] a = {1, 2, 3, 4, 5};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> reverseArray.reverse(a, 6, 2));
    }
}
