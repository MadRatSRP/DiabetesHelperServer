package com.madrat.diabeteshelperserver.groups.user;

import com.madrat.diabeteshelperserver.groups.user.model.RequestRegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public Integer registerNewUser(
            @RequestBody RequestRegisterUser requestRegisterUser
    ) {
        User user = new User(
                requestRegisterUser.getEmailOrPhoneNumber(),
                requestRegisterUser.getPassword()
        );
        Integer userHashcode = (
                requestRegisterUser.getEmailOrPhoneNumber() +
                        "0/1=2*3^7-9" +
                requestRegisterUser.getPassword()
        ).hashCode();
        user.setUserHashcode(userHashcode);
        ResponseEntity.ok(
                userRepository.save(
                        user
                )
        );
        return userHashcode;
    }

    /*
    @PostMapping("/authorize")
    public User authorizeUser(
            @RequestBody String emailOrPhoneNumber,
            @RequestBody String password
    ) {
        User userByLogin = userService.findByEmailOrPhoneNumber(emailOrPhoneNumber);
        User userByPassword = userService.findByPassword(password);

        if (userByLogin.getEmailOrPhoneNumber().equals(userByPassword.getEmailOrPhoneNumber())
                && userByLogin.getPassword().equals(userByPassword.getPassword())) {
            userByLogin.setAuthorized(true);

            ResponseEntity.ok(
                    userRepository.save(
                            userByLogin
                    )
            );
            return userByLogin;
        } else {
            return null;
        }
    }
     */
}
