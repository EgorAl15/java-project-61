package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class ProgressionGame {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MIN_START = 0;
    private static final int MAX_START = 49;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int round = 0; round < Engine.ROUNDS_COUNT; round++) {
            int start = Utils.generateNumber(MIN_START, MAX_START);
            int step = Utils.generateNumber(MIN_STEP, MAX_STEP);
            int hiddenIndex = Utils.generateNumber(0, PROGRESSION_LENGTH - 1);

            int[] progression = generateProgression(start, step);
            int hiddenNumber = progression[hiddenIndex];

            StringBuilder question = new StringBuilder();

            for (int i = 0; i < progression.length; i++) {
                if (i > 0) {
                    question.append(" ");
                }

                if (i == hiddenIndex) {
                    question.append("..");
                } else {
                    question.append(progression[i]);
                }
            }

            gameData[round][0] = question.toString();
            gameData[round][1] = String.valueOf(hiddenNumber);
        }

        Engine.run(DESCRIPTION, gameData);
    }

    private static int[] generateProgression(int start, int step) {
        int[] progression = new int[PROGRESSION_LENGTH];

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            progression[i] = start + i * step;
        }

        return progression;
    }
}
