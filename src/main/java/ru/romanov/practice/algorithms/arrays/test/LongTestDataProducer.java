package ru.romanov.practice.algorithms.arrays.test;

import java.util.Random;

public class LongTestDataProducer implements SortTestDataProducer<Long[]> {

    @Override
    public Long[] getUnsorted(int size, long min, long max) {
        Random rnd = new Random();
        return rnd.longs(size, min, max).boxed().toArray(Long[]::new);
    }

}
