import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByNumberOfConnections implements FlightSearchStrategy {
    @Override
    public List<Flight> search(List<Flight> flights) {
        return flights.stream()
                .sorted(Comparator.comparingInt(Flight::getConnectionsNum))
                .collect(Collectors.toList());
    }
}