package com.madrat.diabeteshelperserver.groups.foodnotes;

import com.madrat.diabeteshelperserver.groups.foodnotes.model.FoodNote;
import com.madrat.diabeteshelperserver.groups.foodnotes.model.RequestAddFoodNote;
import com.madrat.diabeteshelperserver.groups.foodnotes.model.RequestUpdateFoodNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/foodNotes")
public class FoodNotesController {
    @Autowired
    FoodServiceImpl foodService;
    
    @PostMapping("/addNote")
    public FoodNote addNewNote(
        @RequestBody RequestAddFoodNote requestAddDiabetesNote
    ) {
        return foodService.addNote(requestAddDiabetesNote);
    }
    
    @GetMapping("/notes")
    public List<FoodNote> getAllNotes(
        @RequestParam String userHashcode
    ) {
        return foodService.getAllNotes(userHashcode);
    }
    
    @PutMapping("/notes/{noteId}")
    public FoodNote updateDiabetesNote(
        @PathVariable Integer noteId,
        @RequestBody RequestUpdateFoodNote requestUpdateDiabetesNote
    ) {
        return foodService.updateNote(
            noteId,
            requestUpdateDiabetesNote
        );
    }
    
    @DeleteMapping("/notes/{noteId}")
    public Integer removeNote(
        @PathVariable Integer noteId,
        @RequestParam String userHashcode
    ) {
        foodService.removeNote(
            noteId,
            userHashcode
        );
        return noteId;
    }
}
