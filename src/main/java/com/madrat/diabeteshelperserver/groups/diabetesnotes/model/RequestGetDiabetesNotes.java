package com.madrat.diabeteshelperserver.groups.diabetesnotes.model;

public class RequestGetDiabetesNotes {
    String userHashcode;

    public RequestGetDiabetesNotes() {
    }

    public RequestGetDiabetesNotes(String userHashcode) {
        this.userHashcode = userHashcode;
    }

    public String getUserHashcode() {
        return userHashcode;
    }

    public void setUserHashcode(String userHashcode) {
        this.userHashcode = userHashcode;
    }

    @Override
    public String toString() {
        return "RequestGetDiabetesNotes{" +
                "userHashcode='" + userHashcode + '\'' +
                '}';
    }
}
