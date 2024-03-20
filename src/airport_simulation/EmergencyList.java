package airport_simulation;

public class EmergencyList extends FlightList {
    public EmergencyList() {
        super();
    }

    @Override
    public void action() {
        Flight flight = flights.remove(0);
        System.out.println("Emergency Landing: " + flight.getFlightNo());
    }
}
