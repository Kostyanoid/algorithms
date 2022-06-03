package ru.romanov.practice.algorithms.arrays.test;

public interface SortTestDataProducer<T> {

    default T getUnsorted(int size) {
        return getUnsorted(size, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    default T getUnsorted(int size, long max) {
        return getUnsorted(size, 0, max);
    }

    T getUnsorted(int size, long min, long max);
}
