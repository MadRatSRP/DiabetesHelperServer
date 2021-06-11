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

    @Column(name = "userId")
    private Integer userId;

    public DiabetesNote() {

    }

    public DiabetesNote(
            Double sugarLevel,
            Integer userId
    ) {
       this.sugarLevel = sugarLevel;
       this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DiabetesNote{" +
                "id=" + id +
                ", sugarLevel=" + sugarLevel +
                ", userId=" + userId +
                '}';
    }
}
