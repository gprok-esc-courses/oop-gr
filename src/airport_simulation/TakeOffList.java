package airport_simulation;

public class TakeOffList extends FlightList {
    public TakeOffList() {
        super();
    }

    @Override
    public void action() {
        Flight flight = flights.remove(0);
        System.out.println("Take Off " + flight.getFlightNo());
    }
}
