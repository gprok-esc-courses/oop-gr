package hangman_v1;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        User user = new User();
        Hangman hangman = new Hangman();
        Scanner input = new Scanner(System.in);

        user.askName(input);

        do {
            hangman.startNewGame();

            do {
                System.out.println(hangman.getSecretWithDashes());
                hangman.commandLineGuess(input);
                if(hangman.wordFound()) {
                    System.out.println("FOUND :)");
                    user.found();
                    break;
                }
                if(hangman.isHanged()) {
                    System.out.println("HANGED :(");
                    user.hanged();
                    break;
                }
            } while(true);

            System.out.print("Play again? (y/n) ");
            String answer = input.next();
            if(answer.equals("n")) {
                break;
            }
        } while(true);

        System.out.println(user.getScore());
    }
}
