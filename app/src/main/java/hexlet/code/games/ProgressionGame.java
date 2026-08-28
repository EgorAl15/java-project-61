package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class ProgressionGame {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MAX_START = 50;
    private static final int MAX_STEP = 10;
    private static final Random RANDOM = new Random();

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int round = 0; round < Engine.ROUNDS_COUNT; round++) {
            int start = RANDOM.nextInt(MAX_START);
            int step = RANDOM.nextInt(MAX_STEP) + 1;
            int hiddenIndex = RANDOM.nextInt(PROGRESSION_LENGTH);

            int hiddenNumber = start + hiddenIndex * step;

            StringBuilder question = new StringBuilder();

            for (int i = 0; i < PROGRESSION_LENGTH; i++) {
                if (i > 0) {
                    question.append(" ");
                }

                if (i == hiddenIndex) {
                    question.append("..");
                } else {
                    question.append(start + i * step);
                }
            }

            gameData[round][0] = question.toString();
            gameData[round][1] = String.valueOf(hiddenNumber);
        }

        Engine.run(DESCRIPTION, gameData);
    }
}
