package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.NotValidEmailException;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.*;

public class StudentService {

    List<Student> students = new ArrayList<>();

    public Student addStudent(Student student) throws NotValidEmailException {

        student.setStudentId(IdGenerator.getNextStudentId());
        student.setEmail(student.getEmail());
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setBatch(student.getBatch());
        student.setActive(student.isActive());

        students.add(student);

        return new Student(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getBatch()
        );
    }

    public void listAllStudents() {

        for (Student student : students) {
            System.out.println(student.getStudentId() + " " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public Student getStudentById(String uuid) throws EntityNotFoundException {

        Student student = new Student();
        if( !students.contains(uuid)) throw new EntityNotFoundException("Student not found!");

        return student;

    }

    public void deactivateStudentStatus(String studentId) throws EntityNotFoundException {

        if( !students.contains(studentId)) throw new EntityNotFoundException("Student not found!");

        Student student = new Student();
        student.setActive(false);
    }
}
