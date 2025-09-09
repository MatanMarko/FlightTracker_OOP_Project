public interface Observer {
    public void update(Flight flight);

    public void registerObserver(Subject subject);

    public void removeObserver(Subject subject);
}
