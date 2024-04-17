package riddles;

import java.util.Scanner;

/**
 * Provides a command line user interface for the riddle game
 */
public class GameUI {

    /** keeps current user */
    private String username;

    /** model of the game, providing all game's functionality */
    private Game game;

    /** used for user input from the keyboard */
    private Scanner scanner;

    /**
     * Class constructor
     */
    public GameUI() {
        username = null;
        game = null;
        scanner = new Scanner(System.in);
    }

    /**
     * Ask user for the username and keeps in class variable
     */
    public void getUserName() {
        System.out.print("Username: ");
        username = scanner.nextLine();
    }

    /**
     * Starts a new game by asking for username and initializing a game object
     */
    public void startNewGame() {
        System.out.println("==== New Game ====");
        getUserName();
        System.out.println("==== Game Starts ====");
        game = new Game(4);
    }

    /**
     * Displays one riddle, gets response and asks game for checking
     */
    public void playRiddle() {
        System.out.println(game.getNextQuestion());
        String answer = scanner.nextLine();
        game.checkUserResponse(answer);
    }

    /**
     * Displays the score of the game
     */
    public void displayScore() {
        System.out.println("Score: " + game.getScore() + "/4");
    }

    /**
     * Asks user if wants to play again and responds by playing a new game or starting with a new user
     */
    public void playAgain() {
        System.out.print("Play again (y/n)? ");
        String answer = scanner.nextLine();
        if(answer.equals("y")) {
            System.out.println("==== Game Starts ====");
            game = new Game(4);
        }
        else {
            startNewGame();
        }
    }

    /**
     * Provides the main flow of the game
     */
    public void run() {
        startNewGame();
        do {
            if(!game.isGameOK()) {
                System.out.println("Riddles not loaded, terminates");
                break;
            }
            while(!game.gameOver()) {
                playRiddle();
            }
            displayScore();
            game.saveScoreToDB(username);
            playAgain();
        } while(!username.equals("exit"));
        System.out.println("Bye!");
    }

}
