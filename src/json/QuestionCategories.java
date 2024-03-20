package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class QuestionCategories {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://opentdb.com/api_category.php");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            JSONArray questions = (JSONArray) json.get("trivia_categories");
            for(Object obj : questions) {
                JSONObject item = (JSONObject) obj;
                System.out.println(item.get("name"));
            }
        } catch (MalformedURLException e) {
            System.out.println("Problem with URL");
        } catch (IOException e) {
            System.out.println("Input problem");
        } catch (ParseException e) {
            System.out.println("Invalid JSON data");
        }
    }
}
