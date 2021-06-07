package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import javax.persistence.*;

@Entity
@Table(name = "diabetesnotes")
public class DiabetesNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noteId")
    private Integer noteId;

    @Column(name = "sugarLevel")
    private Double sugarLevel;

    public DiabetesNote() {

    }

    public DiabetesNote(
            Double sugarLevel
    ) {
       this.sugarLevel = sugarLevel;
    }

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

    @Override
    public String toString() {
        return "DiabetesNote{" +
                "noteId=" + noteId +
                ", sugarLevel=" + sugarLevel +
                '}';
    }
}
