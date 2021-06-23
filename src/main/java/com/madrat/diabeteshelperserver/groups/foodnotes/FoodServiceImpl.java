package com.madrat.diabeteshelperserver.groups.foodnotes;

import com.madrat.diabeteshelperserver.groups.foodnotes.model.FoodNote;
import com.madrat.diabeteshelperserver.groups.foodnotes.model.RequestAddFoodNote;
import com.madrat.diabeteshelperserver.groups.foodnotes.model.RequestUpdateFoodNote;
import com.madrat.diabeteshelperserver.groups.user.UserRepository;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodNotesRepository foodRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public void deleteAllRows() {
        foodRepository.deleteAll();
    }
    
    public FoodNote addNote(
        RequestAddFoodNote requestAddFoodNote
    ) {
        User currentUser = userRepository.findByUserHashcode(
            requestAddFoodNote.getUserHashcode()
        );
        
        FoodNote newNote = new FoodNote(
            currentUser.getId(),
            requestAddFoodNote.getFoodName()
        );
        ResponseEntity.ok(
            foodRepository.save(
                newNote
            )
        );
        return newNote;
    }
    
    public List<FoodNote> getAllNotes(
        String userHashcode
    ) {
        User currentUser = userRepository.findByUserHashcode(
            userHashcode
        );
        
        return foodRepository.selectAllByUserId(
            currentUser.getId()
        );
    }
    
    public FoodNote updateNote(
        Integer noteId,
        RequestUpdateFoodNote requestUpdateDiabetesNote
    ) {
        User currentUser = userRepository.findByUserHashcode(
            requestUpdateDiabetesNote.getUserHashcode()
        );
        
        foodRepository.updateNote(
            noteId,
            currentUser.getId(),
            requestUpdateDiabetesNote.getFoodName()
        );
        
        return foodRepository.selectByIds(
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
        
        foodRepository.deleteNote(
            noteId,
            currentUser.getId()
        );
    }
}
