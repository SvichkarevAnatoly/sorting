package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.BubbleSort;
import ru.mail.polis.sort.Helper;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BubbleSortBench {

    private int[] a3;
    private int[] a4;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a3 = Helper.gen(1000);
        a4 = Helper.gen(10000);
    }

    @Benchmark
    public int[] measureShellSort1000() {
        return BubbleSort.sort(a3);
    }

    @Benchmark
    public int[] measureShellSort10000() {
        return BubbleSort.sort(a4);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BubbleSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
