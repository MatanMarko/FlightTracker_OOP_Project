public interface Airport {
    public static Airport getInstance(String name, String country, String code){
        return null;
    }
    public Airline createPrimaryAirline(String name);

    void removeAirline(Airline airline);
    void displayAirportDetails();
}
