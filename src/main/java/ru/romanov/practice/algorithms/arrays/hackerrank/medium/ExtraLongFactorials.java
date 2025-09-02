package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.math.BigInteger;

public class ExtraLongFactorials {

    public static void main(String[] args) {

        int n = 25;
        extraLongFactorials(n);
    }


    public static void extraLongFactorials(int n) {
        BigInteger factorial = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);
    }
}
