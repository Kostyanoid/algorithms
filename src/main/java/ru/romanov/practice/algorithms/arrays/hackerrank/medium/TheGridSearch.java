package ru.romanov.practice.algorithms.arrays.hackerrank.medium;

import java.util.List;
import java.util.regex.Pattern;

public class TheGridSearch {

    public static void main(String[] args) {
        List<String> G1 = List.of(
                "7652157548860692421022503",
                "9283597467877865303553675",
                "4160389485250089289309493",
                "2583470721457150497569300",
                "3220130778636571709490905",
                "3588873017660047694725749",
                "9288991387848870159567061",
                "4840101673383478700737237",
                "8430916536880190158229898",
                "8986106490042260460547150",
                "2591460395957631878779378",
                "1816190871689680423501920",
                "0704047294563387014281341",
                "8544774664056811258209321",
                "9609294756392563447060526",
                "0170173859593369054590795",
                "6088985673796975810221577",
                "7738800757919472437622349",
                "5474120045253009653348388",
                "3930491401877849249410013",
                "1486477041403746396925337",
                "2955579022827592919878713",
                "2625547961868100985291514",
                "3673299809851325174555652",
                "4533398973801647859680907"
        );
        List<String> P1 = List.of(
                "5250",
                "1457",
                "8636",
                "7660",
                "7848"
        );

        System.out.println(gridSearch(G1, P1));
    }

    public static String gridSearch(List<String> G, List<String> P) {

        String joinedG = String.join("-", G);
        int widthG = G.get(0).length();
        int widthP = P.get(0).length();

        String searchPatternStr = String.join(".{%d}".formatted(widthG - widthP + 1), P);
        Pattern searchPattern = Pattern.compile(searchPatternStr);

        return searchPattern.matcher(joinedG).find() ? "YES" : "NO";
    }
}
