import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByPrice implements FlightSearchStrategy {
    @Override
    public List<Flight> search(List<Flight> flights) {
        return flights.stream()
                .sorted(Comparator.comparingDouble(Flight::getCost))
                .collect(Collectors.toList());
    }
}

