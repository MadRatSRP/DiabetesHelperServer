package com.madrat.diabeteshelperserver.groups.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByemailOrPhoneNumber(String emailOrPhoneNumber);

    User findBypassword(String password);
}
