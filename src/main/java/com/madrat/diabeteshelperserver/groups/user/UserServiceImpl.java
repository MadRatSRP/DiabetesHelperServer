package com.madrat.diabeteshelperserver.groups.user;

import com.madrat.diabeteshelperserver.groups.user.model.RequestAuthorizeUser;
import com.madrat.diabeteshelperserver.groups.user.model.RequestRegisterUser;
import com.madrat.diabeteshelperserver.groups.user.model.RequestUnauthorizeUser;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    public void deleteAllRows() {
        userRepository.deleteAll();
    }
    
    public User getUserByHashcode(
        String userHashcode
    ) {
        return userRepository.findByUserHashcode(userHashcode);
    }
    
    public String registerUser(
        RequestRegisterUser requestRegisterUser
    ) {
        User user = new User(
            requestRegisterUser.getEmailOrPhoneNumber(),
            requestRegisterUser.getPassword()
        );
        String userHashcode = String.valueOf((
            requestRegisterUser.getEmailOrPhoneNumber() +
                "0/1=2*3^7-9" +
                requestRegisterUser.getPassword()
        ).hashCode());
        user.setUserHashcode(userHashcode);
        ResponseEntity.ok(
            userRepository.save(
                user
            )
        );
        return userHashcode;
    }
    
    public String authorizeUser(
        RequestAuthorizeUser requestAuthorizeUser
    ) {
        userRepository.authorizeUser(
            requestAuthorizeUser.getEmailOrPhoneNumber(),
            requestAuthorizeUser.getPassword()
        );
        
        return userRepository.findByEmailOrPhoneNumberAndSelectUserHashcode(
            requestAuthorizeUser.getEmailOrPhoneNumber()
        );
    }
    
    public void unauthorizeUser(
        RequestUnauthorizeUser requestUnauthorizeUser
    ) {
        userRepository.unauthorizeUser(
            requestUnauthorizeUser.getUserHashcode()
        );
    }
}
