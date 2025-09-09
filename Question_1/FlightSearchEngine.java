import java.util.List;
import java.util.Scanner;

public class FlightSearchEngine {
    private FlightSearchStrategy strategy;

    public FlightSearchEngine() {
        System.out.println("\nFlightSearchEngine created");
    }

    public void setStrategy(FlightSearchStrategy strategy) {
        this.strategy = strategy;
    }

//    public void search(List<Flight> flights, FlightSearchStrategy strategy) {
//        List<Flight> sortedFlights = strategy.search(flights);
//
//        System.out.println("\nSorted flights:");
//        for (Flight flight : sortedFlights) {
//            if (flight.getStatus().equals("cancelled")) {
//                continue;
//            }
//            flight.displayFlightDetails();
//        }
//    }


    /////////////optional way to implement search method which the user select the Strategy by input/////////////
    public void search(List<Flight> flights) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose filter strategy: \n1- All available flights \n2- By departure time \n3-  On time flights \n4- By number of connections \n5- By total time \n6- By cost");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                strategy = new SearchByAvailableFlights();
                break;
            case 2:
                strategy = new SearchByDepartureTime();
                break;
            case 3:
                strategy = new SearchByOnTimeFlights();
                break;
            case 4:
                strategy = new SearchByNumberOfConnections();
                break;
            case 5:
                strategy = new SearchByTotalTime();
                break;
            case 6:
                strategy = new SearchByPrice();
                break;
            default:
                System.out.println("\nInvalid choice. Please choose a number between 1 and 6.");
                return;
        }

        List<Flight> sortedFlights = strategy.search(flights);

        System.out.println("\nSorted flights:");
        for (Flight flight : sortedFlights) {
            if (flight.getStatus().equals("cancelled")) {
                continue;
            }
            flight.displayFlightDetails();
        }
    }
}