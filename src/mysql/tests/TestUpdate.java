package mysql.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test3", "1234");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            int stock = scanner.nextInt();
            String query = "UPDATE product SET stock=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, stock);
            st.setInt(2, id);
            st.execute();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the DB");
        }
    }
}
