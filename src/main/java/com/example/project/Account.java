package com.example.project;

public class Account implements Admin{
    public static String username;
    public static String password;
    Boolean role;
    public Boolean isAdmin() {
        return role;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password =  password;
        this.role = false;
    }
    public Account(String username, String password, Boolean role) {
        this.username = username;
        this.password =  password;
        this.role = role;
    }
}
