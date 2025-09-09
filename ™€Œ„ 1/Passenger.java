public abstract class Passenger implements Observer {
    private String name;
    private String passportNumber;
    private int age;
    private String seat;

    // constructor for new Passenger
    public Passenger(String name, String passportNumber, int age) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.age = age;
    }

    public Passenger(String name) {
        this.name = name;
    }

    // constructor for pre-ordered Passenger
    public Passenger(String name, String passportNumber, int age, String seat) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.age = age;
        this.seat = seat;
    }

    // getters and setters
    public String getName() {
        return this.name;
    }

    public String getPassportNumber() {
        return this.passportNumber;
    }

    public int getAge() {
        return this.age;
    }

    public String getSeat() {
        return this.seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

//    public void bookFlight(Flight flight) {
//        String newSeat = flight.setSeat();
//        if (flight.getStatus().equals("full") || newSeat == null) {
//            System.out.println("Sorry, the flight is fully booked.");
//        } else if (flight.getStatus().equals("cancelled")) {
//            System.out.println("Sorry, the flight is cancelled.");
//        }
//        this.seat = newSeat;
//        flight.preOrderedPassenger(name, passportNumber, age, seat);
//    }

    public void displayPassengerDetails() {
        System.out.println("Passenger name: " + name + ", Passport Number: " + passportNumber + ", Age: " + age + ", Seat: " + seat);
    }

    ////////////observer pattern methods////////////

    public void update(Flight flight) {
        if (flight.getStatus().equals("cancelled")) {
            System.out.println("Notification to " + name + ": , your flight is cancelled.");
        }
        if (flight.getStatus().equals("delayed")) {
            System.out.println("Notification to " + name + ": , your flight is delayed by " + flight.getDelayTime() + " hours. New departure time: " + flight.getDepartureTime() + ". New arrival time: " + flight.getArrivalTime() + ".");
        }
    }

    public void registerObserver(Subject flight) {
        flight.addObserver(this);
    }

    public void removeObserver(Subject flight) {
        flight.kickObserver(this);
    }

}
