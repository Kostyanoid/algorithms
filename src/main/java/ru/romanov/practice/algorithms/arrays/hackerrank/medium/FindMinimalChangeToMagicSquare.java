package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.*;

public class FindMinimalChangeToMagicSquare {

    public static void main(String[] args) {

        List<List<Integer>> example1 = List.of(List.of(4, 9, 2), List.of(3, 5, 7), List.of(8, 1, 5));
        System.out.println(example1);
        System.out.println(formingMagicSquare(example1));

        List<List<Integer>> example2 = List.of(List.of(4, 8, 2), List.of(4, 5, 7), List.of(6, 1, 6));
        System.out.println(example2);
        System.out.println(formingMagicSquare(example2));
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        List<List<Integer>> magicSquares = makeAllMagicSquares();
        List<Integer> candidate = flatting(s);

        return magicSquares.stream()
                .mapToInt(ms -> calculateDifference(candidate, ms))
                .min()
                .orElseThrow();
    }


    private static int calculateDifference(List<Integer> candidate, List<Integer> magicSquare) {
        int r = 0;
        for (int i = 0; i < magicSquare.size(); i++) {
            r += Math.abs(magicSquare.get(i) - candidate.get(i));
        }
        return r;
    }

    /**
     Square:
     1 2 3
     4 5 6
     7 8 9
     Array:
     1 2 3 4 5 6 7 8 9
     */

    private static List<Integer> flatting(List<List<Integer>> square) {
        ArrayList<Integer> flattedSquare = new ArrayList<>();
        flattedSquare.addAll(square.get(0));
        flattedSquare.addAll(square.get(1));
        flattedSquare.addAll(square.get(2));
        return flattedSquare;
    }

    private static List<List<Integer>> makeAllMagicSquares() {

        var baseSquare = List.of(8, 3, 4, 1, 5, 9, 6, 7, 2);
        var squares = new HashSet<List<Integer>>();
        
        squares.add(baseSquare);
        squares.add(reflectByVertical(baseSquare));
        squares.add(reflectByHorizontal(baseSquare));
        squares.add(reflectByFirstDiagonal(baseSquare));
        squares.add(reflectBySecondDiagonal(baseSquare));

        List<Integer> candidate = turnToRight(baseSquare);
        for (int i = 0; i < 7; i++) {
            if (isMagicSquare(candidate)) {
                squares.add(candidate);
                squares.add(reflectByVertical(candidate));
                squares.add(reflectByHorizontal(candidate));
                squares.add(reflectByFirstDiagonal(candidate));
                squares.add(reflectBySecondDiagonal(candidate));
            }
            candidate = turnToRight(candidate);
        }

//        squares.forEach(FindMinimalChangeToMagicSquare::printSquare);

        return new ArrayList<>(squares);
    }

    private static List<Integer> reflectByVertical(List<Integer> original) {
        List<Integer> result = new ArrayList<>(original);
        switchElements(result, 0, 6);
        switchElements(result, 1, 7);
        switchElements(result, 2, 8);
        return result;
    }

    private static List<Integer> reflectByHorizontal(List<Integer> original) {
        List<Integer> result = new ArrayList<>(original);
        switchElements(result, 0, 2);
        switchElements(result, 3, 5);
        switchElements(result, 6, 8);
        return result;
    }

    private static List<Integer> reflectByFirstDiagonal(List<Integer> original) {
        List<Integer> result = new ArrayList<>(original);
        switchElements(result, 1, 3);
        switchElements(result, 2, 6);
        switchElements(result, 5, 7);
        return result;
    }

    
    private static List<Integer> reflectBySecondDiagonal(List<Integer> original) {
        List<Integer> result = new ArrayList<>(original);
        switchElements(result, 3, 7);
        switchElements(result, 0, 8);
        switchElements(result, 1, 5);
        return result;
    }

    private static List<Integer> turnToRight(List<Integer> original) {
        List<Integer> result = new ArrayList<>(original);
        result.set(2, original.get(0));
        result.set(5, original.get(1));
        result.set(8, original.get(2));
        result.set(7, original.get(5));
        result.set(6, original.get(8));
        result.set(3, original.get(7));
        result.set(0, original.get(6));
        result.set(1, original.get(3));
        return result;
    }

    private static void switchElements(List<Integer> original, int index1, int index2) {
        Integer temp = original.get(index1);
        original.set(index1, original.get(index2));
        original.set(index2, temp);
    }

    private static boolean isMagicSquare(List<Integer> square) {
        
        return square.get(4) == 5 &&
            square.get(0) + square.get(1) + square.get(2) == 15 &&
            square.get(3) + square.get(4) + square.get(5) == 15 &&
            square.get(6) + square.get(7) + square.get(8) == 15 &&
            square.get(0) + square.get(3) + square.get(6) == 15 &&
            square.get(1) + square.get(4) + square.get(7) == 15 &&
            square.get(2) + square.get(5) + square.get(8) == 15 &&
            square.get(0) + square.get(4) + square.get(8) == 15 &&
            square.get(2) + square.get(4) + square.get(6) == 15;
    }

    private static void printSquare(List<Integer> square) {
        System.out.println(square.get(0) + " " + square.get(1) + " " + square.get(2));
        System.out.println(square.get(3) + " " + square.get(4) + " " + square.get(5));
        System.out.println(square.get(6) + " " + square.get(7) + " " + square.get(8));
        if (isMagicSquare(square)) {
            System.out.println("Magic square");
        } else {
            System.out.println("Not a magic square");
        }
        System.out.println();
    }
}
