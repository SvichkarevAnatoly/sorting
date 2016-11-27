package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

public class ShellSort {
    public static int[] sort(int[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
        return a;
    }
}
