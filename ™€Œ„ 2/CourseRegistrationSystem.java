public class CourseRegistrationSystem {
    public static void main(String[] args) {

        UserManager userManager = UserManager.getInstance();
        CourseFactory courseFactory = CourseFactory.getInstance();

        ///////////////////////////// create Lecturers, Practitioners and Students /////////////////////////////

        Lecturer lecturer_1 = userManager.LecturerSignIn("lecturer_1");
        Lecturer lecturer_2 = userManager.LecturerSignIn("lecturer_2");
        Lecturer lecturer_3 = userManager.LecturerSignIn("lecturer_3");

        Practitioner practitioner_1 = userManager.PractitionerSignIn("practitioner_1");
        Practitioner practitioner_2 = userManager.PractitionerSignIn("practitioner_2");
        Practitioner practitioner_3 = userManager.PractitionerSignIn("practitioner_3");

        Student student_1 = userManager.StudentSignIn("student_1");
        Student student_2 = userManager.StudentSignIn("student_2");
        Student student_3 = userManager.StudentSignIn("student_3");
        Student student_4 = userManager.StudentSignIn("student_4");
        Student student_5 = userManager.StudentSignIn("student_5");
        Student student_6 = userManager.StudentSignIn("student_6");
        Student student_7 = userManager.StudentSignIn("student_7");
        Student student_8 = userManager.StudentSignIn("student_8");
        Student student_9 = userManager.StudentSignIn("student_9");
        Student student_10 = userManager.StudentSignIn("student_10");
        Student student_11 = userManager.StudentSignIn("student_11");
        Student student_12 = userManager.StudentSignIn("student_12");
        Student student_13 = userManager.StudentSignIn("student_13");
        Student student_14 = userManager.StudentSignIn("student_14");
        Student student_15 = userManager.StudentSignIn("student_15");


        ///////////////////////////// Lecturers and Practitioners create Courses /////////////////////////////

        Course CSIntro = lecturer_1.createCourse("Required", "CS intro", "2168", 2);
        Course LinearAlgebra = practitioner_1.createCourse("Required", "Linear Algebra", "2153", 20);
        Course IceCream = lecturer_2.createCourse("Optional", "Ice cream", "1010", 5);
        Course SpanishForBeginners = practitioner_2.createCourse("Seminar", "Spanish for beginners", "6712", 30);
        Course Physics = lecturer_3.createCourse("Required", "Physics", "5647", 10);
        Course Chemistry = practitioner_3.createCourse("Required", "Chemistry", "1531", 10);

        ///////////////////////////// Students add Courses to their basket /////////////////////////////

        student_1.addCourseToCart(CSIntro);
        student_2.addCourseToCart(CSIntro);

        student_3.addCourseToCart(CSIntro);      // fails

        student_3.notifyWhenAvailable(CSIntro);     // student_3 registers to the observer

        student_4.addCourseToCart(CSIntro);   // fails

        student_4.notifyWhenAvailable(CSIntro);    // student_4 registers to the observer

        student_5.addCourseToCart(LinearAlgebra);
        student_6.addCourseToCart(LinearAlgebra);
        student_7.addCourseToCart(LinearAlgebra);
        student_8.addCourseToCart(IceCream);
        student_9.addCourseToCart(IceCream);
        student_10.addCourseToCart(IceCream);
        student_11.addCourseToCart(SpanishForBeginners);
        student_12.addCourseToCart(SpanishForBeginners);
        student_13.addCourseToCart(SpanishForBeginners);
        student_14.addCourseToCart(Physics);
        student_15.addCourseToCart(Chemistry);

        student_1.leaveCourse(CSIntro);     // student_1 leaves the course (now there is a free slot)
        student_2.leaveCourse(CSIntro);     // student_2 leaves the course (now there are 2 free slot)
        student_5.leaveCourse(LinearAlgebra);       // student_5 leaves the course

        student_3.addCourseToCart(CSIntro);       // student_3 adds the course to the basket (now there is 1 free slot)
        student_5.addCourseToCart(CSIntro);       // student_5 adds the course to the basket (the course is full)

        student_1.addCourseToCart(IceCream);
        student_4.addCourseToCart(IceCream);

        student_2.addCourseToCart(IceCream);

        Course extendedCSIntro = new ExtendedMaxStudentsCourse(CSIntro, 3);     //Decorator pattern to extend the max students of a course
        CSIntro.mergeCourses(extendedCSIntro);      // merge the courses so CSIntro has 3 more slots

        student_2.addCourseToCart(CSIntro);       // student_2 adds the course to the basket (now there is 2 free slot)
        student_3.addCourseToCart(CSIntro);       // student_3 adds the course to the basket (now there is 1 free slot)
        student_4.addCourseToCart(CSIntro);       // student_4 adds the course to the basket (the course is full)

        CSIntro.showStudents();
        LinearAlgebra.showStudents();
        IceCream.showStudents();
        SpanishForBeginners.showStudents();
        Physics.showStudents();
        Chemistry.showStudents();


        /////////////////////////////////// Create an already existing course ///////////////////////////////////
        Course course1 = courseFactory.createCourse("Required", "CS intro", "2168", 2);
        System.out.println( "\n course1 equal to CSIntro = "+ course1.equals(CSIntro));     // true because they have the same course number and name so the singleton pattern is applied

    }
}
