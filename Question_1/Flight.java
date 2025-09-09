import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Flight implements Subject {
    private final String flightNumber;
    private final String source;
    private String destination;
    private int connections_num;
    private String departure_time;
    private String arraival_time;
    private int cost;
    private String status; // on time, delayed, cancelled or full
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private ArrayList<String> occupiedSeats = new ArrayList<>();
    private int delayTime;
    private ArrayList<FlightAttendant> crew = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    //////////////constructor//////////////

    public Flight(String flightNumber, String source, String destination, int connections_num, String departure_time, String arrival_time, int cost, String status) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.connections_num = connections_num;
        this.departure_time = departure_time;
        this.arraival_time = arrival_time;
        this.cost = cost;
        this.status = status;
    }

    //////////////getters and setters//////////////

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getDelayTime() {
        return (delayTime);
    }

    public String getDepartureTime() {
        return departure_time;
    }

    public String getArrivalTime() {
        return arraival_time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getConnectionsNum() {
        return connections_num;
    }

    ////////////// Observer Pattern methods //////////////

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void kickObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        System.out.println("\nNotifying all passengers of flight " + flightNumber + ":");
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    /////////////////methods////////////////////

    public Passenger preOrderedPassenger(String name, String passportNumber, int age, String seat) {
        Traveler traveler = new Traveler(name, passportNumber, age, seat);
        passengers.add(traveler);
        occupiedSeats.add(seat);
        return traveler;
    }

    public void displayFlightDetails() {
        System.out.println("Flight " + flightNumber + ", from " + source + ", to " + destination + " (" + connections_num + " connections), Departure Time: " + departure_time + ", Arrival Time: " + arraival_time + ", Status: " + status + ", Cost: " + cost + " $");
    }

    public void displayPassengers() {
        System.out.println("\nPassengers on flight " + flightNumber + ":");
        for (Passenger passenger : passengers) {
            passenger.displayPassengerDetails();
        }
    }

    public String findAvailableSeat() {
        // Assuming the flight has 26 rows (A-Z) and each row has 10 seats (1-10)
        for (char row = 'A'; row <= 'Z'; row++) {
            for (int seatNum = 1; seatNum <= 10; seatNum++) {
                String seat = row + String.valueOf(seatNum);
                if (!occupiedSeats.contains(seat)) {
                    return seat;
                }
            }
        }
        return null;
    }

    public String setSeat () {
        String availableSeat = findAvailableSeat();
        if (availableSeat != null) {
            occupiedSeats.add(availableSeat);
            return availableSeat;
        } else {
            System.out.println("\nSorry, all seats are occupied.");
            status = "full";
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public void cancelFlight() {
        status = "cancelled";
        this.arraival_time = "xx:xx";
        this.departure_time = "xx:xx";
        System.out.println("\nFlight " + flightNumber + " is cancelled.");
        notifyObservers();
    }

    public void delayFlight(int hours) {
        this.status = "delayed";
        this.delayTime = hours;

        System.out.println("\nFlight " + flightNumber + " is delayed by " + hours + " hours.");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime departureTime = LocalTime.parse(this.departure_time, formatter);
        LocalTime arrivalTime = LocalTime.parse(this.arraival_time, formatter);

        departureTime = departureTime.plusHours(hours);
        arrivalTime = arrivalTime.plusHours(hours);

        this.departure_time = departureTime.format(formatter);
        this.arraival_time = arrivalTime.format(formatter);

        notifyObservers();
    }

    public void addCrew(FlightAttendant flightAttendant) {
        if (crew.size() <15) {
            crew.add(flightAttendant);

        //} else {
            //System.out.println("\nSorry, the crew is full.");
        }
    }

    public int getTotalTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime departureTime = LocalTime.parse(this.departure_time, formatter);
        LocalTime arrivalTime = LocalTime.parse(this.arraival_time, formatter);

        return (arrivalTime.getHour() - departureTime.getHour())+ (arrivalTime.getMinute() - departureTime.getMinute());
    }
}
