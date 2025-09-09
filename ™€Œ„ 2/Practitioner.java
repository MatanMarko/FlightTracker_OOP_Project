public class Practitioner implements User{
    private String name;
    private UserManager userManager1 = UserManager.getInstance();   //because UserManagers are singletons, we can use the same instance to add the new user and to check if the user already exists
    private CourseFactory courseFactory = CourseFactory.getInstance();  //because CourseFactories are singletons, we can use the same instance to create a new course

    @Override
    public String getName() {
        return name;
    }

    private Practitioner(String name) {
        this.name = name;
    }

    public static Practitioner createInstance(String name){
        return new Practitioner(name);
    }

    public void signOut() {
        if (userManager1.getUser(this.name) != null) {
            userManager1.removeUser(this.name);
        }
    }

    public Course createCourse(String type, String name, String courseNumber, int maxStudents) {
        return courseFactory.createCourse(type, name, courseNumber, maxStudents);
    }
}
