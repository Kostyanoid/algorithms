package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.ArrayList;
import java.util.List;

public class BomberMan {

    public static void main(String[] args) {
        List<String> grid1 = List.of(
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        );
        System.out.println("grid: " + grid1 + "\nt = " + 3 + ": " + bomberMan1(3, grid1));

        List<String> grid2 = List.of(
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O..."
        );
        System.out.println("grid: " + grid2 + "\nt = " + 5 + ": " + bomberMan1(5, grid2));
    }

    public static List<String> bomberMan1(int n, List<String> grid) {

        byte[][] bGrid = new byte[grid.size()][grid.get(0).length()];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length(); j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    bGrid[i][j] = 1;
                }
            }
        }

        int reducedN = Math.min(n, n % 2 == 0 ? 2 : n % 4 + 4);
        int t = 1;
        int r = bGrid.length;
        int c = bGrid[0].length;
        while (t < reducedN) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bGrid[i][j]++;
                    if (t + 1 < reducedN && bGrid[i][j] == 2) {
                        bGrid[i][j] = 0;
                        if (i > 0) {
                            bGrid[i - 1][j] = 0;
                        }
                        if (j > 0) {
                            bGrid[i][j - 1] = 0;
                        }
                        if (i < r - 1 && bGrid[i + 1][j] == 0) {
                            bGrid[i + 1][j] = -1;
                        }
                        if (j < c - 1 && bGrid[i][j + 1] == 0) {
                            bGrid[i][j + 1] = -1;
                        }
                    }
                }
            }
            t += 2;
        }

        List<String> resultGrid = new ArrayList<>(grid.size());
        for (int i = 0; i < grid.size(); i++) {
            char[] row = new char[grid.get(0).length()];
            for (int j = 0; j < grid.get(0).length(); j++) {
                row[j] = bGrid[i][j] == 0 ? '.' : 'O';
            }
            resultGrid.add(String.valueOf(row));
        }

        return resultGrid;
    }
}