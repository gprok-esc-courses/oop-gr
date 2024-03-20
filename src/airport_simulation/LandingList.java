package airport_simulation;

public class LandingList extends FlightList {
    public LandingList() {
        super();
    }

    @Override
    public void action() {
        Flight flight = flights.remove(0);
        System.out.println("Landing " + flight.getFlightNo());
    }
}
