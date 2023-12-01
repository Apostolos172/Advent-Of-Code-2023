package com.apostolos172.adventofcode2023.day1;

import org.apache.commons.lang3.RegExUtils;

import java.util.Arrays;

import static com.apostolos172.adventofcode2023.supportive.Util.getData;

public class Day1 {
    public static void main(String[] args) {

        var data = getData("day1/data2.txt");
        assert data != null;

        solvePart1(data);
        solvePart2(data);
    }

    private static void solvePart2(String data) {
        var dataRows = data.split("\\n");
        var sum = Arrays.stream(dataRows)
                .map(Row::new)
                .mapToInt(s -> Integer.parseInt("%s%s".formatted(s.getFirstDigit(), s.getLastDigit())))
                .sum();
        System.out.println(sum);
    }

    private static void solvePart1(String data) {
        var dataRows = data.split("\\n");
        var sum = Arrays.stream(dataRows)
                .map(s -> RegExUtils.removeAll(s, "[^\\d.]"))
                .mapToInt(s -> Integer.parseInt("%s%s".formatted(s.charAt(0), s.charAt(s.length() - 1))))
                .sum();
        System.out.println(sum);
    }
}
