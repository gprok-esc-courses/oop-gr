package files;

import java.io.*;

public class TestFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        else {
            System.out.println("File exists");
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bwriter = new BufferedWriter(writer);
        PrintWriter pwriter = new PrintWriter(bwriter);
        pwriter.write("Hello World, by print writer");
        pwriter.println();
        pwriter.close();
    }
}
