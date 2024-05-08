package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Sort;

public class MergesortTest extends StableSortTest{
    @Override
    protected <E extends Comparable<E>> Sort<E> createSort() {
        return new Mergesort<>();
    }
}
