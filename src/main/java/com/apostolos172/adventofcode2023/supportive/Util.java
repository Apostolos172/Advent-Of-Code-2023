package com.apostolos172.adventofcode2023.supportive;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class Util {
    public static String getData(String fileName) {
        final Logger logger = Logger.getLogger("com.apostolos172");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/java/com/apostolos172/adventofcode2023/" + fileName);
            return IOUtils.toString(fis, "UTF-8");
        } catch (FileNotFoundException e) {
            logger.info("No such file");
        } catch (IOException e) {
            logger.info("IOException");
        }
        return null;
    }
}
