package com.madrat.diabeteshelperserver.groups.user.model;

import com.madrat.diabeteshelperserver.groups.diabetesnotes.DiabetesNote;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
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
    private Integer userHashcode;

    @Column(name = "isAuthorized")
    private Boolean isAuthorized;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "users"
    )
    private Collection<DiabetesNote> diabetesNotes;

    public User() {

    }

    public User(String emailOrPhoneNumber, String password) {
        this.emailOrPhoneNumber = emailOrPhoneNumber;
        this.password = password;
        this.isAuthorized = false;
    }

    public Collection<DiabetesNote> getDiabetesNotes() {
        return diabetesNotes;
    }

    public void setDiabetesNotes(Collection<DiabetesNote> diabetesNotes) {
        this.diabetesNotes = diabetesNotes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer userId) {
        this.id = userId;
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
                "id=" + id +
                ", emailOrPhoneNumber='" + emailOrPhoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", userHashcode=" + userHashcode +
                ", isAuthorized=" + isAuthorized +
                '}';
    }
}
