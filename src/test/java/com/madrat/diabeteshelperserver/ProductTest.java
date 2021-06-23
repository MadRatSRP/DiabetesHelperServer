package com.madrat.diabeteshelperserver;

import com.madrat.diabeteshelperserver.groups.product.ProductServiceImpl;
import com.madrat.diabeteshelperserver.groups.product.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductServiceImpl productService;
    
    @Test
    void mainTest() {
        /*getProducts();
        removeAllProducts();*/
    }
    
    void removeAllProducts() {
        productService.deleteAllRows();
    }
    
    void getProducts() {
        List<Product> products = productService.getAllProducts();
    
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
    
    
    
    /*void testDiabetesMethods(
        String userHashcode,
        Double[] values
    ) {
        for (Double value : values) {
            diabetesService.addNote(
                new RequestAddDiabetesNote(
                    value,
                    userHashcode
                )
            );
        }
    
        
        List<DiabetesNote> notes = diabetesService.getAllNotes(
            new RequestGetDiabetesNotes(
                userHashcode
            )
        );
        for (DiabetesNote note: notes) {
            System.out.println("NewNote");
            System.out.println("New Note:" + note.toString());
        }
    
        for (DiabetesNote note: notes) {
            diabetesService.updateNote(
                note.getId(),
                new RequestUpdateDiabetesNote(
                    userHashcode,
                    7.77
                )
            );
        }
        
        diabetesService.removeNote(
            notes.get(0).getId(),
            new RequestDeleteDiabetesNote(
                userHashcode
            )
        );
    }*/
}

