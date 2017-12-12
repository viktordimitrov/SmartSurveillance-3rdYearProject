package com.example.buckybarnes.test;

/**
 * Created by Dailin Luo on 2017/11/26.
 * Unless specified as personal contribution, this class is adapted from website:
 * http://www.androidtutorialshub.com/android-login-and-register-with-sqlite-database-tutorial/
 */

public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
