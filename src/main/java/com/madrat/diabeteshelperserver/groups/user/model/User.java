package com.madrat.diabeteshelperserver.groups.user.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "emailOrPhoneNumber")
    private String emailOrPhoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "userHashcode")
    private Integer userHashcode;

    @Column(name = "isAuthorized")
    private Boolean isAuthorized;

    public User() {

    }

    public User(String emailOrPhoneNumber, String password) {
        this.emailOrPhoneNumber = emailOrPhoneNumber;
        this.password = password;
        this.isAuthorized = false;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmailOrPhoneNumber() {
        return emailOrPhoneNumber;
    }

    public void setEmailOrPhoneNumber(String emailOrPhoneNumber) {
        this.emailOrPhoneNumber = emailOrPhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserHashcode() {
        return userHashcode;
    }

    public void setUserHashcode(Integer userHashcode) {
        this.userHashcode = userHashcode;
    }

    public Boolean getAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(Boolean authorized) {
        isAuthorized = authorized;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", emailOrPhoneNumber='" + emailOrPhoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", userHashcode=" + userHashcode +
                ", isAuthorized=" + isAuthorized +
                '}';
    }
}
