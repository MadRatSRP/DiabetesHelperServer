package com.madrat.diabeteshelperserver;

import com.madrat.diabeteshelperserver.groups.diabetesnotes.DiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.DiabetesServiceImpl;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestAddDiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestDeleteDiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestGetDiabetesNotes;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestUpdateDiabetesNote;
import com.madrat.diabeteshelperserver.groups.user.UserServiceImpl;
import com.madrat.diabeteshelperserver.groups.user.model.RequestRegisterUser;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DiabetesTest {
    @Autowired
    DiabetesServiceImpl diabetesService;
    
    @Autowired
    UserServiceImpl userService;
    
    @Test
    void mainTest() {
        userService.deleteAllRows();
        diabetesService.deleteAllRows();
        
        String currentUserHashcode = userService.registerUser(
            new RequestRegisterUser(
                "jojo",
                "1234"
            )
        );
        
        Double[] values = {55.25, 66.66, 77.77, 77.88};
        
        testDiabetesMethods(currentUserHashcode, values);
    }
    
    void testDiabetesMethods(
        String userHashcode,
        Double[] values
    ) {
        for (Double value : values) {
            diabetesService.addNote(
                new RequestAddDiabetesNote(
                    userHashcode,
                    value,
                    "18:00",
                    "19.12.21"
                )
            );
        }
    
        
        List<DiabetesNote> notes = diabetesService.getAllNotes(
            userHashcode
        );
        for (DiabetesNote note: notes) {
            System.out.println("NewNote");
            System.out.println("New Note:" + note.toString());
        }
    
        for (DiabetesNote note: notes) {
            diabetesService.updateNote(
                note.getId(),
                
                new RequestUpdateDiabetesNote(
                    userHashcode,
                    7.77,
                    "19:00",
                    "15.12.21"
                )
            );
        }
        
        diabetesService.removeNote(
            notes.get(0).getId(),
            userHashcode
        );
    }
}
