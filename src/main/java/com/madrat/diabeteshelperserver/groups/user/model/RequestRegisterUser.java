package com.madrat.diabeteshelperserver.groups.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestRegisterUser {
    String emailOrPhoneNumber;

    String password;
}
