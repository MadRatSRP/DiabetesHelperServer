package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "diabetesnotes")
@Data
@NoArgsConstructor
public class DiabetesNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userId")
    private Integer userId;
    
    @Column(name = "sugarLevel")
    private Double sugarLevel;

    public DiabetesNote(
            Integer userId,
            Double sugarLevel
    ) {
       this.userId = userId;
       this.sugarLevel = sugarLevel;
    }
}
