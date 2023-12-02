package com.apostolos172.adventofcode2023.day2;

public class Cubes implements Comparable<Cubes> {
    private CubeColor color;
    private final Integer quantity;

    public Cubes(CubeColor color, Integer quantity) {
        this.color = color;
        this.quantity = quantity;
    }

    public Cubes(String cubeString) {
        cubeString = cubeString.trim();
        this.quantity = Integer.valueOf(cubeString.split(" ")[0]);
        var color = cubeString.split(" ")[1];
        switch (color) {
            case "blue":
                this.color = CubeColor.BLUE;
                break;
            case "green":
                this.color = CubeColor.GREEN;
                break;
            case "red":
                this.color = CubeColor.RED;
                break;
        }
    }

    public CubeColor getColor() {
        return color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public int compareTo(Cubes o) {
        return this.quantity.compareTo(o.quantity);
    }
}
