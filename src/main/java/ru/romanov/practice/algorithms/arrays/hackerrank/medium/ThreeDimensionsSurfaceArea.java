package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.List;

public class ThreeDimensionsSurfaceArea {

    public static void main(String[] args) {

        List<List<Integer>> grid1 = List.of(List.of(1));
        System.out.println(grid1 + " - " + surfaceArea(grid1));


        List<List<Integer>> grid2 = List.of(
            List.of(1, 3, 4),
            List.of(2, 2, 3),
            List.of(1, 2, 4));
        System.out.println(grid2 + " - " + surfaceArea(grid2));
    }

    public static int surfaceArea(List<List<Integer>> A) {

        int cols = A.get(0).size();
        int rows = A.size();
        int area = 0;
        int zeros = 0;
        int rowArea = 0;
        int colArea = 0;

        for (int i = 0; i < rows; i++) {
            rowArea += A.get(i).get(0);
            for (int j = 0; j < cols - 1; j++) {
                if (A.get(i).get(j) == 0) {
                    zeros++;
                }
                rowArea += Math.abs(A.get(i).get(j) - A.get(i).get(j + 1));
            }
            rowArea += A.get(i).get(cols - 1);
        }

        for (int i = 0; i < cols; i++) {
            colArea += A.get(0).get(i);
            for (int j = 0; j < rows - 1; j++) {
                colArea += Math.abs(A.get(j).get(i) - A.get(j + 1).get(i));
            }
            colArea += A.get(rows - 1).get(i);
        }

        int bottomArea = cols * rows - zeros;
        area += colArea + rowArea + bottomArea * 2;

        return area;
    }

}
