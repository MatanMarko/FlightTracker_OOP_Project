public abstract class CourseDecorator extends Course {
    protected Course decoratedCourse;

    public CourseDecorator(Course decoratedCourse) {
        super(decoratedCourse.getType() ,decoratedCourse.getName(), decoratedCourse.getCourseNumber(), decoratedCourse.getMaxStudents());
        this.decoratedCourse = decoratedCourse;
    }
}