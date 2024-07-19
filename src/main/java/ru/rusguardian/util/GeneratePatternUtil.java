package ru.rusguardian.util;

public class GeneratePatternUtil {

    private GeneratePatternUtil(){}

    public static String generate(String patternMask) {
        if (patternMask == null || patternMask.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        StringBuilder pattern = new StringBuilder();

        for (char ch : patternMask.toCharArray()) {
            if (ch == 'Y') {
                pattern.append("[A-Za-z]");
            } else if (ch == 'X') {
                pattern.append("\\d");
            } else {
                throw new IllegalArgumentException("Invalid character in input string. Only 'Y' and 'X' are allowed.");
            }
        }

        return "^" + pattern + "$";
    }
}
