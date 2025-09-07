package ru.romanov.practice.algorithms.arrays.hackerrank.easy;

import java.util.stream.Stream;

public class TimeConversion {

    public static void main(String[] args) {

        Stream.of("12:01:00PM", "12:01:00AM", "07:05:45PM")
                .map(s -> s + " -> " +timeConversion(s))
                .forEach(System.out::println);
    }

    public static String timeConversion(String s) {

        String dayHalf = s.substring(s.length() - 2);
        int hour = Integer.parseInt(s.substring(0, 2));

        String result = s.substring(2, s.length() - 2);
        int hour24;
        if (dayHalf.equals("AM")) {
            hour24 = hour % 12;
        } else if (dayHalf.equals("PM")) {
            hour24 = hour % 12 + 12;
        } else {
            throw new IllegalArgumentException("Invalid 12-hour clock: " + s);
        }

        result = "%02d".formatted(hour24) + result;
        return result;
    }

}
