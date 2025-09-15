package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.Map;
import java.util.TreeMap;

public class Encryption {

    public static void main(String[] args) {

        String result1 = encryption("chillout");
        String expectedResult1 = "clu hlt io";
        System.out.println("Result: " + result1 + ", expected: " + expectedResult1);

    }

    public static String encryption(String s) {

        int l = s.length();

        if (l == 1) {
            return s;
        }

        TreeMap<Integer, Integer> squares = new TreeMap<>(Map.of(1, 1, 4, 2, 9, 3, 16, 4, 25, 5, 36, 6, 49, 7, 64, 8, 81, 9));

        int minRows = squares.floorEntry(l).getValue();
        int maxCols = squares.ceilingEntry(l).getValue();

        if (minRows * maxCols < l) {
            minRows++;
        }

        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < maxCols; col++) {
            int row = 0;
            while (row < minRows && row * maxCols + col < l) {
                sb.append(s.charAt(row * maxCols + col));
                row++;
            }
            sb.append(" ");
        }

        return sb.toString();
    }
}
