package com.madrat.diabeteshelperserver.groups.diabetesnotes;

import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestAddDiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestDeleteDiabetesNote;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestGetDiabetesNotes;
import com.madrat.diabeteshelperserver.groups.diabetesnotes.model.RequestUpdateDiabetesNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.madrat.diabeteshelperserver.groups.user.model.User;

import java.util.List;

@RestController
@RequestMapping(path="/diabetesNotes")
public class DiabetesNotesController {
    @Autowired
    DiabetesServiceImpl diabetesService;
    
    @PostMapping("/addNote/")
    public DiabetesNote addNewNote(
        @RequestBody RequestAddDiabetesNote requestAddDiabetesNote
    ) {
        return diabetesService.addNote(requestAddDiabetesNote);
    }
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    
    @GetMapping("/notes")
    public List<DiabetesNote> getAllNotes(
        @RequestParam String userHashcode
    ) {
        return diabetesService.getAllNotes(userHashcode);
    }
    
    @PutMapping("/notes/{noteId}")
    public DiabetesNote updateDiabetesNote(
        @PathVariable Integer noteId,
        @RequestBody RequestUpdateDiabetesNote requestUpdateDiabetesNote
    ) {
        return diabetesService.updateNote(
            noteId,
            requestUpdateDiabetesNote
        );
    }
    
    @DeleteMapping("/notes/{noteId}")
    public Integer removeNote(
        @PathVariable Integer noteId,
        @RequestParam String userHashcode
    ) {
        diabetesService.removeNote(
            noteId,
            userHashcode
        );
        return noteId;
    }
}
