package quiz_example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class QuizRetriever {
    public JSONArray getQuizJSON() {
        try {
            URL url = new URL("https://opentdb.com/api.php?amount=10");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            JSONArray quiz = (JSONArray) json.get("results");
            return quiz;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Question> getQuiz() {
        JSONArray json = getQuizJSON();
        ArrayList<Question> quiz = new ArrayList<>();
        for(Object obj : json) {
            Question question;
            JSONObject questionJSON = (JSONObject) obj;
            String q = (String) questionJSON.get("question");
            String c = (String) questionJSON.get("correct_answer");
            JSONArray incorrect = (JSONArray) questionJSON.get("incorrect_answers");
            String [] inc = new String[incorrect.size()];
            for(int i = 0; i < incorrect.size(); i++) {
                inc[i] = (String) incorrect.get(i);
            }
            if(questionJSON.get("type").equals("multiple")) {
                question = new MultipleChoice(q, c, inc);
            }
            else {
                question = new TrueFalse(q, c, inc);
            }
            quiz.add(question);
        }
        return quiz;
    }
}
