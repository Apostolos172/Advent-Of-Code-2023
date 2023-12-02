package com.apostolos172.adventofcode2023.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SetOfCubes {
    private List<Cubes> cubesSet = new ArrayList<>();

    public SetOfCubes(Cubes... cubes) {
        this.cubesSet.addAll(List.of(cubes));
        cubesSet.sort(Comparator.comparing(Cubes::getColor));
    }

    /**
     * 3 blue, 4 red
     *
     * @param stringSetOfCubes like this:  3 blue, 4 red
     */
    public SetOfCubes(String stringSetOfCubes) {
        var cubes = stringSetOfCubes.split(",");
        Arrays.stream(cubes).forEach(s -> cubesSet.add(new Cubes(s)));

        if (!stringSetOfCubes.contains("blue"))
            cubesSet.add(new Cubes(CubeColor.BLUE, 0));
        if (!stringSetOfCubes.contains("red"))
            cubesSet.add(new Cubes(CubeColor.RED, 0));
        if (!stringSetOfCubes.contains("green"))
            cubesSet.add(new Cubes(CubeColor.GREEN, 0));

        cubesSet.sort(Comparator.comparing(Cubes::getColor));
    }

    public List<Cubes> getCubesSet() {
        return cubesSet;
    }

    public boolean isPossible(SetOfCubes availableCubes) {
        for (int i = 0; i < cubesSet.size(); i++) {
            if (cubesSet.get(i).compareTo(availableCubes.cubesSet.get(i)) > 0)
                return false;
        }
        return true;
    }

    public SetOfCubes getTheFewest(SetOfCubes setOfCubes) {
        final SetOfCubes fewestCubes = new SetOfCubes(
                new Cubes(CubeColor.BLUE, 0),
                new Cubes(CubeColor.RED, 0),
                new Cubes(CubeColor.GREEN, 0));
        for (int i = 0; i < fewestCubes.getCubesSet().size(); i++) {
            if (this.getCubesSet().get(i).compareTo(setOfCubes.getCubesSet().get(i)) > 0) {
                fewestCubes.getCubesSet().set(i, this.getCubesSet().get(i));
            } else {
                fewestCubes.getCubesSet().set(i, setOfCubes.cubesSet.get(i));
            }
        }
        return fewestCubes;
    }
}
