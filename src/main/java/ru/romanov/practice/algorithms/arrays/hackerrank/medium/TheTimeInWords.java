package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheTimeInWords {

    public static void main(String[] args) {

        String result1 = timeInWords(5, 47);
        String expectedResult1 = "thirteen minutes to six";
        System.out.println("Result: " + result1 + ", expected: " + expectedResult1);

        String result2 = timeInWords(7, 29);
        String expectedResult2 = "twenty nine minutes past seven";
        System.out.println("Result: " + result2 + ", expected: " + expectedResult2);

        String result3 = timeInWords(5, 30);
        String expectedResult3 = "half past five";
        System.out.println("Result: " + result3 + ", expected: " + expectedResult3);

        String result4 = timeInWords(12, 48);
        String expectedResult4 = "twelve minutes to one";
        System.out.println("Result: " + result4 + ", expected: " + expectedResult4);
    }

    public static String timeInWords(int h, int m) {

        Map<Integer, String> digitsMap = new HashMap<>(Map.of(
                1, "one",
                2, "two",
                3, "three",
                4, "four",
                5, "five",
                6, "six",
                7, "seven",
                8, "eight",
                9, "nine",
                10, "ten"));
        digitsMap.put(11, "eleven");
        digitsMap.put(12, "twelve");
        digitsMap.put(13, "thirteen");
        digitsMap.put(14, "fourteen");
        digitsMap.put(15, "fifteen");
        digitsMap.put(16, "sixteen");
        digitsMap.put(17, "seventeen");
        digitsMap.put(18, "eighteen");
        digitsMap.put(19, "nineteen");
        digitsMap.put(20, "twenty");

        String minutesPart1;
        String minutesPart2;
        String hoursPart;
        String relativePart;
        String oclockPart;

        hoursPart = m <= 30
                ? digitsMap.get(h)
                : h < 12
                    ? digitsMap.get(h + 1)
                    : digitsMap.get(1);
        minutesPart1 = m == 0
                ? ""
                : m % 30 == 0
                    ? "half"
                    : m % 15 == 0
                        ? "quarter"
                        : convertDigits(Math.min(m, 60 - m), digitsMap);
        minutesPart2 = m % 15 == 0
                ? ""
                : m == 1
                    ? "minute"
                    : "minutes";
        relativePart = m == 0
                ? ""
                : m > 0 & m <= 30
                    ? "past"
                    : "to";
        oclockPart = m == 0 ? "o' clock" : "";

        return Stream.of(minutesPart1, minutesPart2, relativePart, hoursPart, oclockPart)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
    }

    private static String convertDigits(int m, Map<Integer, String> digitsMap) {
        if (m > 20) {
            return digitsMap.get(20) + " " + digitsMap.get(m - 20);
        } else {
            return digitsMap.get(m);
        }
    }

}
