public interface Subject {
    public void addObserver(Observer observer);
    public void kickObserver(Observer observer);
    public void notifyObservers();
}
