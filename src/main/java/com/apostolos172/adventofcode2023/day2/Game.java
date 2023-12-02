package com.apostolos172.adventofcode2023.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private final String id;
    private final SetOfCubes availableCubes;
    private final List<SetOfCubes> setOfSetOfCubes = new ArrayList<>();

    public Game(String gameRow) {
        this.availableCubes = new SetOfCubes(
                new Cubes(CubeColor.BLUE, 14),
                new Cubes(CubeColor.GREEN, 13),
                new Cubes(CubeColor.RED, 12));

        this.id = gameRow.split(":")[0].split(" ")[1];
        var setOfSelectedCubesStr = gameRow.split(":")[1]; //  3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        var setOfSelectedCubes = setOfSelectedCubesStr.split(";");
        Arrays.stream(setOfSelectedCubes)
                .forEach(s -> setOfSetOfCubes.add(new SetOfCubes(s)));
    }

    public Integer getId() {
        return Integer.valueOf(id);
    }

    public boolean isPossible() {
        for (SetOfCubes setOfCubes : setOfSetOfCubes) {
            if (!setOfCubes.isPossible(availableCubes))
                return false;
        }
        return true;
    }

    public SetOfCubes getTheFewestSetOfCubes() {
        var fewestCubes = new SetOfCubes(
                new Cubes(CubeColor.BLUE, Integer.MIN_VALUE),
                new Cubes(CubeColor.RED, Integer.MIN_VALUE),
                new Cubes(CubeColor.GREEN, Integer.MIN_VALUE));

        for (SetOfCubes setOfCubes : setOfSetOfCubes) {
            fewestCubes = setOfCubes.getTheFewest(fewestCubes);
        }
        return fewestCubes;
    }

    public Integer power() {
        var fewestCubes = this.getTheFewestSetOfCubes();
        var power = fewestCubes.getCubesSet().stream()
                .map(Cubes::getQuantity)
                .toList()
                .stream().reduce((integer, integer2) -> integer * integer2);
        return power.get();
    }

}
