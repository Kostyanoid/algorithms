package ru.romanov.practice.algorithms.arrays.hackerrank.easy;

public class Kangaroo {

    public static void main(String[] args) {
        String result1 = kangaroo(0, 3, 4, 2);
        String expectedResult1 = "YES";
        System.out.println("Result: " + result1 + ", expected: " + expectedResult1);

        String result2 = kangaroo(0, 2, 5, 3);
        String expectedResult2 = "NO";
        System.out.println("Result: " + result2 + ", expected: " + expectedResult2);

        String result3 = kangaroo(21, 6, 47, 3);
        String expectedResult3 = "NO";
        System.out.println("Result: " + result3 + ", expected: " + expectedResult3);

        String result4 = kangaroo(28, 8, 96, 2);
        String expectedResult4 = "NO";
        System.out.println("Result: " + result4 + ", expected: " + expectedResult4);

        String result5 = kangaroo(43, 2, 70, 2);
        String expectedResult5 = "NO";
        System.out.println("Result: " + result5 + ", expected: " + expectedResult5);
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        if (v2 >= v1) {
            return "NO";
        }

        int k = (x2 - x1) / (v1 - v2);
        int m = (x2 - x1) % (v1 - v2);
        if (k > 0 && m == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
