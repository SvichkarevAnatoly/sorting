package ru.mail.polis.sort;

import java.util.Random;

import static ru.mail.polis.sort.Helper.swap;

public class QuickSort3PartRandom {
    private static Random rand = new Random();

    public static int[] sort(int[] a) {
        sort(a, 0, a.length - 1);
        return a;
    }

    private static void sort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int tmp = rand.nextInt(r - l) + l;
        int pivot = a[tmp];
        int b = l;
        int j = l;

        swap(a, l, tmp);

        for (int i = l + 1; i <= r; i++) {
            if (a[i] < pivot) {
                swap(a, ++j, i);
            } else if (a[i] == pivot) {
                swap(a, i, ++j);
                swap(a, ++b, j);
            }
        }

        int del = j;
        for (int i = l; i <= b; i++) {
            swap(a, i, j);
            j--;
        }

        sort(a, l, j);
        sort(a, del + 1, r);
    }
}
