package com.madrat.diabeteshelperserver.groups.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findByEmailOrPhoneNumber(String emailOrPhoneNumber) {
        User user = repository.findByemailOrPhoneNumber(emailOrPhoneNumber);
        return user;
    }

    public User findByPassword(String password) {
        User user = repository.findBypassword(password);
        return user;
    }
}
