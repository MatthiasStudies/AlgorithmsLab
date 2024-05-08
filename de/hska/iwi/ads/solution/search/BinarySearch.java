package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<T extends Comparable<T>> implements Search<T> {
    @Override
    public int search(T[] a, T key, int left, int right) {
        if (a == null) {
            throw new NullPointerException();
        }
        if (left > right) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (key.compareTo(a[left]) < 0) {
            return left - 1;
        } else if (key.compareTo(a[right]) > 0) {
            return right + 1;
        }

        return binSearch(a, key, left, right);

    }

    private int binSearch(T[] a, T key, int left, int right){
        int middle = (left + right) / 2;

        if (left > right) {
            return left;
        }

        if (left == right) {
            if (key.compareTo(a[left]) < 0) {
                return left - 1;
            } else if (key.compareTo(a[left]) > 0) {
                return left + 1;
            } else {
                return left;
            }
        }

        int diff = key.compareTo(a[middle]);

        if (diff < 0) {
            return binSearch(a, key, left, middle - 1);
        } else if (diff > 0) {
            return binSearch(a, key, middle + 1, right);
        } else {
            return binSearch(a, key, left, middle);
        }

    }
}
