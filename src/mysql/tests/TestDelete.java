package mysql.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestDelete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test3", "1234");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            String query = "DELETE FROM product WHERE id=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            boolean success = st.execute();
            int count = st.getUpdateCount();
            if(count == 0) {
                System.out.println("id not found");
            }
            else {
                System.out.println("product deleted");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the DB");
        }
    }
}
