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
    private Integer id;
    
    private Integer userId;
    
    private Double glucoseLevel;
    
    private String noteTime;
    
    private String noteDate;

    public DiabetesNote(
            Integer userId,
            Double glucoseLevel,
            String noteTime,
            String noteDate
    ) {
       this.userId = userId;
       this.glucoseLevel = glucoseLevel;
       this.noteTime = noteTime;
       this.noteDate = noteDate;
    }
}
