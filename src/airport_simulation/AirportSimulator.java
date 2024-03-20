package airport_simulation;

import java.util.Random;

public class AirportSimulator {
    public Airport airport;

    public AirportSimulator() {
        airport = new Airport();
    }

    public void simulate(int times) {
        Random rnd = new Random();

        for(int i = 0; i < times; i++) {
            int type = rnd.nextInt(4);
            // Set 20% probability for emergency
            if(type == 3) {
                int probability = rnd.nextInt(100);
                if(probability < 80) {
                    type = 2;
                }
            }
            switch (type) {
                case 0:
                    airport.control();
                    break;
                case 1:
                case 2:
                case 3:
                    airport.flightRequest(type);
                    break;
            }
            // Add Delay
            try {
                Thread.sleep(rnd.nextInt(1000, 3000));
            } catch (InterruptedException e) {
                System.out.println("Thread problem");
            }
        }
    }
}
