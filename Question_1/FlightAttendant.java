public class FlightAttendant extends Passenger{
    public FlightAttendant(String name) {
        super(name);
    }

    public void joinFlightCrew(Flight flight){
        flight.addCrew(this);
    }
}
