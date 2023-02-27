package com.bettervns.adminapi.models;

import javax.validation.constraints.*;
import java.sql.Date;

public class Student {
    private int id;

    @NotEmpty(message = "Student should have name")
    @Size(min = 2, max = 20, message = "Name should have more than 2 and less than 20 letters")
    private String name;

    private Date admissionDate;

    @NotEmpty(message = "Invalid email")
    //@Email(message = "Invalid email")
    private String email;

    public Student() {
    }
    public Student(int id, String name, Date admissionYear, String email) {
        this.id = id;
        this.name = name;
        this.admissionDate = admissionYear;
        this.email = email;
    }

    public Date getCourse(){
        return admissionDate;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}