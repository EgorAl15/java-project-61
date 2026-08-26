package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        String choice = scanner.nextLine().trim();

        if (choice.equals("0")) {
            return;
        }

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine().trim();
        System.out.println("Hello, " + name + "!");

        switch (choice) {
            case "1":
                break;
            case "2":
                EvenGame.play(scanner, name);
                break;
            case "3":
                CalcGame.play(scanner, name);
                break;
            case "4":
                GcdGame.play(scanner, name);
                break;
            case "5":
                ProgressionGame.play(scanner, name);
                break;
            case "6":
                PrimeGame.play(scanner, name);
                break;
            default:
                break;
        }
    }
}
