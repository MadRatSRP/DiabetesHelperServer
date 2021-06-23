package com.madrat.diabeteshelperserver.groups.foodnotes;

import com.madrat.diabeteshelperserver.groups.foodnotes.model.FoodNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FoodNotesRepository extends JpaRepository<FoodNote, Integer> {
    @Override
    void deleteAll();
    
    @Query("SELECT u FROM FoodNote u WHERE u.userId = :userId")
    List<FoodNote> selectAllByUserId(Integer userId);
    
    @Query("SELECT u FROM FoodNote u WHERE u.id = :id AND u.userId = :userId")
    FoodNote selectByIds(
        Integer id,
        Integer userId
    );
    
    @Modifying
    @Transactional
    @Query("UPDATE FoodNote u SET u.foodName = :foodName WHERE u.id = :id AND u.userId = :userId")
    void updateNote(
        Integer id,
        Integer userId,
        String foodName
    );
    
    @Modifying
    @Transactional
    @Query("DELETE FROM FoodNote u WHERE u.id = :id AND u.userId = :userId")
    void deleteNote(
        Integer id,
        Integer userId
    );
}
