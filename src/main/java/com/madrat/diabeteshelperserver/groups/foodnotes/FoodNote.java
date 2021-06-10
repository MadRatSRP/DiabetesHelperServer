package com.madrat.diabeteshelperserver.groups.foodnotes;


import javax.persistence.*;

@Entity
@Table(name = "foodnotes")
public class FoodNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "foodName")
    private String foodName;

    public FoodNote() {

    }

    public FoodNote(
            String foodName
    ) {
        this.foodName = foodName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer noteId) {
        this.id = noteId;
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
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
