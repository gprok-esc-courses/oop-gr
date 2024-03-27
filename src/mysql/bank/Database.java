package mysql.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_java_gr",
                    "test3", "1234");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found");
        } catch (SQLException e) {
            System.out.println("Connection with database failed");
        }
        return null;
    }
}
