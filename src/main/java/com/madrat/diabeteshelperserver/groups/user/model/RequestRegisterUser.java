package com.madrat.diabeteshelperserver.groups.user.model;

import org.springframework.web.bind.annotation.RequestBody;

public class RequestRegisterUser {
    String emailOrPhoneNumber;

    String password;

    public String getEmailOrPhoneNumber() {
        return emailOrPhoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
