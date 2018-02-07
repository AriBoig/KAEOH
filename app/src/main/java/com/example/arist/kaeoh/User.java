package com.example.arist.kaeoh;

/**
 * Created by arist on 07/02/2018.
 */

public class User {
    private int uid;
    private String username;
    private String email;
    private String pwd;

    public User() {

    }

    public User(int uid, String username, String email, String pwd) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
