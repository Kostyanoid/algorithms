package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.ArrayList;
import java.util.List;

public class AbsolutePermutation {

    public static void main(String[] args) {

        checkResult(4, 2, List.of(3, 4, 1, 2));
        checkResult(2, 1, List.of(2, 1));
        checkResult(3, 0, List.of(1, 2, 3));
        checkResult(3, 2, List.of(-1));
        checkResult(10, 1, List.of(2, 1, 4, 3, 6, 5, 8, 7, 10, 9));
    }

    public static List<Integer> absolutePermutation(int n, int k) {

        byte[] used = new byte[n];

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            if (i - k > 0 && used[i - k - 1] == 0) {
                result.add(i - k);
                used[i - k - 1] = 1;
            } else if (i + k <= n && used[i + k - 1] == 0) {
                result.add(i + k);
                used[i + k - 1] = 1;
            } else {
                return List.of(-1);
            }
        }

        return result;
    }

    private static void checkResult(int n, int k, List<Integer> expectedResult) {
        List<Integer> actualResult = absolutePermutation(n, k);
        String checkResult = expectedResult.equals(actualResult) ? "CORRECT" : "FAILED";
        System.out.println("n = %d, k = %d, expected = %s, actual = %s: %s".formatted(n, k, expectedResult, actualResult, checkResult));
    }
}
