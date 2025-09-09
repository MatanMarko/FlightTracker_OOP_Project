import java.util.ArrayList;
import java.util.List;

public class PrimaryAirline extends Airline {
    private ArrayList<SubAirline> subAirlines = new ArrayList<SubAirline>();
    public PrimaryAirline(String name) {
        super(name);
    }

    public SubAirline createSubAirline(String name) {
        SubAirline subAirline = new SubAirline(name);
        subAirlines.add(subAirline);
        return subAirline;
    }

    @Override
    public void displayAirlineDetails() {
        super.displayAirlineDetails();
        for (SubAirline subAirline : subAirlines) {
            subAirline.displayAirlineDetails();
        }
    }

    public List<Flight> getFlights() {
        List<Flight> companyFlights = new ArrayList<>();
        companyFlights.addAll(flights);
        for (SubAirline subAirline : subAirlines) {
            companyFlights.addAll(subAirline.getFlights());
        }
        return companyFlights;
    }
}

