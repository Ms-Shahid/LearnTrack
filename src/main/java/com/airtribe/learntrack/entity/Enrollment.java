package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Date;
import java.util.List;

public class Enrollment {

    private String enrollmentId;
    private String studentId;
    private String courseId;

    private Date enrollmentDate;
    private EnrollmentStatus enrollmentStatus;

    public Enrollment(){}

    public Enrollment(String enrollmentId, String studentId, String courseId, Date enrollmentDate, EnrollmentStatus enrollmentStatus) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }


    public String getCourseId() {
        return courseId;
    }


    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus)  {
            this.enrollmentStatus = enrollmentStatus;
    }
}
