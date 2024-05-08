package de.hska.iwi.ads.solution.sorting;

public class Mergesort<E extends Comparable<E>> extends de.hska.iwi.ads.sorting.AbstractMergesort<E> {
    @Override
    protected void mergesort(E[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergesort(a, left, middle);
            mergesort(a, middle + 1, right);
            merge(a, left, middle, right);
        }
    }

    protected void merge(E[] a, int left, int middle, int right) {
        int l = left;
        int r = middle + 1;

        for (int i = left; i <= right; i++) {
            if (r > right || (l <= middle && a[l].compareTo(a[r]) <= 0)) {
                b[i] = a[l];
                l++;
            } else {
                b[i] = a[r];
                r++;
            }

        }

        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }
}
