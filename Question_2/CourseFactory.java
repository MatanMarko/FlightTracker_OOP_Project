import java.util.ArrayList;

public class CourseFactory {
    public enum CourseType {
        REQUIRED, OPTIONAL, SEMINAR
    }

   //////////////////////////////////////////// DATA MEMBERS ////////////////////////////////////////
    private static CourseFactory instance = null;
    private ArrayList<Course> createdCourses = new ArrayList<>();

    //////////////////////////////////////////// CONSTRUCTOR ////////////////////////////////////////
    private CourseFactory() {}

    //////////////////////////////////////////// SINGLETON PATTERN ///////////////////////////////////////
    public static CourseFactory getInstance() {
        if (instance == null) {
            instance = new CourseFactory();
        }
        return instance;
    }

    /////////////////////////////////////////// METHODS ///////////////////////////////////////////

    protected Course createCourse(String type, String name, String courseNumber, int maxStudents) {
        for (Course course : createdCourses) {
            //String existingName = course.getName();
            //String existingCourseNumber = course.getCourseNumber();
            if (course.getName().equals(name) && course.getCourseNumber().equals(courseNumber)) {
                return course;
            }
        }

        Course newCourse = null;
        switch (type) {
            case "Required":
                newCourse = new RequiredCourse(name, courseNumber, maxStudents);
                break;
            case "Optional":
                newCourse = new OptionalCourse(name, courseNumber, maxStudents);
                break;
            case "Seminar":
                newCourse = new Seminar(name, courseNumber, maxStudents);
                break;
            default:
                throw new IllegalArgumentException("Invalid course type");
        }
        createdCourses.add(newCourse);
        return newCourse;
    }

    ////////////////////////////////////// CLASSES ////////////////////////////////////////////////////////
    private class RequiredCourse extends Course {
        public RequiredCourse(String name, String courseNumber, int maxStudents) {
            super("Required" ,name, courseNumber, maxStudents);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    private class OptionalCourse extends Course {
        public OptionalCourse(String name, String courseNumber, int maxStudents) {
            super("Optional", name, courseNumber, maxStudents);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    private class Seminar extends Course {
        public Seminar(String name, String courseNumber, int maxStudents) {
            super("Seminar", name, courseNumber, maxStudents);
        }
    }
}