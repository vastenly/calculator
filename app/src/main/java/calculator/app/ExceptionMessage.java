package calculator.app;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    INCONSISTENT_NUMBER_SYSTEM("Inconsistent number system used. Please enter either all Roman or all Arabic numbers. " +
            "(используются одновременно разные системы счисления)"),
    NUMBER_NOT_BETWEEN_1_AND_10("Invalid number(s) entered. Please enter valid number(s) between 1 and 10 inclusive."),
    INVALID_INPUT_FORMAT("Invalid input format. " +
            "Please enter a valid mathematical operation with two numbers and one operator (+, -, /, ). " +
            "Keep spaces with operator like '1 + 2'. " +
            "(строка не является математической операцией или формат математической операции не удовлетворяет заданию)"),
    INVALID_NUMBER_FORMAT("Invalid number format. " +
            "Please enter a valid two numbers and one operator (+, -, /, ). " +
            "Keep spaces with operator like '1 + 2'"),
    INVALID_OPERATOR_ENTERED("Invalid operator entered. Please enter a valid operator (+, -, /, )."),
    INVALID_OPERATION("Invalid operation. Use +, -, *, /"),
    RESULT_SHOULD_BE_MORE_THAN_ZERO("Result cannot be less than 1. (в римской системе нет отрицательных чисел)");


    final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
