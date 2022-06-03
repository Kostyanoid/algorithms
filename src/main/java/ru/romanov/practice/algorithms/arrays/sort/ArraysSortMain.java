package ru.romanov.practice.algorithms.arrays.sort;

import ru.romanov.practice.algorithms.arrays.sort.method.LongArrayBubbleSortMethod;
import ru.romanov.practice.algorithms.arrays.sort.method.SortMethod;
import ru.romanov.practice.algorithms.arrays.test.TestRunner;

public class ArraysSortMain {

    public static void main(String[] args) {

        SortMethod<Long[]> method = new LongArrayBubbleSortMethod();
        TestRunner runner = new TestRunner(method);

        runner.runSingle(50_000);
        runner.shutdown();
    }
}
