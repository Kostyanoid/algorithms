package ru.romanov.practice.algorithms.arrays.hackerrank;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NonObviousAddition {
    
    public static void main(String[] args) {
        int originalbaseNumber = 999;
        List<Integer> baseNumber = extractBaseNumber(originalbaseNumber);
        System.out.println(baseNumber);
        
        checkResult(baseNumber, 1, originalbaseNumber, List.of(0, 0, 0, 1));
        checkResult(baseNumber, 0, originalbaseNumber, List.of(9, 9, 9));
        checkResult(baseNumber, 999, originalbaseNumber, List.of(8, 9, 9, 1));
        checkResult(baseNumber, 1000, originalbaseNumber, List.of(9, 9, 9, 1));
        checkResult(baseNumber, 12345678, originalbaseNumber, List.of(7,7,6,6,4,3,2,1));
        checkResult(baseNumber, -6, originalbaseNumber, List.of(3,9,9));

        originalbaseNumber = 1000;
        baseNumber = extractBaseNumber(originalbaseNumber);
        System.out.println("baseNumber: " + baseNumber);

        checkResult(baseNumber, 1, originalbaseNumber, List.of(1, 0, 0, 1));
        checkResult(baseNumber, -999, originalbaseNumber, List.of(1, 0, 0, 0));

    }


    private static List<Integer> extractBaseNumber(Integer number) {
        List<Integer> baseNumber = new LinkedList<>();
        while (number > 0) {
            baseNumber.add(number % 10);
            number /= 10;
        }
        return baseNumber;
    }

    private static List<Integer> addTwoNumbers(List<Integer> baseNumber, int number) {

        if (number == 0) {
            return List.copyOf(baseNumber);
        }

        List<Integer> result = new LinkedList<>();
        int carry = number;
        Iterator<Integer> iterator = baseNumber.iterator();
        int sum = 0;
        while (carry != 0) {
            if (iterator.hasNext()) {
                sum = iterator.next() + carry;
            } else {
                sum = carry;
            }
            result.add(sum % 10);
            carry = sum / 10;
        }

        if (result.size() < baseNumber.size()) {
            result.addAll(baseNumber.subList(result.size(), baseNumber.size()));
        }
        
        return result;
    }

    private static void checkResult(List<Integer> baseNumber, int number, int originalbaseNumber, List<Integer> expectedResult) {
        List<Integer> result = addTwoNumbers(baseNumber, number);
        if (result.equals(expectedResult)){
            System.out.println("result is correct: a = '%d', b = '%d', result = '%s'".formatted(originalbaseNumber, number, result));
        } else {
            System.out.println("result is not correct: a = '%d', b = '%d', result = '%s'".formatted(originalbaseNumber, number, result));
        }
    }
}
