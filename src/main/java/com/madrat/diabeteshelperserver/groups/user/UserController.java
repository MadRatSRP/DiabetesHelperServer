package com.madrat.diabeteshelperserver.groups.user;

import com.madrat.diabeteshelperserver.groups.user.model.RequestAuthorizeUser;
import com.madrat.diabeteshelperserver.groups.user.model.RequestRegisterUser;
import com.madrat.diabeteshelperserver.groups.user.model.RequestUnauthorizeUser;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    
    @PostMapping("/registerUser")
    public String registerUser(
            @RequestBody RequestRegisterUser requestRegisterUser
    ) {
        return userService.registerUser(
            requestRegisterUser
        );
    }
    
    @PostMapping("/authorizeUser")
    public String authorizeUser(
        @RequestBody RequestAuthorizeUser requestAuthorizeUser
    ) {
        return userService.authorizeUser(
            requestAuthorizeUser
        );
    }
    
    @PostMapping("/unauthorizeUser")
    public void unauthorizeUser(
        @RequestBody RequestUnauthorizeUser requestUnauthorizeUser
    ) {
        userService.unauthorizeUser(
            requestUnauthorizeUser
        );
    }
}
