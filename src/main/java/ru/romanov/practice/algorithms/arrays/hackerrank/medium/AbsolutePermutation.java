package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbsolutePermutation {

    public static void main(String[] args) {

        checkResult(4, 2, List.of(3, 4, 1, 2));
        checkResult(2, 1, List.of(2, 1));
        checkResult(3, 0, List.of(1, 2, 3));
        checkResult(3, 2, List.of(-1));
        checkResult(10, 1, List.of(2, 1, 4, 3, 6, 5, 8, 7, 10, 9));
    }

    public static List<Integer> absolutePermutation(int n, int k) {

        Set<Integer> originals = Stream.iterate(1, i -> i + 1).limit(n).collect(Collectors.toSet());
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            int pi1 = i - k > 0 ? i - k : Integer.MAX_VALUE;
            int pi2 = i + k <= n ? i + k : Integer.MAX_VALUE;

            int min = Math.min(pi1, pi2);
            int candidate = originals.contains(min) ? min : Math.max(pi1, pi2);
            if (candidate == Integer.MAX_VALUE || !originals.contains(candidate)) {
                return List.of(-1);
            }

            originals.remove(candidate);
            result.add(candidate);
        }

        return result;
    }

    private static void checkResult(int n, int k, List<Integer> expectedResult) {
        List<Integer> actualResult = absolutePermutation(n, k);
        String checkResult = expectedResult.equals(actualResult) ? "CORRECT" : "FAILED";
        System.out.println("n = %d, k = %d, expected = %s, actual = %s: %s".formatted(n, k, expectedResult, actualResult, checkResult));
    }
}
