package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.exception.NotValidEmailException;
import com.airtribe.learntrack.util.InputValidator;

public class Person {

    public String firstName;
    public String lastName;
    public String email;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NotValidEmailException {

        if(InputValidator.emailValidator(email)){
            this.email = email;
        }else throw new NotValidEmailException("Not a valid email");

    }

    public void getDisplayName(){
        System.out.println(
                this.firstName + " " + this.lastName
        );
    }
}
