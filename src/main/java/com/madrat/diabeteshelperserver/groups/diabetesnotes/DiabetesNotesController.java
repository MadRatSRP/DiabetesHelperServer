package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/diabetesNotes")
public class DiabetesNotesController {
    @Autowired
    private DiabetesNotesRepository diabetesNotesRepository;

    @PostMapping("/addNote")
    public DiabetesNote addNewNote(
            @RequestBody DiabetesNote diabetesNote
    ) {
        DiabetesNote newNote = new DiabetesNote(
                diabetesNote.getSugarLevel()
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

    @GetMapping("/notes")
    public Iterable<DiabetesNote> getAllNotes() {
        return diabetesNotesRepository.findAll();
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
