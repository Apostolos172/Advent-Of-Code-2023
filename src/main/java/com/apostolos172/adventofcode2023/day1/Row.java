package com.apostolos172.adventofcode2023.day1;

import org.apache.commons.lang3.RegExUtils;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private String row;
    private String firstDigit;
    private String lastDigit;

    public Row(String row) {
        this.row = row;
        findFirstAndLastDigit();
    }

    public String getFirstDigit() {
        return firstDigit;
    }

    public String getLastDigit() {
        return lastDigit;
    }

    /**
     * covers the following :
     * z oneight 234
     * pss twone sevenfvctwo9vnbxflpntcdllpzpkgtwo9one
     * and also trknlxnv43zxlrqj twone ct
     */
    public void findFirstAndLastDigit() {
        String initialRow = this.row;
        String tempString = "";
        for (int i = 0; i < this.row.length(); i++) {
            for (StringNumber number : getStringNumbers()) {
                if (number.isInsideString(tempString)) {
                    this.row = this.row.replace(number.stringNumber(), number.getStringNumberReplacedByDigits());
                }
            }
            tempString = tempString + this.row.charAt(i);
        }
        this.firstDigit = "" + RegExUtils.removeAll(this.row, "[^\\d.]").charAt(0);

        tempString = "";
        this.row = initialRow;
        for (int i = this.row.length() - 1; i >= 0; i--) {
            for (StringNumber number : getStringNumbers()) {
                if (number.isInsideString(tempString)) {
                    this.row = this.row.replace(number.stringNumber(), number.getStringNumberReplacedByDigits());
                }
            }
            tempString = this.row.charAt(i) + tempString;
        }
        tempString = RegExUtils.removeAll(this.row, "[^\\d.]");
        this.lastDigit = "" + tempString.charAt(tempString.length() - 1);
    }

    /**
     * It loses things
     *
     * @return the row without string numbers
     */
    public String replaceNumberWordsWithRealNumbersV1() {
        getStringNumbers().forEach(this::replaceStringWithValue);
        return this.row;
    }

    private void replaceStringWithValue(StringNumber stringNumber) {
        if (stringNumber.isInsideString(this.row)) {
            this.row = this.row.replace(stringNumber.stringNumber(), "%d".formatted(stringNumber.value()));
        }
    }

    private List<StringNumber> getStringNumbers() {
        return new ArrayList<StringNumber>(List.of(
                new StringNumber("one", 1),
                new StringNumber("two", 2),
                new StringNumber("three", 3),
                new StringNumber("four", 4),
                new StringNumber("five", 5),
                new StringNumber("six", 6),
                new StringNumber("seven", 7),
                new StringNumber("eight", 8),
                new StringNumber("nine", 9)));
    }

}
