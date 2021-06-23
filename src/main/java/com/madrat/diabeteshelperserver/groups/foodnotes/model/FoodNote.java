package com.madrat.diabeteshelperserver.groups.foodnotes.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "foodnotes")
@Data
@NoArgsConstructor
public class FoodNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "userId")
    private Integer userId;
    
    @Column(name = "foodName")
    private String foodName;

    public FoodNote(
        Integer userId,
        String foodName
    ) {
        this.userId = userId;
        this.foodName = foodName;
    }
}
