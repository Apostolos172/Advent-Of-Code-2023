package com.apostolos172.adventofcode2023.day1;

public record StringNumber(String stringNumber, Integer value) {

    public boolean isInsideString(String s) {
        return s.contains(this.stringNumber());
    }

    /**
     * returns instead of seven -> 77777
     *
     * @return the 77777 as string
     */
    public String getStringNumberReplacedByDigits() {
        return String.valueOf(this.value()).repeat(this.stringNumber().length());
    }
}
