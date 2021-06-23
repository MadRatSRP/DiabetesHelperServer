package com.madrat.diabeteshelperserver.groups.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateProduct {
    private String productName;
    
    private Integer proteins;
    
    private Integer fats;
    
    private Integer carbohydrates;
    
    private Integer calories;
}
