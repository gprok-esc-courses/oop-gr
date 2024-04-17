package riddles;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import riddles.errors.ErrorObserver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Manages the Riddle API.
 * Gets JSON objects from the API and can provide a Riddle object or a list of N Riddle objects.
 */
public class RiddleReader {

    private ArrayList<ErrorObserver> errorObservers;

    public RiddleReader() {
        errorObservers = new ArrayList<>();
    }

    /**
     * Asks the API for a random riddle, and parses response to a json object.
     * @return The retrieved data as json object, or null in case of error
     */
    public JSONObject readAPI() {
        try {
            URL url = new URL("https://riddles-api.vercel.app/random4");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(is);
            return obj;
        } catch (MalformedURLException e) {
            errorOccur(e, "API url is not correct");
            return null;
        } catch (IOException e) {
            errorOccur(e, "Cannot read from API");
            return null;
        } catch (ParseException e) {
            errorOccur(e, "JSON Parser failed");
            return null;
        }
    }

    public void addErrorObserver(ErrorObserver observer) {
        errorObservers.add(observer);
    }

    public void errorOccur(Exception e, String message) {
        for(ErrorObserver observer : errorObservers) {
            observer.error(getClass(), e, message);
        }
    }

    /**
     * Generates a Riddle object based on data retrieved form the API.
     * @return A riddle object, or null in case of any error
     */
    public Riddle getRiddle() {
        JSONObject json = readAPI();
        if(json != null) {
            Riddle riddle = new Riddle(json.get("riddle").toString(), json.get("answer").toString());
            return riddle;
        }
        else {
            return null;
        }
    }

    /**
     * Generates a list of n riddle objects.
     * @param n The number of riddle we need to get
     * @return An array list with n riddles. In case of any error null.
     */
    public ArrayList<Riddle> getRiddles(int n) {
        ArrayList<Riddle> riddles = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Riddle riddle = getRiddle();
            if(riddle == null) {
                return null;
            }
            riddles.add(riddle);
        }
        return riddles;
    }

}
