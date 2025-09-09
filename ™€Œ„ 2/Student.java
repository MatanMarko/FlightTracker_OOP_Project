public class Student implements User{
    private String name;
    private UserManager userManager1 = UserManager.getInstance();

    @Override
    public String getName() {
        return name;
    }

    private Student(String name) {
        this.name = name;
    }

    public static Student createInstance(String name){
        return new Student(name);
    }

    public void signOut() {
        if (userManager1.getUser(this.name) != null) {
            userManager1.removeUser(this.name);
        }
    }

    public void addCourseToCart(Course course) {
            course.addStudent(this);
    }

    public void notifyWhenAvailable(Course course) {
        if (course.isFull()) {
            course.addStudentToWaitingList(this);
            System.out.println("\nNotification to " + name +": You will be notified when " + course.getName() + " becomes available.");
        }
    }

    public void leaveCourse(Course course) {
        course.removeStudent(this);
    }

    public void update(Course course) {
        System.out.println("\nNotification to " + name +": The course " + course.getName() + " is now available.");
    }
}
