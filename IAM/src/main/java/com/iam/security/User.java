package com.iam.security;


public class User {
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String role;

    public User (){}

    public User(String username, String firstName, String lastName, String email,String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;

    }
}