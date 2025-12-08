package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.*;

public class TwoPluses {

    public static void main(String[] args) {

        List<String> grid1 = List.of(
                "GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG"
        );
        System.out.println("Test 1. Grid: " + grid1 + "\nResult: " + twoPluses(grid1));
        List<String> grid2 = List.of(
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "BGBBGB"
        );
        System.out.println("Test 2. Grid: " + grid2 + "\nResult: " + twoPluses(grid2));
        List<String> grid3 = List.of(
                "GBGBGGB",
                "GBGBGGB",
                "GBGBGGB",
                "GGGGGGG",
                "GGGGGGG",
                "GBGBGGB",
                "GBGBGGB"
        );
        System.out.println("Test 3. Grid: " + grid3 + "\nResult: " + twoPluses(grid3));
        List<String> grid4 = List.of(
                "GGGGGGGGGGGG",
                "GBGGBBBBBBBG",
                "GBGGBBBBBBBG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "GBGGBBBBBBBG",
                "GBGGBBBBBBBG",
                "GBGGBBBBBBBG",
                "GGGGGGGGGGGG",
                "GBGGBBBBBBBG"
        );
        System.out.println("Test 4. Grid: " + grid4 + "\nResult: " + twoPluses(grid4));
    }

    public static int twoPluses(List<String> grid) {

        var goodCells = new HashSet<Cell>();

        for (int i = 0; i < grid.size(); i++) {
            char[] chars = grid.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'G') {
                    goodCells.add(new Cell(i, j));
                }
            }
        }

        int maxProduction = goodCells.size() > 1 ? 1 : 0;
        var pluses = new LinkedList<HashSet<Cell>>();
        for (Cell cell : goodCells) {
            HashSet<Cell> plus = new HashSet<>();
            plus.add(cell);
            pluses.add(plus);
            int l = 1;
            while (isPossiblePlus(goodCells, cell, l)) {
                plus.add(cell);
                plus.add(new Cell(cell.getR() - l, cell.getC()));
                plus.add(new Cell(cell.getR() + l, cell.getC()));
                plus.add(new Cell(cell.getR(), cell.getC() - l));
                plus.add(new Cell(cell.getR(), cell.getC() + l));
                pluses.add(new HashSet<>(plus));
                maxProduction = calculateMaxProduction(pluses, maxProduction);
                l++;
            }
        }

        return maxProduction;
    }

    private static boolean isPossiblePlus(Set<Cell> cells, Cell center, int l) {
        if (cells.contains(new Cell(center.getR() - l, center.getC()))
                && cells.contains(new Cell(center.getR() + l, center.getC()))
                && cells.contains(new Cell(center.getR(), center.getC() - l))
                && cells.contains(new Cell(center.getR(), center.getC() + l))
        ) {
            return true;
        }
        return false;
    }

    private static int calculateMaxProduction(LinkedList<HashSet<Cell>> pluses, int currentMaxProduction) {
        int maxProduction = currentMaxProduction;
        for (int i = 0; i < pluses.size() - 2; i++  ) {
            HashSet<Cell> candidate = pluses.get(i);
            HashSet<Cell> lastAddedPlus = new HashSet<>(pluses.getLast());
            if (!lastAddedPlus.removeAll(candidate) && candidate.size() * lastAddedPlus.size() > maxProduction) {
                maxProduction = candidate.size() * lastAddedPlus.size();
            }
        }
        return maxProduction;
    }

    private static class Cell {
        int r;
        int c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return r == cell.r && c == cell.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public String toString() {
            return "(" + r + ", " + c + ")";
        }
    }

}
