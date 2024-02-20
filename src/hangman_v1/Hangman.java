package hangman_v1;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private String [] words = {"constructor", "encapsulation",
            "inheritance", "polymorphism", "initialization",
            "agile", "compiler", "interpreter", "programming",
            "debugging"
    };
    private String secretWord;
    private String correctGuesses;
    private String wrongGuesses;

    public Hangman() {
        wrongGuesses = "";
        correctGuesses = "";
    }

    public void startNewGame() {
        Random rnd = new Random();
        int position = rnd.nextInt(words.length-1);
        secretWord = words[position];
        System.out.println(secretWord);
        wrongGuesses = "";
        correctGuesses = "";
    }

    public String getSecretWithDashes() {
        String secret = "";
        secret += secretWord.charAt(0);
        for(int i = 1; i < secretWord.length()-1; i++) {
            String s = "" + secretWord.charAt(i);
            if(correctGuesses.contains(s)) {
                secret += s;
            }
            else {
                secret += "_";
            }
        }
        secret += secretWord.charAt(secretWord.length()-1);
        return secret;
    }

    public void commandLineGuess(Scanner input) {
        System.out.print("Guess: ");
        String guess = input.next();
        if(secretWord.contains(guess)) {
            correctGuesses += guess;
        }
        else {
            wrongGuesses += guess;
        }
    }

    public boolean isHanged() {
        return wrongGuesses.length() == 6;
    }

    public boolean wordFound() {
        for(int i = 1; i < secretWord.length()-1; i++) {
            String s = "" + secretWord.charAt(i);
            if(!correctGuesses.contains(s)) {
                return false;
            }
        }
        return true;
    }

}
