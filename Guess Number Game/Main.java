import java.util.*;
import java.util.Random;

public class Main {
    static void Game() {
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        int num = random.nextInt(51);

        System.out.println("You have to guess the number from 1 to 50 in 5 trials.");

        for (int i = 0; i < 5; i++) {
            System.out.println("Guess the number : ");
            int guess = sc.nextInt();
            if (guess == num) {
                System.out.println("Congratulations....!");
                System.out.println("You won. You guess right number.");
                return;
            } else if (guess < num) {
                System.out.println("Number greater than " + guess);
            } else if (guess > num) {
                System.out.println("Number is less than " + guess);
            }
        }

        System.out.println("You lost.");
        System.out.println("Number is " + num);
    }

    public static void main(String[] args) {
        System.out.println("############################################################################################");
        System.out.println("############################-- WELCOME TO GAME --###########################################");
        System.out.println("############################################################################################");
        Game();
        System.out.println("Game over...");
    }
}