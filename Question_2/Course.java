import java.util.ArrayList;

public abstract class Course {
    private String type;
    private String name;
    private String courseNumber;
    private int maxStudents;
    private ArrayList<Student> assignedStudents = new ArrayList<>();
    private ArrayList<Student> waitingList = new ArrayList<>();

    protected Course(String type, String name, String courseNumber, int maxStudents) {
        this.type = type;
        this.name = name;
        this.courseNumber = courseNumber;
        this.maxStudents = maxStudents;
    }

    protected String getName() {
        return name;
    }

    protected String getType() {
        return type;
    }
    protected boolean isFull() {
        return assignedStudents.size() >= maxStudents;
    }

    protected String getCourseNumber() {
        return courseNumber;
    }

    protected void addStudent(Student student) {
        if (isFull()) {
            System.out.println("\nNotification to " + student.getName() + ": The course " + getName() + " is full. You can be added to the waiting list.");
            return;
        }
        assignedStudents.add(student);
    }

    protected void addStudentToWaitingList(Student student) {
        waitingList.add(student);
    }

    protected void removeStudent(Student student) {
        assignedStudents.remove(student);
        updateWaitingList();
    }

    protected void updateWaitingList() {
        if (!isFull() && !waitingList.isEmpty()) {
            for (Student student : waitingList) {
                student.update(this);
            }
        }
    }

    protected int getMaxStudents() {
        return maxStudents;
    }

    public void showStudents() {
        System.out.println("\nStudents in course " + getName() + ":");
        for (Student student : assignedStudents) {
            System.out.print(student.getName()+", ");
        }
        System.out.println();
    }

    protected ArrayList<Student> getAssignedStudents() {
        return assignedStudents;
    }

    protected void mergeCourses(Course otherCourse) {
        if (this.getCourseNumber().equals(otherCourse.getCourseNumber())) {
            this.maxStudents =  Math.max(this.maxStudents, otherCourse.getMaxStudents());
            for (Student student : otherCourse.getAssignedStudents()) {
                if (!this.assignedStudents.contains(student)) {
                    this.addStudent(student);
                }
            }
        } else {
            System.out.println("Courses cannot be merged as they do not have the same course number.");
        }
    }
}