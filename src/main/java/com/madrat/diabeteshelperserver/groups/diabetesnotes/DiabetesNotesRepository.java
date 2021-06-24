package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DiabetesNotesRepository extends JpaRepository<DiabetesNote, Integer> {
    @Override
    void deleteAll();
    
    @Query("SELECT u FROM DiabetesNote u WHERE u.userId = :userId")
    List<DiabetesNote> selectAllByUserId(Integer userId);

    @Query("SELECT u FROM DiabetesNote u WHERE u.id = :id AND u.userId = :userId")
    DiabetesNote selectByIds(
            Integer id,
            Integer userId
    );
    
    @Modifying
    @Transactional
    @Query("UPDATE DiabetesNote u SET u.glucoseLevel = :glucoseLevel, u.noteTime = :noteTime, u.noteDate = :noteDate WHERE u.id = :id AND u.userId = :userId")
    void updateNote(
        Integer id,
        Integer userId,
        Double glucoseLevel,
        String noteTime,
        String noteDate
    );
    
    @Modifying
    @Transactional
    @Query("DELETE FROM DiabetesNote u WHERE u.id = :id AND u.userId = :userId")
    void deleteNote(
        Integer id,
        Integer userId
    );
}
