package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestAddDiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestDeleteDiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestGetDiabetesNotes;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestUpdateDiabetesNote;
import com.madrat.diabeteshelperserver.groups.user.UserRepository;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DiabetesServiceImpl implements DiabetesService{
    @Autowired
    private DiabetesNotesRepository diabetesRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public void deleteAllRows() {
        diabetesRepository.deleteAll();
    }
    
    public DiabetesNote addNote(
        RequestAddDiabetesNote requestAddDiabetesNote
    ) {
        User currentUser = userRepository.findByUserHashcode(
            requestAddDiabetesNote.getUserHashcode()
        );
        
        DiabetesNote newNote = new DiabetesNote(
            currentUser.getId(),
            requestAddDiabetesNote.getGlucoseLevel(),
            requestAddDiabetesNote.getNoteTime(),
            requestAddDiabetesNote.getNoteDate()
        );
        ResponseEntity.ok(
            diabetesRepository.save(
                newNote
            )
        );
        return newNote;
    }
    
    public List<DiabetesNote> getAllNotes(
            String userHashcode
    ) {
        User currentUser = userRepository.findByUserHashcode(
                userHashcode
        );
        
        return diabetesRepository.selectAllByUserId(
            currentUser.getId()
        );
    }
    
    public DiabetesNote updateNote(
        Integer noteId,
        RequestUpdateDiabetesNote requestUpdateDiabetesNote
    ) {
        User currentUser = userRepository.findByUserHashcode(
            requestUpdateDiabetesNote.getUserHashcode()
        );
        
        diabetesRepository.updateNote(
            noteId,
            currentUser.getId(),
            requestUpdateDiabetesNote.getGlucoseLevel(),
            requestUpdateDiabetesNote.getNoteTime(),
            requestUpdateDiabetesNote.getNoteDate()
        );

        return diabetesRepository.selectByIds(
                noteId,
                currentUser.getId()
        );
    }
    
    public void removeNote(
        Integer noteId,
        String userHashcode
    ) {
        User currentUser = userRepository.findByUserHashcode(
            userHashcode
        );
        
        diabetesRepository.deleteNote(
            noteId,
            currentUser.getId()
        );
    }
}
