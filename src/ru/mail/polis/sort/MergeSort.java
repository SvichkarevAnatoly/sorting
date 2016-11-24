package ru.mail.polis.sort;

import static java.lang.Math.min;

public class MergeSort {
    public static int[] sort(int[] a) {
        for (int i = 1; i < a.length; i *= 2) {
            for (int j = 0; j < a.length - i; j += 2 * i) {
                merge(a, j, j + i, min(j + 2 * i, a.length));
            }
        }
        return a;
    }

    private static void merge(int[] a, int l, int m, int r) {
        int it1 = 0;
        int it2 = 0;
        int[] result = new int[r - l];

        while (l + it1 < m && m + it2 < r) {
            if (a[l + it1] < a[m + it2]) {
                result[it1 + it2] = a[l + it1];
                it1++;
            } else {
                result[it1 + it2] = a[m + it2];
                it2++;
            }
        }

        while (l + it1 < m) {
            result[it1 + it2] = a[l + it1];
            it1++;
        }
        while (m + it2 < r) {
            result[it1 + it2] = a[m + it2];
            it2++;
        }

        System.arraycopy(result, 0, a, l, it1 + it2);
    }
}
