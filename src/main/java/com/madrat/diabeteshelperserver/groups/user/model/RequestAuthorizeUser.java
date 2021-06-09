package com.madrat.diabeteshelperserver.groups.user.model;

public class RequestAuthorizeUser {
    String emailOrPhoneNumber;

    String password;

    public RequestAuthorizeUser() {
    }

    public RequestAuthorizeUser(String emailOrPhoneNumber, String password) {
        this.emailOrPhoneNumber = emailOrPhoneNumber;
        this.password = password;
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

    @Override
    public String toString() {
        return "RequestAuthorizeUser{" +
                "emailOrPhoneNumber='" + emailOrPhoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
