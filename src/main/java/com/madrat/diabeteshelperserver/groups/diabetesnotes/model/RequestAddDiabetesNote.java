package com.madrat.diabeteshelperserver.groups.diabetesnotes.model;

import com.madrat.diabeteshelperserver.groups.diabetesnotes.DiabetesNote;

public class RequestAddDiabetesNote {
    DiabetesNote diabetesNote;

    String userHashcode;

    public RequestAddDiabetesNote() {
    }

    public RequestAddDiabetesNote(DiabetesNote diabetesNote, String userHashcode) {
        this.diabetesNote = diabetesNote;
        this.userHashcode = userHashcode;
    }

    public DiabetesNote getDiabetesNote() {
        return diabetesNote;
    }

    public void setDiabetesNote(DiabetesNote diabetesNote) {
        this.diabetesNote = diabetesNote;
    }

    public String getUserHashcode() {
        return userHashcode;
    }

    public void setUserHashcode(String userHashcode) {
        this.userHashcode = userHashcode;
    }

    @Override
    public String toString() {
        return "RequestAddDiabetesNote{" +
                "diabetesNote=" + diabetesNote +
                ", userHashcode='" + userHashcode + '\'' +
                '}';
    }
}
