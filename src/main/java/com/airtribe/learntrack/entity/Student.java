package com.airtribe.learntrack.entity;

public class Student extends Person{

    private String studentId;
    private String batch;
    private boolean isActive;

    public Student(String id, String firstName, String lastName, String email, String batch) {
        this.studentId = id;
        super(firstName, lastName, email);
        this.batch = batch;
    }

    public Student(boolean isActive){
        this.isActive = isActive;
    }

    public Student() {
        super();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
