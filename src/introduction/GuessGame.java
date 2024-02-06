package introduction;


import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        int secret;
        int guess;
        int counter = 0;

        // Generate the secret
        Random rnd = new Random();
        secret = rnd.nextInt(100);

        // Create scanner to read command line input
        Scanner input = new Scanner(System.in);

        // Repeat until secret found
        do {
            System.out.print("Guess: ");
            guess = input.nextInt();
            if(guess > secret) {
                System.out.println("Go DOWN");
            }
            else if(guess < secret) {
                System.out.println("Go UP");
            }
            counter++;
        } while(secret != guess);

        System.out.println("Found in " + counter + " guesses");

    }
}
