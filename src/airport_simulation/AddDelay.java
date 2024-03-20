package airport_simulation;

import java.util.Random;

public class AddDelay {
    public static void main(String[] args) {
        Random rnd = new Random();
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(rnd.nextInt(1000, 3000));
            } catch (InterruptedException e) {
                System.out.println("Thread problem");
            }
        }
    }
}
