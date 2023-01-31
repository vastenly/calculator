package calculator.app;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
class Calculator {
    static String calc(String input) {
        String[] arr = input.split(" ");
        int num1, num2;
        String operation;
        if (arr.length != 3) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.message);
        }
// check if input numbers are valid
        try {
            if (isRomanNumeral(arr[0])) {
                num1 = romanToArabic(arr[0]);
            } else {
                num1 = Integer.parseInt(arr[0]);
            }
            if (isRomanNumeral(arr[2])) {
                num2 = romanToArabic(arr[2]);
            } else {
                num2 = Integer.parseInt(arr[2]);
            }
            if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_BETWEEN_1_AND_10.message);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT.message);
        }
// check if input operator is valid
        if (!isValidOperator(arr[1])) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OPERATOR_ENTERED.message);
        } else {
            operation = arr[1];
        }

// check if number system is consistent
        if (isRomanNumeral(arr[0]) ^ isRomanNumeral(arr[2])) {
            throw new IllegalArgumentException(ExceptionMessage.INCONSISTENT_NUMBER_SYSTEM.message);
        }

// perform calculations
        int result = performOperation(num1, num2, operation);

// check if result is valid
        if (result < 1) {
            throw new IllegalArgumentException(ExceptionMessage.RESULT_SHOULD_BE_MORE_THAN_ZERO.message);
        }
        if (isRomanNumeral(arr[0])) {
            return ArabicToRoman(result);
        } else {
            return Integer.toString(result);
        }
    }

    static int performOperation(int num1, int num2, String operation) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException(ExceptionMessage.INVALID_OPERATION.message);
        };
    }

    private static final Map<Character, Integer> ROMAN_NUMERAL_MAP =
            Map.of('I', 1, 'V', 5, 'X', 10);

    private static int romanToArabic(String roman) {
        int[] romanValues = roman.chars().map(c -> ROMAN_NUMERAL_MAP.get((char) c))
                .toArray();
        int arabic = 0;
        for (int i = 0; i < romanValues.length; i++) {
            if (i < romanValues.length - 1 && romanValues[i] < romanValues[i + 1]) {
                arabic -= romanValues[i];
            } else {
                arabic += romanValues[i];
            }
        }
        return arabic;
    }

    static String ArabicToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String sb = String.valueOf(M[num / 1000]) +
                C[(num % 1000) / 100] +
                X[(num % 100) / 10] +
                I[num % 10];
        return sb;
    }

    private static boolean isRomanNumeral(String str) {
        return str.matches("^(?=[MDCLXVI])M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }

    private static boolean isValidOperator(String str) {
        return str.matches("[+\\-*/]");
    }
}
