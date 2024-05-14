package quiz_example;

import java.util.Random;

public class MultipleChoice extends Question {
    public MultipleChoice(String question, String correct, String[] incorrect) {
        super(question, correct, incorrect);
    }

    @Override
    public void setAnswerList(String correct, String[] incorrect) {
        answers = new String[4];
        Random rnd = new Random();
        int r = rnd.nextInt(0, 4);
        int w = 0;  // wrong list posistion
        for(int i = 0; i < 4; i++) {
            if(i == r) {
               answers[i] = correct;
            }
            else {
                answers[i] = incorrect[w];
                w++;
            }
        }
        correctPos = r;
    }
}
