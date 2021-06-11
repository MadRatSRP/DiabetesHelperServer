package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import com.madrat.diabeteshelperserver.groups.user.model.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "diabetesnotes")
public class DiabetesNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sugarLevel")
    private Double sugarLevel;

    public DiabetesNote() {

    }

    public DiabetesNote(
            Double sugarLevel
    ) {
       this.sugarLevel = sugarLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(Double sugarLevel) {
        this.sugarLevel = sugarLevel;
    }
}
