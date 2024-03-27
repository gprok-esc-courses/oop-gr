package mysql.tests;

import java.sql.*;

public class TestSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test3", "1234");
            String query = "SELECT * FROM product";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the DB");
        }
    }
}
