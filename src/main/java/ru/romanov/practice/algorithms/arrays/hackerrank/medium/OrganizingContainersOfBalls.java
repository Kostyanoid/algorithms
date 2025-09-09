package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.HashMap;
import java.util.List;

public class OrganizingContainersOfBalls {

    public static void main(String[] args) {

        var data1 = List.of(List.of(0, 2, 1), List.of(1, 1, 1), List.of(2, 0, 0));
        var result1 = organizingContainers(data1);
        var expectedResult1 = "Possible";
        System.out.println("Result: " + result1 + ", expected: " + expectedResult1);
    }

    public static String organizingContainers(List<List<Integer>> container) {

        int n = container.size();

        var ballCounts = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int ballTypeCount = 0;
            int containerCount = 0;
            for (int j = 0; j < n; j++) {
                ballTypeCount += container.get(j).get(i);
                containerCount += container.get(i).get(j);
            }

            ballCounts.compute(ballTypeCount, (k, v) -> v == null ? 1 : v + 1);
            ballCounts.compute(containerCount, (k, v) -> v == null ? -1 : v - 1);
        }

        return ballCounts.values().stream().anyMatch(v -> v != 0) ? "Impossible" : "Possible";
    }
}
