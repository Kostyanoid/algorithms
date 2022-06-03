package ru.romanov.practice.algorithms.arrays.sort.method;

public class LongArrayBubbleSortMethod extends AbstractArraySortMethod<Long> {

    public Long[] doSort(Long[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }

        return array;
    }

}
