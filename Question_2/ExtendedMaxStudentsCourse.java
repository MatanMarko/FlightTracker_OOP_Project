public class ExtendedMaxStudentsCourse extends CourseDecorator{
    private int extraStudents;

    public ExtendedMaxStudentsCourse(Course decoratedCourse, int extraStudents) {
        super(decoratedCourse);
        this.extraStudents = extraStudents;
        for (Student student : decoratedCourse.getAssignedStudents()) {
            this.addStudent(student);
        }
    }

    @Override
    public void addStudent(Student student) {
        super.addStudent(student);
        if (decoratedCourse != null) {
            decoratedCourse.addStudent(student);
        }
    }


    @Override
    public int getMaxStudents() {
        return decoratedCourse.getMaxStudents() + extraStudents;
    }
}