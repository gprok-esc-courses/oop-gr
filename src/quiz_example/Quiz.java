package quiz_example;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;
    private int currentQuestion;

    public void startQuiz() {
        QuizRetriever retriever = new QuizRetriever();
        questions = retriever.getQuiz();
        score = 0;
        currentQuestion = 0;
    }

    public void displayCurrentQuestion() {
        questions.get(currentQuestion).display();
    }

    public void checkUserResponse(int response) {
        Question q = questions.get(currentQuestion);
        response = response - 1;
        if(response == q.correctPos) {
            score++;
        }
        currentQuestion++;
    }

    public boolean completed() {
        return currentQuestion == 10;
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        startQuiz();
        while(!completed()) {
            displayCurrentQuestion();
            System.out.print("Answer: ");
            int resp = scan.nextInt();
            checkUserResponse(resp);
        }
        System.out.println("SCORE: " + score + "/10");
    }
}
