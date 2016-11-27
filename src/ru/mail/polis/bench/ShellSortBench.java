package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.ShellSort;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ShellSortBench {

    private int[] a3;
    private int[] a4;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a3 = Helper.gen(1000);
        a4 = Helper.gen(10000);
    }

    @Benchmark
    public int[] measureShellSort1000() {
        return ShellSort.sort(a3);
    }

    @Benchmark
    public int[] measureShellSort10000() {
        return ShellSort.sort(a4);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ShellSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}