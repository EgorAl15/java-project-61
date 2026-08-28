package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.PrimeUtils;
import java.util.Random;

public class PrimeGame {
    private static final String DESCRIPTION =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_NUMBER = 100;
    private static final Random RANDOM = new Random();

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = RANDOM.nextInt(MAX_NUMBER) + 1;

            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = PrimeUtils.isPrime(number) ? "yes" : "no";
        }

        Engine.run(DESCRIPTION, gameData);
    }
}
