package com.airtribe.learntrack.entity;

public class Student extends Person{

    private String batch;
    private boolean isActive;

    public Student(String id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
    }

    public Student(boolean isActive){
        this.isActive = isActive;
    }

    public Student() {
        super();
    }

    public String getStudentId() {
        return getId();
    }

    public void setStudentId(String studentId) {
        this.setId(studentId);
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

    @Override
    public String getDisplayName(){
        return super.getFirstName() + " " + super.getLastName();
    }
}
