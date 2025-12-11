package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.ArrayList;
import java.util.List;

public class LarrysArray {

    public static void main(String[] args) {
        List<Integer> test1 = new ArrayList<>(List.of(1, 6, 5, 2, 4, 3));
        System.out.println(test1 + ": " + larrysArray(test1));
        List<Integer> test2 = new ArrayList<>(List.of(3, 1, 2));
        System.out.println(test2 + ": " + larrysArray(test2));
        List<Integer> test3 = new ArrayList<>(List.of(1, 3, 4, 2));
        System.out.println(test3 + ": " + larrysArray(test3));
        List<Integer> test4 = new ArrayList<>(List.of(1, 2, 3, 5, 4));
        System.out.println(test4 + ": " + larrysArray(test4));
        List<Integer> test5 = new ArrayList<>(List.of(9, 6, 8, 12, 3, 7, 1, 11, 10, 2, 5, 4));
        System.out.println(test5 + ": " + larrysArray(test5));
    }

    public static String larrysArray(List<Integer> A) {

        int sortedIndex = -1;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) == i + 1) {
                sortedIndex = i;
            } else {
                break;
            }
        }

        int i = sortedIndex + 1;
        int step = 1;
        while (true) {

            if (i == sortedIndex + 1 && A.get(i) == i + 1) {
                sortedIndex = i;
            }

            if (i == A.size() - 2) {
                if (sortedIndex >= A.size() - 3) {
                    return  (A.get(i) == i + 1 && A.get(i + 1) == i + 2) ? "YES" : "NO";
                }
                step *= -1;
                i += step;
            }

            if (i < sortedIndex) {
                step *= -1;
                i += step;
            }

            if (A.get(i) > A.get(i + 1) || A.get(i) > A.get(i + 2)) {
                permute(A, i);
            } else {
                i = i + step;
            }
        }
    }

    private static void permute(List<Integer> A, int start) {
        var temp = A.get(start);
        A.set(start, A.get(start + 1));
        A.set(start + 1, A.get(start + 2));
        A.set(start + 2, temp);
    }
}