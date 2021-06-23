package com.madrat.diabeteshelperserver.groups.product;

import com.madrat.diabeteshelperserver.groups.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Override
    void deleteAll();
    
    @Query("SELECT u FROM Product u")
    List<Product> selectAll();
    
    /*@Query(
        value = "SELECT * FROM USERS u",
        nativeQuery = true
    ) List<Product> findAllProducts();*/
    
    /*@Query("SELECT u FROM Product u WHERE u.id = :id")
    Product selectById(
        Integer id
    );
    
    @Modifying
    @Transactional
    @Query("UPDATE Product u SET u.productName = :productName AND u.proteins = :proteins AND u.fats = :fats AND u.carbohydrates = :carbohydrates AND u.calories = :calories WHERE u.id = :id")
    void updateProduct(
        Integer id,
        String productName,
        Integer proteins,
        Integer fats,
        Integer carbohydrates,
        Integer calories
    );
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Product u WHERE u.id = :id")
    void deleteProduct(
        Integer id
    );*/
}
