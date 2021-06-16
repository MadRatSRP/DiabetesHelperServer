package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiabetesNotesRepository extends JpaRepository<DiabetesNote, Integer> {
    @Override
    void deleteAll();
}
