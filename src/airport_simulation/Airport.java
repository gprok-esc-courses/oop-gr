package airport_simulation;

public class Airport {
    private FlightGenerator generator;
    private TakeOffList takeOff;
    private LandingList landing;
    private EmergencyList emergency;

    public Airport() {
        generator = new FlightGenerator();
        takeOff = new TakeOffList();
        landing = new LandingList();
        emergency = new EmergencyList();
    }

    public void flightRequest(int type) {
        Flight flight = generator.nextFlight();
        switch (type) {
            case 1:
                takeOff.add(flight);
                System.out.println(flight.getFlightNo() + " take off request");
                break;
            case 2:
                landing.add(flight);
                System.out.println(flight.getFlightNo() + " landing request");
                break;
            case 3:
                emergency.add(flight);
                System.out.println(flight.getFlightNo() + " emergency landing request");
                break;
        }
    }

    public void control() {
        System.out.print("CONTROL: ");
        if(!emergency.isEmpty()) {
            emergency.action();
        }
        else if(!landing.isEmpty()) {
            landing.action();
        }
        else if(!takeOff.isEmpty()) {
            takeOff.action();
        }
        else {
            System.out.println("No flight request");
        }
    }
}
