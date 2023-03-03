package com.bettervns.studentsservice.models;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String father_name;
    private Date admissionDate;
    private String email;
    private int group_id;

    public Student() {
    }
    public Student(int id, String name, Date admissionYear, String email) {
        this.id = id;
        this.name = name;
        this.admissionDate = admissionYear;
        this.email = email;
    }

    public Student(int id, String name, String surname, String father_name, Date admissionDate, String email, int group_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.father_name = father_name;
        this.admissionDate = admissionDate;
        this.email = email;
        this.group_id = group_id;
    }

    public String getSurname() {
        return surname;
    }

    public String getFather_name() {
        return father_name;
    }

    public int getGroup_id() {
        return group_id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", father_name='" + father_name + '\'' +
                ", admissionDate=" + admissionDate +
                ", email='" + email + '\'' +
                ", group_id=" + group_id +
                '}';
    }
}