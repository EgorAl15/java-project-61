package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class CalcGame {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int MAX_NUMBER = 50;
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final Random RANDOM = new Random();

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int a = RANDOM.nextInt(MAX_NUMBER) + 1;
            int b = RANDOM.nextInt(MAX_NUMBER) + 1;
            char operator = OPERATORS[RANDOM.nextInt(OPERATORS.length)];

            String question = a + " " + operator + " " + b;
            String correctAnswer = String.valueOf(calculate(a, b, operator));

            gameData[i][0] = question;
            gameData[i][1] = correctAnswer;
        }

        Engine.run(DESCRIPTION, gameData);
    }

    private static int calculate(int a, int b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}
