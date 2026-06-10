package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();
    private StudentService studentService;
    private CourseService courseService;


    public EnrollmentService(StudentService studentService, CourseService courseService){
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public String enrollAStudent(String studentId,
                                 String courseId,
                                 Enrollment enrollment) throws EntityNotFoundException
    {
            Student currentStudent = studentService.getStudentById(studentId);

            Course currentCourse = courseService.getCourseById(courseId);

            if( currentStudent != null && currentCourse != null ) {
                enrollment.setEnrollmentStatus(EnrollmentStatus.ACTIVE);
                enrollment.setEnrollmentDate(new Date());
                enrollments.add(enrollment);
                return "Student Enrollment is successful";
            }

            throw new EntityNotFoundException("Course cannot be enrolled or already enrolled ");
    }

    public List<Enrollment> viewEnrollmentByStudentId(
           String studentId
    ){
        List<Enrollment> enrollmentByStudent = new ArrayList<>();

        for (Enrollment enrollment : enrollments){

           if(enrollment.getStudentId().equals(studentId)){
               enrollmentByStudent.add(enrollment);
           }
        }
        return enrollmentByStudent;
    }


    public void setEnrolmentStatusCompleted(String enrollmentId){

        for(Enrollment enrollment1: enrollments){
            if(enrollment1.getEnrollmentId().equals(enrollmentId)){
                enrollment1.setEnrollmentStatus(EnrollmentStatus.COMPLETED);
            }
        }
    }

    public void setEnrolmentStatusCancelled(String enrollmentId){

        for(Enrollment enrollment1: enrollments){
            if(enrollment1.getEnrollmentId().equals(enrollmentId)){
                enrollment1.setEnrollmentStatus(EnrollmentStatus.CANCELLED);
            }
        }
    }

}

