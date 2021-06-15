package com.madrat.diabeteshelperserver.groups.user;

import com.madrat.diabeteshelperserver.groups.user.model.RequestRegisterUser;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserInterface{
    @Autowired
    private UserRepository userRepository;
    
    public void deleteAllRows() {
        userRepository.deleteAll();
    }
    
    public User getUserByHashcode(
        Integer userHashcode
    ) {
        return userRepository.findByUserHashcode(userHashcode);
    }
    
    public Integer registerUser(
        RequestRegisterUser requestRegisterUser
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
    
    public void authorizeUser(
        String emailOrPhoneNumber,
        Boolean isAuthorized
    ) {
        userRepository.updateUserIsAuthorised(
            emailOrPhoneNumber, isAuthorized
        );
    }
}
