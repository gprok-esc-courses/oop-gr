package riddles;

import riddles.errors.ErrorObserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Connects to DB and provides methods for any queries necessary.
 */
public class DBConnection {

    /** keeps the connection to the database */
    private Connection connection;
    private ArrayList<ErrorObserver> errorObservers;

    /**
     * Class constructor
     * Initializes the connection
     */
    public DBConnection() {
        errorObservers = new ArrayList();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_riddlesX",
                    "test", "test");
        } catch (ClassNotFoundException e) {
            errorOccur(e, "DBMS Driver not found");
            connection = null;
        } catch (SQLException e) {
            errorOccur(e, "Cannot connect to the Database");
            connection = null;
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
     * Save the result of a game
     * @param username user who played
     * @param score score achieved
     * @return if save was successful or not
     */
    public boolean saveScore(String username, int score) {
        if(connection != null) {
            String query = "INSERT INTO scores (username, date_time, score) VALUES (?, NOW(), ?)";
            try {
                PreparedStatement st = connection.prepareStatement(query);
                st.setString(1, username);
                st.setInt(2, score);
                st.execute();
                return true;
            } catch (SQLException e) {
                errorOccur(e, "Cannot insert score: " + query);
                return false;
            }
        }
        else {
            return false;
        }
    }
}
