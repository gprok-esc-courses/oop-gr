package mysql.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class Account {
    private int id;
    private String username;
    private String password;
    private int balance;

    public Account(int id, String username, String password, int balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void saveNewAccount() {
        Connection con = Database.getConnection();
        String query = "INSERT INTO accounts (username, password, balance) VALUES (?, ?, 0)";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);
            String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
            st.setString(2, hashed);
            st.execute();
            int count = st.getUpdateCount();
            if(count == 0) {
                System.out.println("ERROR: account not created, username exists");
            }
            else {
                System.out.println("Account created successfully");
            }
        } catch (SQLException e) {
            System.out.println("SQL query failed");
        }
    }

    public boolean withdraw(int amount) {
        if(amount > balance) {
            return false;
        }
        else {
            Connection con = Database.getConnection();
            int value = balance - amount;
            String query = "UPDATE accounts SET balance=? WHERE id=?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setInt(1, value);
                st.setInt(2, id);
                st.execute();
                int count = st.getUpdateCount();
                if(count > 0) {
                    balance = value;
                    return true;
                }
                else {
                    return false;
                }
            } catch (SQLException e) {
                return false;
            }

        }
    }

    public boolean deposit(int amount) {
        Connection con = Database.getConnection();
        int value = balance + amount;
        String query = "UPDATE accounts SET balance=? WHERE id=?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, value);
            st.setInt(2, id);
            st.execute();
            int count = st.getUpdateCount();
            if(count > 0) {
                balance = value;
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean loadAccount() {
        Connection con = Database.getConnection();
        String query = "SELECT * FROM accounts WHERE username=?";

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);
            ResultSet result = st.executeQuery();
            if(result.next()) {
                String hashed = result.getString("password");
                boolean match = BCrypt.checkpw(password, hashed);
                if(match) {
                    id = result.getInt("id");
                    balance = result.getInt("balance");
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
