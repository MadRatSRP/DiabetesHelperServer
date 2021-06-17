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
    void mainTest() {
        userService.deleteAllRows();
        
        /*testUserMethods(
            "jojo",
            "1234"
        );
        testUserMethods(
            "jopka",
            "12345"
        );
        testUserMethods(
            "lolka",
            "1234567"
        );*/
        
        String login = "+79506964164";
        String password = "12345678";
        
        registerUser(
            login,
            password
        );
        
        String userHash = authorizeUser(
            login,
            password
        );
        
        System.out.println(userHash);
    }
    
    void testUserMethods(
        String login,
        String password
    ) {
        String userHashcode = registerUser(
            login,
            password
        );
    
        User registeredUser = getUserByHashcode(userHashcode);
    
        authorizeUser(
            login,
            password
        );
    
        User userAuthorized = getUserByHashcode(userHashcode);
        
        unauthorizeUser(userHashcode);
        
        /*authorizeUser(false);
        
        User userUnauthorized = getUserByHashcode(userHashcode);*/
    
        /*System.out.println(registeredUser.toString());
        System.out.println(userAuthorized.toString());*/
    }
    
    User getUserByHashcode(
        String userHashcode
    ) {
        return userService.getUserByHashcode(userHashcode);
    }
    
    String registerUser(
        String emailOrPhoneNumber,
        String password
    ) {
        RequestRegisterUser user = new RequestRegisterUser(
            emailOrPhoneNumber,
            password
        );
        return userService.registerUser(user);
    }
    
    String authorizeUser(
        String emailOrPhoneNumber,
        String password
    ) {
        return userService.authorizeUser(
            emailOrPhoneNumber,
            password
        );
    }
    
    void unauthorizeUser(
        String userHashcode
    ) {
        userService.unauthorizeUser(
            userHashcode
        );
    }
}
