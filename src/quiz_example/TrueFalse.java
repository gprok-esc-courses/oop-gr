package quiz_example;

public class TrueFalse extends Question {
    public TrueFalse(String question, String correct, String[] incorrect) {
        super(question, correct, incorrect);
    }

    @Override
    public void setAnswerList(String correct, String[] incorrect) {
        answers = new String[2];
        answers[0] = "True";
        answers[1] = "False";
        if(correct.equals("True")) {
            correctPos = 0;
        }
        else {
            correctPos = 1;
        }
    }
}
