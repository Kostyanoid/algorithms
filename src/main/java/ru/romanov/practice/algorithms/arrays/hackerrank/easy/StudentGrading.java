package ru.romanov.practice.algorithms.arrays.hackerrank.easy;

import java.util.List;
import java.util.stream.Collectors;

public class StudentGrading {

    public static void main(String[] args) {

        List<Integer> originalGrades = List.of(84, 29, 57, 73, 67, 38, 33);

        System.out.println("Adjusted grades: " + gradingStudents(originalGrades));

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {

        return grades.stream().map(StudentGrading::adjustGrade).collect(Collectors.toList());

    }

    private static int adjustGrade(int grade) {

        if (grade < 38 || grade % 5 < 3) {
            return grade;
        } else {
            return (grade / 5 + 1) * 5;
        }
    }
}
