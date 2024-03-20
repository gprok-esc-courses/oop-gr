package airport_simulation;

import java.util.Random;

public class FlightGenerator {
    public Flight nextFlight() {
        Random rnd = new Random();
        int flightNo = rnd.nextInt(1000);
        Flight flight = new Flight(flightNo);
        return flight;
    }
}
