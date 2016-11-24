package ru.mail.polis.sort.valid;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Arrays;

public class IsSorted extends TypeSafeMatcher<int[]> {
    private static final int MAX_PRINTED_SIZE = 10;

    private int[] a;
    private int i;

    @Override
    protected boolean matchesSafely(int[] a) {
        this.a = a;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                this.i = i;
                return false;
            }
        }
        return true;
    }

    @Override
    protected void describeMismatchSafely(int[] a, Description mismatchDescription) {
        if (a.length <= MAX_PRINTED_SIZE) {
            mismatchDescription.appendValue(a);
        } else {
            mismatchDescription.appendText("array");
        }
        mismatchDescription.appendText(" has ")
                .appendValue(a[i])
                .appendText(" greater than ")
                .appendValue(a[i + 1])
                .appendText(" (at index ").appendText(i + ")")
                .appendText(", which is inversion");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Sorted array");
        if (a.length <= MAX_PRINTED_SIZE) {
            final int[] cloneA = a.clone();
            Arrays.sort(cloneA);
            description.appendText(": ").appendValue(cloneA);
        }
    }

    public static IsSorted isSorted() {
        return new IsSorted();
    }
}
