package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface DiabetesNotesRepository extends JpaRepository<DiabetesNote, Integer> {
    @Query("SELECT u FROM DiabetesNote u WHERE u.userId = :userId")
    Collection<DiabetesNote> findByUserId(Integer userId);
}
