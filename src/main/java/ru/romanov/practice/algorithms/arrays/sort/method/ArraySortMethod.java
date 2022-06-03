package ru.romanov.practice.algorithms.arrays.sort.method;

public interface ArraySortMethod<T> extends SortMethod<T[]> {

    T[] sort(final T[] array);
}
