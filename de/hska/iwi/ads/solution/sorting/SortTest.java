package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class SortTest {
    protected abstract <E extends Comparable<E>> Sort<E> createSort();

    @Test
    void testIntArraySort() {
        Sort<Integer> sort = createSort();
        Integer[] a = {2, 3, 4, 6, 1};

        sort.sort(a);

        assertArrayEquals(a, new Integer[]{1, 2, 3, 4, 6});
    }

    @Test
    void testIntArraySort2() {
        Sort<Integer> sort = createSort();
        Integer[] a = {2, 3, 4, 6, 1, 5};

        sort.sort(a);

        assertArrayEquals(a, new Integer[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void testIntArraySort3() {
        Sort<Integer> sort = createSort();
        Integer[] a = {1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};

        sort.sort(a);

        assertArrayEquals(a, new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
    }

    @Test
    void testStringArraySort() {
        Sort<String> sort = createSort();
        String[] a = {"b", "a", "c"};

        sort.sort(a);

        assertArrayEquals(a, new String[]{"a", "b", "c"});
    }

    @Test
    void testStringArraySort2() {
        Sort<String> sort = createSort();
        String[] a = {"b", "a", "e", "f", "i", "g", "h", "j", "c", "d"};

        sort.sort(a);

        assertArrayEquals(a, new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"});
    }

    @Test
    void testStringArraySort3(){
        Sort<String> sort = createSort();

        String[] a = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};

        sort.sort(a);

        assertArrayEquals(a, new String[]{"brown", "dog", "fox", "jumps", "lazy", "over", "quick", "the", "the"});
    }


    @Test
    void testEmptyArraySort() {
        Sort<Integer> sort = createSort();
        Integer[] a = {};

        sort.sort(a);

        assertArrayEquals(a, new Integer[]{});
    }

    @Test
    void testOneElementArraySort() {
        Sort<Integer> sort = createSort();
        Integer[] a = {1};

        sort.sort(a);

        assertArrayEquals(a, new Integer[]{1});
    }

    @Test
    void testSortedArraySort() {
        Sort<Integer> sort = createSort();
        Integer[] a = {1, 2, 3, 4, 5};

        sort.sort(a);

        assertArrayEquals(a, new Integer[]{1, 2, 3, 4, 5});
    }

    @Test
    void testNullArray() {
        Sort<Integer> sort = createSort();
        Integer[] a = null;

        assertThrows(NullPointerException.class, () -> sort.sort(a));
    }

    @Test
    void testNegativeNumber() {
        Sort<Integer> sort = createSort();
        Integer[] a = {-2, 1, 2, -6, 3, 4, 5, -9};

        sort.sort(a);

        assertArrayEquals(a, new Integer[]{-9, -6, -2, 1, 2, 3, 4, 5});
    }


}
