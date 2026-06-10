package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public Course addCourse(Course course){

        courses.add(course);
        return course;
    }

    public Course getCourseById(String courseId) throws EntityNotFoundException {

        for (Course course :  courses) {
            if (course.getCourseId().equals(courseId))
                return course;
        }
        throw new EntityNotFoundException("Course not found!");
    }

    public List<Course> viewAllCourses(){

        return courses;
    }

    public void setCourseActiveStatus(Course course){

        for (Course currentCourse : courses){
            if( currentCourse.getCourseId().equals(course.getCourseId()) ){
                if(currentCourse.isActive()) currentCourse.setActive(false);
            }
        }
    }

    public void setCourseDeActiveStatus(Course course){

        for (Course currentCourse : courses){
            if( currentCourse.getCourseId().equals(course.getCourseId()) ){
                if(!currentCourse.isActive()) currentCourse.setActive(true);
            }
        }
    }
}
