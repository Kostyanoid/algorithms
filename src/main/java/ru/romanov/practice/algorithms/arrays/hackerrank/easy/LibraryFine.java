package ru.romanov.practice.algorithms.arrays.hackerrank.easy;

public class LibraryFine {

    public static void main(String[] args) {

        int result1 = libraryFine(9, 6, 2015, 6, 6, 2015);
        int expectedResult1 = 45;
        System.out.println("Result: " + result1 + ", expected: " + expectedResult1);

        int result2 = libraryFine(5, 5, 2014, 23, 2, 2014);
        int expectedResult2 = 1500;
        System.out.println("Result: " + result2 + ", expected: " + expectedResult2);

        int result3 = libraryFine(1, 1, 2015, 31, 12, 2014);
        int expectedResult3 = 10000;
        System.out.println("Result: " + result3 + ", expected: " + expectedResult3);
    }

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        int expectedDate = y2 * 10_000 + m2 * 100 + d2;
        int actualDate = y1 * 10_000 + m1 * 100 + d1;
        int delta = actualDate - expectedDate;

        if (delta <= 0) {
            return 0;
        } else if (delta < 100 ) {
            return delta * 15;
        } else if (delta < 10_000 && y1 == y2) {
            return (actualDate / 100 - expectedDate / 100) * 500;
        }

        return 10_000;
    }

}
