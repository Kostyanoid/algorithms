package ru.romanov.practice.algorithms.arrays.hackerrank.easy;

public class SuperReducedString {

    public static void main(String[] args) {

        String result1 = superReducedString("aaabccddd");
        String expectedResult1 = "abd";
        System.out.println("Result: '" + result1 + "', expected: '" + expectedResult1 + "'");


        String result2 = superReducedString("aa");
        String expectedResult2 = "";
        System.out.println("Result: '" + result2 + "', expected: '" + expectedResult2 + "'");

        String result3 = superReducedString("abcddcba");
        String expectedResult3 = "";
        System.out.println("Result: '" + result3 + "', expected: '" + expectedResult3 + "'");
    }


    public static String superReducedString(String s) {

        char[] givenString = s.toCharArray();
        int length = givenString.length;
        if (length == 0) return "";
        if (length == 1) return s;

        char[] result = new char[length];

        int i = 0;
        for (int j = 0; j < length; j++) {
            if (result[i] == givenString[j]) {
                result[i] = 0;
                i = i == 0 ? 0 : i - 1;
            } else {
                i++;
                result[i] = givenString[j];
            }
        }

        String resultString = new String(result).trim();
        return resultString.isEmpty() ? "Empty String" : resultString;
    }
}
