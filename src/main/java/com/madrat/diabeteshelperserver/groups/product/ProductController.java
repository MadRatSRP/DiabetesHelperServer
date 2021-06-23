package com.madrat.diabeteshelperserver.groups.product;

import com.madrat.diabeteshelperserver.groups.product.model.Product;
import com.madrat.diabeteshelperserver.groups.product.model.RequestAddProduct;
import com.madrat.diabeteshelperserver.groups.product.model.RequestUpdateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    
    @PostMapping("/addProduct/")
    public Product addProduct(
        @RequestBody RequestAddProduct requestAddProduct
    ) {
        return productService.addProduct(requestAddProduct);
    }
    
    @GetMapping("/products/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    /*@PutMapping("/products/{productId}/")
    public Product updateProduct(
        @PathVariable Integer productId,
        @RequestBody RequestUpdateProduct requestUpdateProduct
    ) {
        return productService.updateProduct(
            productId,
            requestUpdateProduct
        );
    }
    
    @DeleteMapping("/products/{productId}/")
    public Integer removeProduct(
        @PathVariable Integer productId
    ) {
        productService.removeNote(
            productId
        );
        return productId;
    }*/
}
