import java.util.List;
import java.util.stream.Collectors;

public class SearchByOnTimeFlights implements FlightSearchStrategy {
    @Override
    public List<Flight> search(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getStatus().equals("On time"))
                .collect(Collectors.toList());
    }
}