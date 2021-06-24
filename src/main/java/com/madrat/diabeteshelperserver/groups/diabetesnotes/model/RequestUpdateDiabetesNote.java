package com.madrat.diabeteshelperserver.groups.diabetesnotes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateDiabetesNote {
    String userHashcode;
    Double glucoseLevel;
    String noteTime;
    String noteDate;
}
