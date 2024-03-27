package mysql;

import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

public class TestPasswordEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give password: ");
        String password = scanner.next();
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println(hashed);
    }
}
