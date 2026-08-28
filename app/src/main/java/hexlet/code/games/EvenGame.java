package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {

    private static final String DESCRIPTION =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 99;

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);

            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = isEven(number) ? "yes" : "no";
        }

        Engine.run(DESCRIPTION, gameData);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
