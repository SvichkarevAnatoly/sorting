package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

public class InsertionSort {
    public static int[] sort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            while (j >= 0 && a[j] > a[j + 1]) {
                swap(a, j, j + 1);
                j--;
            }
        }
        return a;
    }
}
