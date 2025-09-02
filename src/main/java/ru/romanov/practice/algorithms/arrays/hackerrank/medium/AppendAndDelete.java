package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

public class AppendAndDelete {

    public static void main(String[] args) {

        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println(appendAndDelete("aba", "aba", 7));
        System.out.println(appendAndDelete("ashley", "ash", 2));
    }

    public static String appendAndDelete(String s, String t, int k) {
        if (s.length() + t.length() <= k) {
            return "Yes";
        }

        int l = 0;
        int minLength = Math.min(s.length(), t.length());
        while (l < minLength && s.charAt(l) == t.charAt(l)) {
            l++;
        }

        int r = Math.abs(s.length() - l + t.length() - l);

        return  r <= k && (k - r) % 2 == 0 ? "Yes" : "No";
    }
}