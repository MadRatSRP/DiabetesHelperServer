package com.madrat.diabeteshelperserver;

import com.madrat.diabeteshelperserver.groups.user.UserServiceImpl;
import com.madrat.diabeteshelperserver.groups.user.model.RequestRegisterUser;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersTest {
    
    @Autowired
    UserServiceImpl userService;
    
    @Test
    void testExample() {
        userService.deleteAllRows();
        
        Integer userHashcode = addUser();
        
        User currentUser = getUserByHashcode(userHashcode);
        
        authorizeUser(true);
        
        User userAuthorized = getUserByHashcode(userHashcode);
        
        authorizeUser(false);
        
        User userUnauthorized = getUserByHashcode(userHashcode);
        
        System.out.println(currentUser.toString());
        System.out.println(userAuthorized.toString());
        System.out.println(userUnauthorized.toString());
    }
    
    User getUserByHashcode(
        Integer userHashcode
    ) {
        return userService.getUserByHashcode(userHashcode);
    }
    
    Integer addUser() {
        RequestRegisterUser user = new RequestRegisterUser(
            "jojo",
            "1234"
        );
        return userService.registerUser(user);
    }
    
    void authorizeUser(boolean isAuthorized) {
        userService.authorizeUser(
            "jojo",
            isAuthorized
        );
    }
}
