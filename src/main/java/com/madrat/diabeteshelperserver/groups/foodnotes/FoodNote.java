package com.madrat.diabeteshelperserver.groups.foodnotes;


import javax.persistence.*;

@Entity
@Table(name = "foodnotes")
public class FoodNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noteId")
    private Integer noteId;

    @Column(name = "foodName")
    private String foodName;

    public FoodNote() {

    }

    public FoodNote(String foodName) {
        this.foodName = foodName;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "FoodNote{" +
                "noteId=" + noteId +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
