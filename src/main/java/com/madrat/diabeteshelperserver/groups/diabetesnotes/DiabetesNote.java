package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "diabetesnotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiabetesNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer userId;
    
    private Double glucoseLevel;
    
    private String noteTime;
    
    private String noteDate;
}
