import java.util.List;
import java.util.stream.Collectors;

public class SearchByAvailableFlights implements FlightSearchStrategy {
    @Override
    public List<Flight> search(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> !flight.getStatus().equals("Cancelled"))
                .collect(Collectors.toList());
    }
}