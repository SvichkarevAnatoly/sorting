package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

public class QuickSort {
    public static int[] sort(int[] a) {
        sort(a, 0, a.length - 1);
        return a;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        final int p = partition(a, lo, hi);
        sort(a, lo, p);
        sort(a, p + 1, hi);
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) {
                swap(a, i++, j--);
            }
        }
        return j;
    }
}
