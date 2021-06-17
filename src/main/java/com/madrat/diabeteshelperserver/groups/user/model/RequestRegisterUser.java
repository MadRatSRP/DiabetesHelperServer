package com.madrat.diabeteshelperserver.groups.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestRegisterUser {
    String emailOrPhoneNumber;

    String password;
}
