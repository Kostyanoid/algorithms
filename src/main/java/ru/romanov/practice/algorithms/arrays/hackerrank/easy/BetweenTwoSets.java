package ru.romanov.practice.algorithms.arrays.hackerrank.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BetweenTwoSets {

    public static void main(String[] args) {

        for (TestCase ts : getTestCases()) {
            checkResult(getTotalX(ts.getA(), ts.getB()), ts.getExpectedResult());
        }

    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        List<Integer> af = new ArrayList<Integer>(a);

        int f = 2;
        int max_a = Integer.MIN_VALUE;
        boolean nextFactorFound = false;
        List<Integer> a_factors = new LinkedList<>();
        do {
            boolean nextFactorAdded = false;
            for (int i = 0; i < af.size(); i++) {

                if (af.get(i) > max_a) {
                    max_a = af.get(i);
                }

                int next_af = af.get(i);
                if (next_af % f == 0) {
                    af.set(i, next_af / f);
                    nextFactorFound = true;
                    if (!nextFactorAdded) {
                        a_factors.add(f);
                        nextFactorAdded = true;
                    }
                }
            }
            if (!nextFactorFound) {
                f++;
            }
            nextFactorFound = false;
        } while (f <= max_a);

        int lcm = 1;
        for (int i = 0; i < a_factors.size(); i++) {
            lcm = lcm * a_factors.get(i);
        }

        int result = 0;
        int lcmMultiplier = 1;
        int bMin = Integer.MAX_VALUE;
        boolean nextGcdFound = true;
        while ((lcm * lcmMultiplier) <= bMin) {
            for (int i = 0; i < b.size(); i++) {
                if (bMin > b.get(i)) {
                    bMin = b.get(i);
                }
                if (b.get(i) % (lcm * lcmMultiplier) != 0) {
                    nextGcdFound = false;
                    break;
                }
            }

            if (nextGcdFound) {
                result++;
            }
            lcmMultiplier++;
            nextGcdFound = true;
        }

        return result;
    }

    private static List<TestCase> getTestCases() {
        return List.of(
                new TestCase(List.of(3, 4), List.of(24, 48), 2),
                new TestCase(List.of(2, 4), List.of(16, 32, 96), 3),
                new TestCase(List.of(1), List.of(100), 9)
        );
    }

    private static void checkResult(int actualResult, int expectedResult) {
        if (actualResult != expectedResult) {
            System.out.println("Wrong result! Actual result = '%d', Expected result = '%d'".formatted(actualResult, expectedResult));
        } else {
            System.out.println("Correct result. Actual result = '%d', Expected result = '%d'".formatted(actualResult, expectedResult));
        }
    }

    private static class TestCase {
        private final List<Integer> a;
        private final List<Integer> b;
        private final int expectedResult;

        public TestCase(List<Integer> a, List<Integer> b, int expectedResult) {
            this.a = a;
            this.b = b;
            this.expectedResult = expectedResult;
        }

        public List<Integer> getA() {
            return a;
        }

        public List<Integer> getB() {
            return b;
        }

        public int getExpectedResult() {
            return expectedResult;
        }
    }
}
