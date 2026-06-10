package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.NotValidEmailException;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.*;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {

        students.add(student);
        return student;
    }

    public void listAllStudents() {

        for (Student student : students) {
            System.out.println(student.getStudentId() + " " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public Student getStudentById(String uuid) throws EntityNotFoundException {

        for (Student student : students) {
            if (student.getStudentId().equals(uuid))
                return student;
        }
        throw new EntityNotFoundException("Student not found!");
    }

    public void deactivateStudentStatus(String studentId) throws EntityNotFoundException {

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setActive(false);
                return;
            }
        }
        throw new EntityNotFoundException("Student not found");
    }

    public void removeStudentById(String studentId) throws EntityNotFoundException {

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                students.remove(student);
                return;
            }
        }
        throw new EntityNotFoundException("Student not found!");
    }

    public void updateStudentById(
            String studentId,
            String firstName,
            String lastName,
            String email,
            String batch
    ) throws EntityNotFoundException, NotValidEmailException {

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setBatch(batch);
                return;
            }
        }
        throw new EntityNotFoundException("Student not found!");
    }
}
