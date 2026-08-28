package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GcdUtils;
import java.util.Random;

public class GcdGame {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER = 50;
    private static final Random RANDOM = new Random();

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int a = RANDOM.nextInt(MAX_NUMBER) + 1;
            int b = RANDOM.nextInt(MAX_NUMBER) + 1;

            gameData[i][0] = a + " " + b;
            gameData[i][1] = String.valueOf(GcdUtils.computeGcd(a, b));
        }

        Engine.run(DESCRIPTION, gameData);
    }
}
