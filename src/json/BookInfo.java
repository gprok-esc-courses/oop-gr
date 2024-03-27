package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class BookInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give ISBN: ");
        String isbn = scanner.next();

        try {
            URL url = new URL("https://openlibrary.org/isbn/" + isbn +".json");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);

            System.out.println("Title: " + json.get("title"));
            System.out.println("Pages: " + json.get("number_of_pages"));
            System.out.println("Published: " + json.get("publish_date"));

            JSONArray authorsArray = (JSONArray) json.get("authors");
            System.out.println("Authors:");
            for(Object obj : authorsArray) {
                JSONObject jobj = (JSONObject) obj;
                String key = (String) jobj.get("key");
                url = new URL("https://openlibrary.org" + key + ".json");
                is = new InputStreamReader(url.openStream());
                json = (JSONObject) parser.parse(is);
                System.out.println("- " + json.get("name"));
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
