package com.example.project;

public class Volunteer {
    String name;
    String email;
    String faculty;
    String department;

    public Volunteer(String name, String email, String faculty, String department) {
        this.name = name;
        this.email = email;
        this.faculty = faculty;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }
}
