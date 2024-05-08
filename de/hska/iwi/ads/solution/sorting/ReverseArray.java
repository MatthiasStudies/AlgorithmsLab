package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {
    @Override
    public void reverse(E[] a, int from, int to) {
        if (a == null) {
            throw new NullPointerException();
        }
        if (from < 0 || to < 0 || from > to) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = from; i <= (from + to) / 2; i++) {
            E temp = a[i];
            a[i] = a[to - i + from];
            a[to - i + from] = temp;
        }
    }
}
