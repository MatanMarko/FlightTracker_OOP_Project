import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Airline {
    protected String name;
    protected ArrayList<Flight> flights = new ArrayList<Flight>();
    public Airline(String name) {
        this.name = name;
    }

    public Flight createFlight(String flightNumber, String source, String destination, int connections_num, String departure_time, String arrival_time, int cost, String status) {
        Flight flight = new Flight(flightNumber, source, destination, connections_num, departure_time, arrival_time, cost ,status);
        flights.add(flight);
        return flight;
    }

    public void displayAirlineDetails() {
        if(!flights.isEmpty()){
            System.out.println("\n" + "The flights of " + name + "- airline" + " are:");
            for (Flight flight : flights) {
                if (!flight.getStatus().equals("cancelled")) {
                    flight.displayFlightDetails();
                }
                else{
                    System.out.println("Flight " + flight.getFlightNumber() + " is cancelled.");
                }
            }
        }
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
