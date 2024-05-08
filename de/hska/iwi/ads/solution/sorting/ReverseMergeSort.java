package de.hska.iwi.ads.solution.sorting;

public class ReverseMergeSort<E extends Comparable<E>> extends Mergesort<E>{

    @Override
    protected void merge(E[] a, int left, int middle, int right) {
        var reverse = new ReverseArray<E>();

        reverse.reverse(a, middle + 1, right);

        int l = left;
        int r = right;

        for(int i = left; i <= right; i++){
            if (a[l].compareTo(a[r]) <= 0){
                b[i] = a[l];
                l++;
            } else {
                b[i] = a[r];
                r--;
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }

    }
}
