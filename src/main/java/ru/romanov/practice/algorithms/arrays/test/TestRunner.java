package ru.romanov.practice.algorithms.arrays.test;

import ru.romanov.practice.algorithms.arrays.sort.method.SortMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class TestRunner {

    private SortTestDataProducer<Long[]> testDataProducer = new LongTestDataProducer();
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private SortMethod<Long[]> method;
    private int repetitions = 5;
    private int warmUpRepetitions = 2;
    private int timeoutThreshold = 30;


    public TestRunner(SortMethod<Long[]> method) {
        this.method = method;
    }

    public SortMethod<Long[]> getMethod() {
        return method;
    }

    public void setMethod(SortMethod<Long[]> method) {
        this.method = method;
    }

    public void runSingle(int size) {
        Long[] unsortedArray = testDataProducer.getUnsorted(size, size);
        List<Long> attemptDurations = new ArrayList<>(repetitions);
        boolean isFailed = false;

        System.out.printf("Start test with array size: %d%n", size);
        long testStart = System.currentTimeMillis();
        for (int i = 0; i < repetitions; i++) {
            long attemptStart = System.currentTimeMillis();
            Future<Long[]> task = executor.submit(() -> method.sort(unsortedArray));
            try {
                task.get(timeoutThreshold, TimeUnit.SECONDS);
                long attemptEnd = System.currentTimeMillis();
                long duration = attemptEnd - attemptStart;
                System.out.printf("Attempt %d has finished in %d ms%n", i + 1, duration);
                attemptDurations.add(i, duration);
            } catch (TimeoutException | InterruptedException | ExecutionException e) {
                System.out.printf("Attempt %d has worked too long. It was interrupted after %d seconds.%n", i + 1, timeoutThreshold);
                isFailed = true;
                break;
            }
        }
        long testEnd = System.currentTimeMillis();
        System.out.printf("Test has finished in %d ms %n", testEnd - testStart);

        if (!isFailed) {
            long average = attemptDurations
                    .stream()
                    .skip(warmUpRepetitions)
                    .collect(Collectors.averagingLong(Long::longValue))
                    .longValue();
            System.out.printf("Average time by last %d attempts: %d%n", repetitions - warmUpRepetitions, average);
        }
    }

    public void runBunch() {

    }

    public void shutdown() {
        executor.shutdown();
    }
}
