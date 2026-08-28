package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 50;
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number1 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);
            int number2 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);

            int operatorIndex = Utils.generateNumber(0, OPERATORS.length - 1);
            char operator = OPERATORS[operatorIndex];

            String question = number1 + " " + operator + " " + number2;
            String correctAnswer = String.valueOf(calculate(number1, number2, operator));

            gameData[i][0] = question;
            gameData[i][1] = correctAnswer;
        }

        Engine.run(DESCRIPTION, gameData);
    }

    private static int calculate(int number1, int number2, char operator) {
        return switch (operator) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}
