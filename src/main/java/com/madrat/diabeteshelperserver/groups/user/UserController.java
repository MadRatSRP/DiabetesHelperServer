package com.madrat.diabeteshelperserver.groups.user;

import com.madrat.diabeteshelperserver.groups.user.model.RequestAuthorizeUser;
import com.madrat.diabeteshelperserver.groups.user.model.RequestRegisterUser;
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
    public Integer registerUser(
            @RequestBody RequestRegisterUser requestRegisterUser
    ) {
        return userService.registerUser(
            requestRegisterUser
        );
    }

    /*@PostMapping("/authorizeUser")
    public User authorizeUser(
            @RequestBody RequestAuthorizeUser requestAuthorizeUser
    ) {
        User savedLogin = userRepository.findByEmailOrPhoneNumber(
                requestAuthorizeUser.getEmailOrPhoneNumber()
        );

        if (savedLogin.getPassword().equals(requestAuthorizeUser.getPassword())) {
            savedLogin.setAuthorized(true);

            ResponseEntity.ok(
                    userRepository.save(
                            savedLogin
                    )
            );
            return savedLogin;
        } else {
            return null;
        }
    }*/
}
