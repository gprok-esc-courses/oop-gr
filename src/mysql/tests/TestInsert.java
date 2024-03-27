package mysql.tests;

import java.sql.*;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test3", "1234");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            double price = scanner.nextDouble();
            int stock = scanner.nextInt();
            String query = "INSERT INTO product (name, price, stock) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, name);
            st.setDouble(2, price);
            st.setInt(3, stock);
            st.execute();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the DB");
        }
    }
}
