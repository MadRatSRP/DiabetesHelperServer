package com.madrat.diabeteshelperserver;

import com.madrat.diabeteshelperserver.groups.diabetesnotes.DiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.DiabetesServiceImpl;
import com.madrat.diabeteshelperserver.groups.user.UserServiceImpl;
import com.madrat.diabeteshelperserver.groups.user.model.RequestRegisterUser;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        User currentUser = userService.getUserByHashcode(userHashcode);
        
        for (Double value : values) {
            diabetesService.addNote(
                currentUser.getId(),
                value
            );
        }
    }
}
