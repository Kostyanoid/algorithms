package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.Arrays;

public class BiggerIsGreater {

    public static void main(String[] args) {
        String result1 = biggerIsGreater("ab");
        String expectedResult1 = "ba";
        System.out.println("Result: " + result1 + ", expected: " + expectedResult1);

        String result2 = biggerIsGreater("bb");
        String expectedResult2 = "no answer";
        System.out.println("Result: " + result2 + ", expected: " + expectedResult2);

        String result3 = biggerIsGreater("hefg");
        String expectedResult3 = "hegf";
        System.out.println("Result: " + result3 + ", expected: " + expectedResult3);

        String result4 = biggerIsGreater("dkhc");
        String expectedResult4 = "hcdk";
        System.out.println("Result: " + result4 + ", expected: " + expectedResult4);

    }

    public static String biggerIsGreater(String w) {

        if (w.length() <= 1) return "no answer";

        char[] chars = w.toCharArray();

        char k = 0;
        int i = chars.length - 1;
        while (i >= 0 && k <= chars[i]) {
            k = chars[i];
            i--;
        }

        if (i < 0) return "no answer";

        k = chars[i];
        char m = chars[i + 1];
        int mj = i + 1;
        for (int j = i + 2; j < chars.length; j++) {
            if (chars[j] < m && chars[j] > k) {
                m = chars[j];
                mj = j;
            }
        }

        chars[i] = m;
        chars[mj] = k;

        char[] sortedTail = Arrays.copyOfRange(chars, i + 1, chars.length);
        Arrays.sort(sortedTail);

        System.arraycopy(sortedTail, 0, chars, i + 1, sortedTail.length);

        return String.copyValueOf(chars);
    }
}
