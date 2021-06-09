package com.madrat.diabeteshelperserver.groups.user;

import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.emailOrPhoneNumber = :emailOrPhoneNumber")
    User findByEmailOrPhoneNumber(String emailOrPhoneNumber);
}
