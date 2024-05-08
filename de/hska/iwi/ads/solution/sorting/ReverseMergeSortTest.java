package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseMergeSortTest extends StableSortTest{
    @Override
    protected <E extends Comparable<E>> Sort<E> createSort() {
        return new ReverseMergeSort<>();
    }

    @Test
    void testPerformance() {
        Sort<Integer> sort = createSort();
        Integer[] a = new Integer[1_000_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i;
        }
        long start = System.currentTimeMillis();
        sort.sort(a);
        long end = System.currentTimeMillis();
        long duration = end - start;

        for (int i = 0; i < a.length; i++) {
            assertEquals(i + 1, a[i]);
        }

        assertTrue(duration < 2500); // This has 100% coverage (thx java bytecode)
    }
}
