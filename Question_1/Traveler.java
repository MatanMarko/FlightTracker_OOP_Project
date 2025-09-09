public class Traveler extends Passenger {
    public Traveler(String name, String passportNumber, int age) {
        super(name, passportNumber, age);
    }

    public Traveler(String name, String passportNumber, int age, String seat) {
        super(name, passportNumber, age, seat);
    }

    public void bookFlight(Flight flight) {
        String newSeat = flight.setSeat();
        if (flight.getStatus().equals("full") || newSeat == null) {
            System.out.println("\n"+ getName() + " tried to book a ticket to flight " + flight.getFlightNumber() +"but the flight is fully booked.");
        } else if (flight.getStatus().equals("cancelled")) {
            System.out.println("\n"+ getName() + " tried to book a ticket to flight " + flight.getFlightNumber() +"but the flight has been cancelled.");
        }
        this.setSeat(newSeat);
        flight.preOrderedPassenger(getName(), getPassportNumber(), getAge(), getSeat());
    }

}
