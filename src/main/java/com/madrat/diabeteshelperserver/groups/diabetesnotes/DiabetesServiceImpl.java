package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiabetesServiceImpl implements DiabetesService{
    @Autowired
    private DiabetesNotesRepository repository;
    
    public void deleteAllRows() {
        repository.deleteAll();
    }
    
    public DiabetesNote addNote(
        Integer userId,
        Double sugarLevel
    ) {
        DiabetesNote newNote = new DiabetesNote(
            userId,
            sugarLevel
        );
        ResponseEntity.ok(
            repository.save(
                newNote
            )
        );
        return newNote;
    }
}
