package ru.mail.polis.sort.valid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.BubbleSort;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.InsertionSort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.mail.polis.sort.valid.IsSorted.isSorted;

@RunWith(value = Parameterized.class)
public class Tester {
    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
            {0},
            {0, 0, 0, 0},
            {4, 3, 2, 1},
            {0, 1, 1, 0},
            {1},
            {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
            Helper.gen(1),
            Helper.gen(10),
            Helper.gen(100),
            Helper.gen(1000),
            Helper.gen(10000),
        });
    }

    @Test
    public void bubbleSort() throws IOException {
        assertThat(BubbleSort.sort(array), isSorted());
    }

    @Test
    public void insertionSort() throws IOException {
        assertThat(InsertionSort.sort(array), isSorted());
    }

}
