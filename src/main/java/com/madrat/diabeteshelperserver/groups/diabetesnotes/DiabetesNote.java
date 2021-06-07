package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class DiabetesNote {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer noteId;
    private Double sugarLevel;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer id) {
        this.noteId = id;
    }

    public Double getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(Double sugarLevel) {
        this.sugarLevel = sugarLevel;
    }
}
