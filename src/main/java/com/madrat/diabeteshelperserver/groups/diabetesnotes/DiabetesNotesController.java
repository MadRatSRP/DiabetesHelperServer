package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/diabetesNotes")
public class DiabetesNotesController {
    @Autowired
    private DiabetesNotesRepository diabetesNotesRepository;

    @PostMapping(path="/addNote")
    public @ResponseBody String addNewNote(
            @RequestParam Double sugarLevel
    ) {
        DiabetesNote diabetesNote = new DiabetesNote();
        diabetesNote.setSugarLevel(sugarLevel);
        diabetesNotesRepository.save(diabetesNote);
        return "New note was saved";
    }

    @GetMapping("/hello")
    public @ResponseBody String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping(path="/notes")
    public @ResponseBody Iterable<DiabetesNote> getAllNotes() {
        return diabetesNotesRepository.findAll();
    }

    @PutMapping(path="/notes/{id}")
    public ResponseEntity<DiabetesNote> updateDiabetesNote(
            @PathVariable Integer id,
            @RequestBody DiabetesNote diabetesNote
    ) {
        Optional<DiabetesNote> diabetesNoteData = diabetesNotesRepository.findById(id);

        if (diabetesNoteData.isPresent()) {
            DiabetesNote currentDiabetesNote = diabetesNoteData.get();
            currentDiabetesNote.setSugarLevel(
                    diabetesNote.getSugarLevel()
            );
            return new ResponseEntity<>(
                    diabetesNotesRepository.save(currentDiabetesNote),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/notes/{id}")
    public @ResponseBody String removeNote(
            @PathVariable Integer id
    ) {
        diabetesNotesRepository.deleteById(id);
        return "Note was removed";
    }
}
