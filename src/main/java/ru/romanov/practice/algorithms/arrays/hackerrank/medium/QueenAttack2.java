package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static java.lang.Math.*;

public class QueenAttack2 {

    public static void main(String[] args) {

        int result1 = queensAttack(4, 0, 4, 4, List.of());
        int expectedResult1 = 9;
        System.out.println("Result: " + result1 + ", expected: " + expectedResult1);

        int result2 = queensAttack(100, 100, 48, 81, List.of(List.of(54, 87), List.of(64, 97), List.of(42, 75), List.of(32, 65), List.of(42, 87), List.of(32, 97), List.of(54, 75), List.of(64, 65), List.of(48, 87), List.of(48, 75), List.of(54, 81), List.of(42, 81), List.of(45, 17), List.of(14, 24), List.of(35, 15), List.of(95, 64), List.of(63, 87), List.of(25, 72), List.of(71, 38), List.of(96, 97), List.of(16, 30), List.of(60, 34), List.of(31, 67), List.of(26, 82), List.of(20, 93), List.of(81, 38), List.of(51, 94), List.of(75, 41), List.of(79, 84), List.of(79, 65), List.of(76, 80), List.of(52, 87), List.of(81, 54), List.of(89, 52), List.of(20, 31), List.of(10, 41), List.of(32, 73), List.of(83, 98), List.of(87, 61), List.of(82, 52), List.of(80, 64), List.of(82, 46), List.of(49, 21), List.of(73, 86), List.of(37, 70), List.of(43, 12), List.of(94, 28), List.of(10, 93), List.of(52, 25), List.of(50, 61), List.of(52, 68), List.of(52, 23), List.of(60, 91), List.of(79, 17), List.of(93, 82), List.of(12, 18), List.of(75, 64), List.of(69, 69), List.of(94, 74), List.of(61, 61), List.of(46, 57), List.of(67, 45), List.of(96, 64), List.of(83, 89), List.of(58, 87), List.of(76, 53), List.of(79, 21), List.of(94, 70), List.of(16, 10), List.of(50, 82), List.of(92, 20), List.of(40, 51), List.of(49, 28), List.of(51, 82), List.of(35, 16), List.of(15, 86), List.of(78, 89), List.of(41, 98), List.of(70, 46), List.of(79, 79), List.of(24, 40), List.of(91, 13), List.of(59, 73), List.of(35, 32), List.of(40, 31), List.of(14, 31), List.of(71, 35), List.of(96, 18), List.of(27, 39), List.of(28, 38), List.of(41, 36), List.of(31, 63), List.of(52, 48), List.of(81, 25), List.of(49, 90), List.of(32, 65), List.of(25, 45), List.of(63, 94), List.of(89, 50), List.of(43, 41)));
        int expectedResult2 = 40;
        System.out.println("Result: " + result2 + ", expected: " + expectedResult2);

        int result3 = queensAttack(88587, 9, 20001, 20003,
                List.of(List.of(20001, 20002),
                        List.of(20001, 20004),
                        List.of(20000, 20003),
                        List.of(20002, 20003),
                        List.of(20000, 20004),
                        List.of(20000, 20002),
                        List.of(20002, 20004),
                        List.of(20002, 20002),
                        List.of(564, 323)));
        int expectedResult3 = 0;
        System.out.println("Result: " + result3 + ", expected: " + expectedResult3);

        int result4 = queensAttack(5, 3, 4, 3, List.of(
                List.of(5, 5),
                List.of(4, 2),
                List.of(2, 3)));
        int expectedResult4 = 10;
        System.out.println("Result: " + result4 + ", expected: " + expectedResult4);
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {

        int potentialAttacked = (n - 1) * 3 + min(min(r_q - 1, n - r_q), min(c_q - 1, n - c_q)) * 2;

        var processedObstacles = new HashSet<List<Integer>>();
        var blockedCells = new HashMap<List<Integer>, Integer>();

        for (int i = 0; i < k; i++) {
            if (processedObstacles.contains(obstacles.get(i))) {
                continue;
            }

            var obstacle = obstacles.get(i);
            int obstacle_r = obstacle.get(0);
            int obstacle_c = obstacle.get(1);

            int d_r = r_q - obstacle_r;
            int d_c = c_q - obstacle_c;

            int potentialBlocked = 0;
            if (d_r == 0 || d_c == 0 || abs(d_r) == abs(d_c)) {
                d_r = d_r == 0 ? 0 : d_r / abs(d_r);
                d_c = d_c == 0 ? 0 : d_c / abs(d_c);
                int pb_r = (1 - d_r) / 2 * (n + 1) + d_r * obstacle_r;
                int pb_c = (1 - d_c) / 2 * (n + 1) + d_c * obstacle_c;
                potentialBlocked = d_c == 0 || d_r == 0 ? abs(d_r) * pb_r + abs(d_c) * pb_c: min(pb_r, pb_c);

                List<Integer> key = List.of(d_r, d_c);
                int value = blockedCells.get(key) == null ? 0 : blockedCells.get(key);
                blockedCells.put(key, max(value, potentialBlocked));
            }

            processedObstacles.add(obstacle);
        }

        potentialAttacked -= blockedCells.values().stream().mapToInt(Integer::intValue).sum();

        return potentialAttacked;
    }
}
