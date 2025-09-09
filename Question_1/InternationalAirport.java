import java.util.ArrayList;
import java.util.List;

public class InternationalAirport implements Airport {
    private String name;
    private String country;
    private String code;
    private ArrayList<Airline> airlines = new ArrayList<Airline>();

    private static InternationalAirport instance = null;

    private InternationalAirport(String name, String country, String code) {
        this.name = name;
        this.country = country;
        this.code = code;
    }

    public static InternationalAirport getInstance(String name, String country, String code) {
        if (instance == null) {
            instance = new InternationalAirport(name, country, code);
        }
        return instance;
    }

    public Airline createPrimaryAirline(String name) {
        Airline airline = new PrimaryAirline(name);
        airlines.add(airline);
        return airline;
    }

    public void removeAirline(Airline airline) {
        airlines.remove(airline);
    }

    public void displayAirportDetails() {
        System.out.println("\nInternational Airport " + name);
        for (Airline airline : airlines) {
            airline.displayAirlineDetails();
        }
    }
    public List<Flight> allFlights() {
        List<Flight> flights = new ArrayList<>();
        for (Airline airline : airlines) {
            flights.addAll(airline.getFlights());
        }
        return flights;
    }
}