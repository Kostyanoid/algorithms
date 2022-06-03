package ru.romanov.practice.algorithms.arrays.sort.method;

import java.lang.reflect.Array;

public abstract class AbstractArraySortMethod<T> implements ArraySortMethod<T> {

    @SuppressWarnings("unchecked")
    public T[] sort(T[] array) {
        assert array != null : "Cannot sort null array";

        if (array.length < 2) return array;

        T[] sortingArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
        System.arraycopy(array, 0, sortingArray, 0, array.length);

        return doSort(sortingArray);
    }

    protected abstract T[] doSort(T[] array);

    protected void swap(T[] array, int ind1, int ind2) {
        assert array != null : "Cannot do swap in null array";
        assert ind1 >= 0 && ind1 < array.length : String.format("Index 1 '%d' is out of range", ind1);
        assert ind2 >= 0 && ind2 < array.length : String.format("Index 2 '%d' is out of range", ind2);

        T temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }
}
