package com.example.administrator.stepdemo.model.request;

public class LoginRequest {

    private String pwd;
    private String userName;

    public LoginRequest(String name, String pwd) {
        this.pwd = pwd;
        this.userName = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
