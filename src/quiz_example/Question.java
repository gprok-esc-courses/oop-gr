package quiz_example;

public class Question {
    protected String question;

    protected String [] answers;
    
    protected int correctPos;

    public Question(String question, String correct,
                    String [] incorrect) {
        this.question = question;
        setAnswerList(correct, incorrect);
    }

    public void setAnswerList(String correct,
                              String [] incorrect) {
        // do nothing
    }

    public void display() {
        System.out.println("Q: " + question);
        int counter = 1;
        for(int i = 0; i < answers.length; i++) {
            System.out.println(counter + ": " + answers[i]);
            counter++;
        }
        System.out.println("--> " + correctPos);
    }
}
