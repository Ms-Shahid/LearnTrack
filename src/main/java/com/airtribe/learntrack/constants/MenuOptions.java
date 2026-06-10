package com.airtribe.learntrack.constants;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;
import java.util.Scanner;

public class MenuOptions {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(
                studentService, courseService
        );

        boolean running = true;

        while(running){
            System.out.println("========= LearnTrack =========");

            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    studentMenu(scanner, studentService);
                    break;

                case 2:
                    courseMenu(scanner, courseService);
                    break;

                case 3:
                    enrollmentMenu(
                            scanner,
                            enrollmentService,
                            studentService,
                            courseService
                    );
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting LearnTrack...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

    }

    private static void studentMenu(
            Scanner sc,
            StudentService studentService) {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Deactivate Student");
            System.out.println("6. Remove Student");
            System.out.println("7. Back");

            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {

                switch (choice) {

                    case 1:

                        System.out.print("First Name: ");
                        String firstName = sc.nextLine();

                        System.out.print("Last Name: ");
                        String lastName = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Batch: ");
                        String batch = sc.nextLine();

                        Student student =
                                new Student(
                                        IdGenerator.getNextStudentId(),
                                        firstName,
                                        lastName,
                                        email,
                                        batch);

                        studentService.addStudent(student);
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        studentService.listAllStudents();
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        String studentId = sc.nextLine();
                        Student found = studentService.getStudentById(studentId);
                        System.out.println(found.getDisplayName());
                        break;

                    case 4:

                        System.out.print("Student ID: ");
                        String updateId = sc.nextLine();

                        System.out.print("New firstName: ");
                        String firstName1 = sc.nextLine();

                        System.out.print("New lastName: ");
                        String lastName1 = sc.nextLine();

                        System.out.print("New Email: ");
                        String newEmail = sc.nextLine();

                        System.out.print("New Batch: ");
                        String newBatch = sc.nextLine();

                        studentService.updateStudentById(
                                updateId,
                                firstName1,
                                lastName1,
                                newEmail,
                                newBatch);

                        System.out.println("Student updated.");
                        break;

                    case 5:

                        System.out.print("Student ID: ");
                        String deactivateId = sc.nextLine();
                        studentService.deactivateStudentStatus(studentService.getStudentById(deactivateId).toString());
                        System.out.println("Student deactivated.");
                        break;

                    case 6:

                        System.out.print("Student ID: ");
                        String removeId = sc.nextLine();
                        studentService.removeStudentById(removeId);
                        System.out.println("Student removed.");
                        break;

                    case 7:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void courseMenu(
            Scanner sc,
            CourseService courseService) {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== COURSE MANAGEMENT =====");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course By ID");
            System.out.println("4. Activate Course");
            System.out.println("5. Deactivate Course");
            System.out.println("6. Back");

            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Course Name: ");
                        String name = sc.nextLine();

                        System.out.print("Description: ");
                        String description = sc.nextLine();

                        System.out.print("Duration (Weeks): ");
                        int duration =
                                Integer.parseInt(sc.nextLine());

                        Course course =
                                new Course(
                                        IdGenerator.getNextCourseId(),
                                        name,
                                        description,
                                        duration,
                                        true);

                        courseService.addCourse(course);
                        System.out.println("Course added.");
                        break;

                    case 2:
                        List<Course> courses =
                                courseService.viewAllCourses();

                        for (Course c : courses) {
                            System.out.println(c.getCourseName());
                        }
                        break;

                    case 3:
                        System.out.print("Course ID: ");
                        String courseId = sc.nextLine();

                        Course found =
                                courseService.getCourseById(courseId);

                        System.out.println(found);

                        break;

                    case 4:

                        System.out.print("Course ID: ");
                        String activateId = sc.nextLine();

                        Course activeCourse =
                                courseService.getCourseById(activateId);

                        courseService.setCourseActiveStatus(
                                activeCourse);

                        System.out.println("Course activated.");

                        break;

                    case 5:

                        System.out.print("Course ID: ");
                        String deactivateId = sc.nextLine();
                        Course inactiveCourse =
                                courseService.getCourseById(
                                        deactivateId);
                        courseService.setCourseDeActiveStatus(
                                inactiveCourse);
                        System.out.println("Course deactivated.");
                        break;

                    case 6:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void enrollmentMenu(
            Scanner sc,
            EnrollmentService enrollmentService,
            StudentService studentService,
            CourseService courseService) {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== ENROLLMENT MANAGEMENT =====");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Student Enrollments");
            System.out.println("3. Mark Completed");
            System.out.println("4. Mark Cancelled");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Student ID: ");
                        String studentId = sc.nextLine();

                        System.out.print("Course ID: ");
                        String courseId = sc.nextLine();

                        Enrollment enrollment = new Enrollment();
                        enrollmentService.enrollAStudent(
                                studentId,
                                courseId,
                                enrollment
                                );

                        System.out.println(
                                "Enrollment successful.");

                        break;

                    case 2:

                        System.out.print("Student ID: ");
                        String searchStudentId =
                                sc.nextLine();

                        List<Enrollment> enrollments =
                                enrollmentService
                                        .viewEnrollmentByStudentId(searchStudentId);

                        for (Enrollment currentEnrollment :
                                enrollments) {
                            System.out.println(currentEnrollment);
                        }
                        break;

                    case 3:
                        System.out.print("Enrollment ID: ");
                        String completeId =
                                sc.nextLine();
                        enrollmentService
                                .setEnrolmentStatusCompleted(
                                        completeId);
                        System.out.println(
                                "Enrollment completed.");
                        break;

                    case 4:

                        System.out.print("Enrollment ID: ");
                        String cancelId =
                                sc.nextLine();
                        enrollmentService
                                .setEnrolmentStatusCancelled(
                                        cancelId);
                        System.out.println(
                                "Enrollment cancelled.");
                        break;

                    case 5:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
