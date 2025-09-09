import java.util.ArrayList;

public class UserManager {
    private static UserManager instance = null;
    private ArrayList<User> users;
    private static final int MAX_USERS = 100; // Maximum number of users

    // Constructor
    private UserManager() {
        users = new ArrayList<>();
    }

    // Singleton pattern
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void removeUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                users.remove(user);
                System.out.println("\nUser " + name + " signed out");
            }
        }
        System.out.println("\nUser not found or not logged in");
    }

    public boolean availableSlots() {
        return (MAX_USERS - users.size() > 0);
    }

    public Lecturer LecturerSignIn(String name) {
        if (!instance.availableSlots()) {
            System.out.println("No available slots in the system. Please try again later.");
            return null;
        }
        if (instance.getUser(name) == null) {
            Lecturer lecturer = Lecturer.createInstance(name);
            instance.addUser(lecturer);
            return lecturer;
        } else {
            return (Lecturer) instance.getUser(name);
        }
    }

    public Practitioner PractitionerSignIn(String name) {
        if (!instance.availableSlots()) {
            System.out.println("No available slots in the system. Please try again later.");
            return null;
        }
        if (instance.getUser(name) == null) {
            Practitioner practitioner = Practitioner.createInstance(name);
            instance.addUser(practitioner);
            return practitioner;
        } else {
            return (Practitioner) instance.getUser(name);
        }
    }

    public Student StudentSignIn(String name) {
        if (!instance.availableSlots()) {
            System.out.println("No available slots in the system. Please try again later.");
            return null;
        }
        if (instance.getUser(name) == null) {
            Student student = Student.createInstance(name);
            instance.addUser(student);
            return student;
        } else {
            return (Student) instance.getUser(name);
        }
    }

}
