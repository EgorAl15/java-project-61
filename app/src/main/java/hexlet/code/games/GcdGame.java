package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GcdGame {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 50;

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number1 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);
            int number2 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);

            gameData[i][0] = number1 + " " + number2;
            gameData[i][1] = String.valueOf(findGcd(number1, number2));
        }

        Engine.run(DESCRIPTION, gameData);
    }

    private static int findGcd(int number1, int number2) {
        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }

        return number1;
    }
}
