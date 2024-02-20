package hangman_v1;

import java.util.Scanner;

public class User {
    private String name;
    private int counterFound;
    private int counterHanged;

    public User() {
        name = "N/A";
        counterFound = 0;
        counterHanged = 0;
    }

    public void askName(Scanner input) {
        System.out.print("Your Name: ");
        name = input.next();
    }

    public void hanged() {
        counterHanged++;
    }

    public void found() {
        counterFound++;
    }

    public String getScore() {
        return name + " F:" + counterFound + " H:" + counterHanged;
    }
}
