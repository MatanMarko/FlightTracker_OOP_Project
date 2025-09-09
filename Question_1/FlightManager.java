public class FlightManager {
    public static void main(String[] args) {
        ////////create airport (Singleton, cannot create more than one airport at a time)////////
        InternationalAirport TLV = InternationalAirport.getInstance("Ben Gurion","Israel", "TLV");

        ////////create airlines and subairlines ////////
        PrimaryAirline ElAl = (PrimaryAirline) TLV.createPrimaryAirline("ElAl");
        SubAirline Up = ElAl.createSubAirline("Up");
        PrimaryAirline FlyDubai = (PrimaryAirline) TLV.createPrimaryAirline("FlyDubai");
        PrimaryAirline WizzAir = (PrimaryAirline) TLV.createPrimaryAirline("WizzAir");

        ////////create flights////////
        Flight f1 = ElAl.createFlight("LY001", "TLV", "AMS", 0, "12:00", "17:00", 500, "On time");
        Flight f2 = Up.createFlight("LY002", "TLV", "JFK", 1, "14:00", "20:00",  1300, "On time");
        Flight f3 = FlyDubai.createFlight("FD001", "TLV", "DXB", 0, "10:00", "15:00", 800,  "On time");
        Flight f4 = FlyDubai.createFlight("FD002", "TLV", "LHR", 1, "16:00", "22:00", 1000, "On time");
        Flight f5 = ElAl.createFlight("LY003", "TLV", "CDG", 0, "08:00", "13:00", 700, "On time");
        Flight f6 = Up.createFlight("LY004", "TLV", "MIA", 1, "18:00", "23:00", 1500, "On time");
        Flight f7 = ElAl.createFlight("LY005", "TLV", "FCO", 0, "06:00", "11:00", 600, "On time");
        Flight f8 = WizzAir.createFlight("WZ001", "TLV", "BUD", 0, "20:00", "01:00", 400, "On time");
        Flight f9 = WizzAir.createFlight("WZ002", "TLV", "VIE", 0, "22:00", "03:00", 450, "On time");

        ////////Passengers that already booked a flight////////
        Passenger Max = f1.preOrderedPassenger("Max Verstappen", "123456", 30, "A1");
        Passenger Charles = f1.preOrderedPassenger("Charles Leclerc", "654321", 25, "B2");
        Passenger Lewis = f2.preOrderedPassenger("Lewis Hamilton", "456123", 35, "C3");
        Passenger Sebastian = f2.preOrderedPassenger("Sebastian Vettel", "321654", 33, "D4");
        Passenger Valtteri = f3.preOrderedPassenger("Valtteri Bottas", "654123", 31, "E5");
        Passenger Lando = f3.preOrderedPassenger("Lando Norris", "321456", 22, "F6");

        ////////Passengers that inside the airport without a ticket////////
        Traveler Daniel = new Traveler("Daniel Ricciardo", "123654", 32);
        Traveler Carlos = new Traveler("Carlos Sainz", "456321", 26);
        Traveler Sergio = new Traveler("Sergio Perez ", "654132", 31);
        Traveler Pierre = new Traveler("Pierre Gasly", "321654", 24);
        Traveler Esteban = new Traveler("Esteban Ocon", "456321", 24);
        Traveler Kimi = new Traveler("Kimi Raikkonen", "654321", 41);
        Traveler Antonio = new Traveler("Antonio Giovinazzi", "123456", 27);
        Traveler George = new Traveler("George Russell", "654123", 23);
        Traveler Nicholas = new Traveler("Nicholas Latifi", "321654", 25);
        Traveler Mick = new Traveler("Mick Schumacher", "456123", 22);
        Traveler Nikita = new Traveler("Nikita Mazepin", "654321", 22);
        Traveler Yuki = new Traveler("Yuki Tsunoda", "123654", 21);
        Traveler Fernando = new Traveler("Fernando Alonso", "321654", 39);

        ////////booking a flights ////////
        Daniel.bookFlight(f1);
        Carlos.bookFlight(f2);
        Sergio.bookFlight(f3);
        Pierre.bookFlight(f4);
        Esteban.bookFlight(f5);
        Kimi.bookFlight(f6);
        Antonio.bookFlight(f7);
        George.bookFlight(f8);
        Nicholas.bookFlight(f9);
        Mick.bookFlight(f1);
        Nikita.bookFlight(f2);
        Yuki.bookFlight(f3);
        Fernando.bookFlight(f4);

        ////////display airport details////////
        TLV.displayAirportDetails();

        ////////display flight f1 passengers////////
        f1.displayPassengers();

        ////////register notification center for flight updates////////
        Max.registerObserver(f1);
        Charles.registerObserver(f1);
        Lewis.registerObserver(f2);
        Sebastian.registerObserver(f2);
        Valtteri.registerObserver(f3);
        Lando.registerObserver(f3);
        Daniel.registerObserver(f1);
        Carlos.registerObserver(f2);
        Sergio.registerObserver(f3);
        Pierre.registerObserver(f4);

        ////////display flight details ////////
        System.out.println("\nFlight details:");
        f1.displayFlightDetails();
        f2.displayFlightDetails();

        ////////update flights status////////
        f1.delayFlight(2);
        f2.cancelFlight();
        f3.delayFlight(3);

        ////////display flight details ////////
        System.out.println("\nFlight details:");
        f1.displayFlightDetails();
        f2.displayFlightDetails();

        ////////trying to book a canceled flight////////
        Daniel.bookFlight(f2);

        //////// search engine ////////
        FlightSearchEngine skyscanner = new FlightSearchEngine();
        skyscanner.search(TLV.allFlights());

//        FlightSearchEngine searchEngine = new FlightSearchEngine();
//        searchEngine.search(TLV.allFlights(), new SearchByAvailableFlights());
    }
}
