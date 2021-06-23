package com.madrat.diabeteshelperserver.groups.product.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "proteins")
    private Integer proteins;

    @Column(name = "fats")
    private Integer fats;

    @Column(name = "carbohydrates")
    private Integer carbohydrates;

    @Column(name = "calories")
    private Integer calories;

    public Product(
        String productName,
        Integer proteins,
        Integer fats,
        Integer carbohydrates,
        Integer calories
    ) {
        this.productName = productName;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }
}
