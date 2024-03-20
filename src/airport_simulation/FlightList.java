package airport_simulation;

import java.util.ArrayList;

public class FlightList {
    protected ArrayList<Flight> flights;

    public FlightList() {
        flights = new ArrayList<>();
    }

    public void add(Flight f) {
        flights.add(f);
    }

    public boolean isEmpty() {
        return flights.size() == 0;
    }

    public void action() {
        // Do nothing. Subclasses will override
    }
}
