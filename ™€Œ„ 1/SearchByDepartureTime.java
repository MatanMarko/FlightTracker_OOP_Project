import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByDepartureTime implements FlightSearchStrategy {
    @Override
    public List<Flight> search(List<Flight> flights) {
        return flights.stream()
                .sorted(Comparator.comparing(Flight::getDepartureTime))
                .collect(Collectors.toList());
    }
}
