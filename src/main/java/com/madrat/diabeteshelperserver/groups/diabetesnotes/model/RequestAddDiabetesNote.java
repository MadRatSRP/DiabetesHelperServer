package com.madrat.diabeteshelperserver.groups.diabetesnotes.model;

import com.madrat.diabeteshelperserver.groups.diabetesnotes.DiabetesNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAddDiabetesNote {
    Double sugarLevel;

    String userHashcode;
}
