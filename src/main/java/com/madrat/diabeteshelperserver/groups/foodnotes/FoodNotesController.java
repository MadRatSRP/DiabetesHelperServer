package com.madrat.diabeteshelperserver.groups.foodnotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/foodNotes")
public class FoodNotesController {
    @Autowired
    private FoodNotesRepository foodNotesRepository;

    @PostMapping("/addNote")
    public FoodNote addNewNote(
            @RequestBody FoodNote foodNote
    ) {
        FoodNote newNote = new FoodNote(
                foodNote.getFoodName()
        );
        ResponseEntity.ok(
                foodNotesRepository.save(
                        newNote
                )
        );
        return newNote;
    }

    @GetMapping("/notes")
    public Iterable<FoodNote> getAllNotes() {
        return foodNotesRepository.findAll();
    }

    @PutMapping("/notes/{noteId}")
    public FoodNote updateDiabetesNote(
            @PathVariable Integer noteId,
            @RequestBody FoodNote foodNote
    ) {
        Optional<FoodNote> foodNoteData = foodNotesRepository.findById(noteId);
        FoodNote updatedFoodNote = foodNoteData.get();
        updatedFoodNote.setFoodName(foodNote.getFoodName());
        ResponseEntity.ok(
                foodNotesRepository.save(
                        updatedFoodNote
                )
        );
        return updatedFoodNote;
    }

    @DeleteMapping("/notes/{noteId}")
    public Integer removeNote(
            @PathVariable Integer noteId
    ) {
        foodNotesRepository.deleteById(noteId);
        return noteId;
    }
}
