package com.madrat.diabeteshelperserver;

import com.madrat.diabeteshelperserver.groups.product.ProductServiceImpl;
import com.madrat.diabeteshelperserver.groups.product.model.Product;
import com.madrat.diabeteshelperserver.groups.product.model.RequestAddProduct;
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
        //removeAllProducts();
        //addProducts();
        //removeProduct(397);
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
    
    void addProducts() {
        RequestAddProduct productOne = new RequestAddProduct(
            "сальце",
            1,
            2,
            3,
            4
        );
        RequestAddProduct productTwo = new RequestAddProduct(
            "борщик",
            5,
            5,
            5,
            5
        );
        RequestAddProduct productThree = new RequestAddProduct(
            "томатная паста",
            15,
            15,
            15,
            15
        );
        
        Product firstResult = productService.addProduct(
            productOne
        );
        Product secondResult = productService.addProduct(
            productTwo
        );
        Product thirdResult = productService.addProduct(
            productThree
        );
        System.out.println(firstResult);
        System.out.println(secondResult);
        System.out.println(thirdResult);
    }
    
    /*void removeProduct(Integer productId) {
        productService.removeNote(productId);
    }*/
}

