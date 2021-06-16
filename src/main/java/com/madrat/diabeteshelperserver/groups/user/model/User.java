package com.madrat.diabeteshelperserver.groups.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "emailOrPhoneNumber")
    private String emailOrPhoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "userHashcode")
    private String userHashcode;

    @Column(name = "isAuthorized")
    private Boolean isAuthorized;

    public User(String emailOrPhoneNumber, String password) {
        this.emailOrPhoneNumber = emailOrPhoneNumber;
        this.password = password;
        this.isAuthorized = false;
    }
}
