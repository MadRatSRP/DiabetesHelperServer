package com.madrat.diabeteshelperserver.groups.foodnotes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateFoodNote {
    String userHashcode;
    
    String foodName;
}

