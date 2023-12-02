package com.apostolos172.adventofcode2023.day2;

import java.util.Arrays;

import static com.apostolos172.adventofcode2023.supportive.Util.getData;

public class Day2 {
    public static void main(String[] args) {

        var data = getData("day2/data.txt");
        assert data != null;
        var dataRows = data.split("\\n");

        solvePart1(dataRows);
        solvePart2(dataRows);
    }

    private static void solvePart1(String[] dataRows) {
        var sum = Arrays.stream(dataRows)
                .map(Game::new)
                .filter(Game::isPossible)
                .mapToInt(Game::getId)
                .sum();
        System.out.println(sum);
    }

    private static void solvePart2(String[] dataRows) {
        var sum = Arrays.stream(dataRows)
                .map(Game::new)
                .mapToInt(Game::power)
                .sum();
        System.out.println(sum);
    }
}
