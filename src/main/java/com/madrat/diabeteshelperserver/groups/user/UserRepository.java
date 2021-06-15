package com.madrat.diabeteshelperserver.groups.user;

import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    void deleteAll();
    
    @Query("SELECT u FROM User u WHERE u.userHashcode = :userHashcode")
    User findByUserHashcode(Integer userHashcode);
    
    @Query("SELECT u FROM User u WHERE u.emailOrPhoneNumber = :emailOrPhoneNumber")
    User findByEmailOrPhoneNumber(String emailOrPhoneNumber);
    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isAuthorized = true WHERE u.emailOrPhoneNumber = :emailOrPhoneNumber AND u.password = :password")
    void authorizeUser(
        @Param("emailOrPhoneNumber") String emailOrPhoneNumber,
        @Param("password") String password
    );
    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isAuthorized = false WHERE u.userHashcode = :userHashcode")
    void unauthorizeUser(
        @Param("userHashcode") Integer userHashcode
    );
}
