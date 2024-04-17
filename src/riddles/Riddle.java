package riddles;


/**
 * Model for one riddle
 */
public class Riddle {
    private String question;
    private String answer;

    /**
     * Class constructor
     * @param question the question of the riddle
     * @param answer the correct answer
     */
    public Riddle(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Question getter
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Checks the provided response for correctness.
     * @param response the response to be checked
     * @return boolean, true if response is correct, false otherwise
     */
    public boolean checkUserResponse(String response) {
        if(this.answer.equals(response)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Provides a string to be used by System.out.println
     * @return the class data converted to String
     */
    @Override
    public String toString() {
        return "Q: " + question + "\n" + "A: " + answer;
    }
}
