package riddles.errors;

import java.io.*;
import java.util.Date;

public class ErrorLog implements ErrorObserver {

    private PrintWriter writer;

    public ErrorLog() {
        try {
            File file = new File("error.log");
            if(!file.exists()) {
                file.createNewFile();
            }
            writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        } catch (IOException e) {
            System.out.println("Cannot create or open error.log file");
            System.exit(1);
        }
    }
    @Override
    public void error(Class c, Exception e, String message) {
        writer.write(new Date() + ", " + c.getSimpleName() + ", " + e.getMessage() + ", " + message);
        writer.println();
        writer.flush();
    }
}
