package com.madrat.diabeteshelperserver.groups.product;

import com.madrat.diabeteshelperserver.groups.product.model.Product;
import com.madrat.diabeteshelperserver.groups.product.model.RequestAddProduct;
import com.madrat.diabeteshelperserver.groups.product.model.RequestUpdateProduct;
import com.madrat.diabeteshelperserver.groups.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public void deleteAllRows() {
        productRepository.deleteAll();
    }
    
    public Product addProduct(
        RequestAddProduct requestAddProduct
    ) {
        Product product = new Product(
            requestAddProduct.getProductName(),
            requestAddProduct.getProteins(),
            requestAddProduct.getFats(),
            requestAddProduct.getCarbohydrates(),
            requestAddProduct.getCalories()
        );
        ResponseEntity.ok(
            productRepository.save(
                product
            )
        );
        return product;
    }
    
    public List<Product> getAllProducts() {
        return productRepository.selectAll();
    }
    
    /*public Product updateProduct(
        Integer id,
        RequestUpdateProduct requestUpdateProduct
    ) {
        productRepository.updateProduct(
            id,
            requestUpdateProduct.getProductName(),
            requestUpdateProduct.getProteins(),
            requestUpdateProduct.getFats(),
            requestUpdateProduct.getCarbohydrates(),
            requestUpdateProduct.getCalories()
        );
        
        return productRepository.selectById(
            id
        );
    }
    
    public void removeNote(
        Integer id
    ) {
        productRepository.deleteProduct(
            id
        );
    }*/
}
