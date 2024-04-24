package riddles;

import riddles.errors.ErrorLog;
import riddles.errors.ErrorMail;

import java.util.ArrayList;

/**
 * Model of the game.
 * Provide all the logic of the game.
 */
public class Game {
    /** a list of riddle objects for an instance of the game */
    private ArrayList<Riddle> riddles;

    /** keeps the score of the current game */
    private int score;

    /** indicates the current riddle */
    private int currentRiddle;

    /** defines how many questions the game will ask */
    private int size;

    /** connects to the database and used to run queries */
    private DBConnection db;

    /**
     * Class constructor
     * @param size the number of questions to be asked
     */
    public Game(int size) {
        ErrorLog errorLog = new ErrorLog();
        ErrorMail errorMail = new ErrorMail();
        this.size = size;
        db = new DBConnection();
        db.addErrorObserver(errorLog);
        db.addErrorObserver(errorMail);
        db.connect();
        RiddleReader reader = new RiddleReader();
        reader.addErrorObserver(errorLog);
        reader.addErrorObserver(errorMail);
        riddles = reader.getRiddles(this.size);
        score = 0;
        currentRiddle = 0;
    }

    /**
     * Provides the next question of the fame
     * @return next question
     */
    public String getNextQuestion() {
        if(!gameOver()) {
            Riddle riddle = riddles.get(currentRiddle);
            System.out.println(riddle);
            return riddle.getQuestion();
        }
        else {
            return null;
        }
    }

    /** Checks if a response to the current question is correct, and if yes,
     * updates the score and moves to the next question.
     * @param response user provided response to be checked
     */
    public void checkUserResponse(String response) {
        if(!gameOver()) {
            Riddle riddle = riddles.get(currentRiddle);
            if(riddle.checkUserResponse(response)) {
                score++;
            }
            currentRiddle++;
        }
    }

    /**
     * Checks if game is over
     * @return boolean, true if game over
     */
    public boolean gameOver() {
        return currentRiddle > this.size-1;
    }

    /**
     * Score getter
     * @return the current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Saves current game result to the database
     * @param username the username of the player
     */
    public void saveScoreToDB(String username) {
        db.saveScore(username, score);
    }

    public boolean isGameOK() {
        return riddles != null && riddles.size() == size;
    }
}
