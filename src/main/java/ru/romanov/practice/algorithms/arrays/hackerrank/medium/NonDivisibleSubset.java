package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NonDivisibleSubset {

    public static void main(String[] args) {

        int result1 = nonDivisibleSubset(4 , List.of(19, 10, 12, 10, 24, 25, 22));
        int expectedResult1 = 3;
        System.out.println("Result: " + result1 + ", expected: " + expectedResult1);

        int result2 = nonDivisibleSubset(3 , List.of(1, 7, 2, 4));
        int expectedResult2 = 3;
        System.out.println("Result: " + result2 + ", expected: " + expectedResult2);

    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {

        var mods = new int[k];
        s.forEach(i -> mods[i % k]++);

        int res = mods[0] > 0 ? 1 : 0;
        for (int i = 1; i <= mods.length / 2; i++) {
            if (i == k - i) {
                res++;
            } else {
                res += Math.max(mods[i], mods[k - i]);
            }
        }

        return res;
    }
}
