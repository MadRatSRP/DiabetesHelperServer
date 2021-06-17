package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import java.util.List;

@Repository
public interface DiabetesNotesRepository extends JpaRepository<DiabetesNote, Integer> {
    @Override
    void deleteAll();
    
    @Query("SELECT u FROM DiabetesNote u WHERE u.userId = :userId")
    List<DiabetesNote> selectAllByUserId(Integer userId);
    
    @Modifying
    @Transactional
    @Query("UPDATE DiabetesNote u SET u.sugarLevel = :sugarLevel WHERE u.id = :id AND u.userId = :userId")
    void updateNote(
        Integer id,
        Integer userId,
        Double sugarLevel
    );
    
    @Modifying
    @Transactional
    @Query("DELETE FROM DiabetesNote u WHERE u.id = :id AND u.userId = :userId")
    void deleteNote(
        Integer id,
        Integer userId
    );
    
    /*@Modifying
    @Transactional
    @Query("UPDATE User u SET u.isAuthorized = true WHERE u.emailOrPhoneNumber = :emailOrPhoneNumber AND u.password = :password")
    void authorizeUser(
        @Param("emailOrPhoneNumber") String emailOrPhoneNumber,
        @Param("password") String password
    );*/
}
