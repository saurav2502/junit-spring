package com.junit.spring.junittest.model;

public class UserModel {
    private String userName;
    private String userPassword;
    private Integer userId;

    public UserModel() {
    }

    public UserModel(String userName, String userPassword, Integer userId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userId=" + userId +
                '}';
    }
}
