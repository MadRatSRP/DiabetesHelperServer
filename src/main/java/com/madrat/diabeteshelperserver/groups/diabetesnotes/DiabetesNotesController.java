package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestAddDiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestGetDiabetesNotes;
import com.madrat.diabeteshelperserver.groups.user.UserRepository;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path="/diabetesNotes")
public class DiabetesNotesController {
    @Autowired
    private DiabetesNotesRepository diabetesNotesRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addNote")
    public DiabetesNote addNewNote(
            @RequestBody RequestAddDiabetesNote requestAddDiabetesNote
    ) {
        User currentUser = userRepository.findByUserHashcode(
                requestAddDiabetesNote.getUserHashcode()
        );

        DiabetesNote newNote = new DiabetesNote(
                requestAddDiabetesNote.getDiabetesNote().getSugarLevel(),
                currentUser.getId()
        );
        ResponseEntity.ok(
                diabetesNotesRepository.save(
                        newNote
                )
        );
        return newNote;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/")
    public ResponseEntity<Collection<DiabetesNote>> getNotes(
            @RequestBody String userHashcode
    ) {
        User currentUser = userRepository.findByUserHashcode(
                //requestGetDiabetesNotes.getUserHashcode()
                userHashcode
        );

        System.out.print(currentUser);

        Collection<DiabetesNote> collection = diabetesNotesRepository.findByUserId(currentUser.getId());

        System.out.print(collection);

        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    @PutMapping("/notes/{noteId}")
    public DiabetesNote updateDiabetesNote(
            @PathVariable Integer noteId,
            @RequestBody DiabetesNote diabetesNote
    ) {
        Optional<DiabetesNote> tutorialData = diabetesNotesRepository.findById(noteId);
        DiabetesNote updatedDiabetesNote = tutorialData.get();
        updatedDiabetesNote.setSugarLevel(diabetesNote.getSugarLevel());
        ResponseEntity.ok(
                diabetesNotesRepository.save(
                        updatedDiabetesNote
                )
        );
        return updatedDiabetesNote;
    }

    @DeleteMapping("/notes/{noteId}")
    public Integer removeNote(
            @PathVariable Integer noteId
    ) {
        diabetesNotesRepository.deleteById(noteId);
        return noteId;
    }
}
