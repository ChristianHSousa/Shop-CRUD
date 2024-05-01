package com.CRUD.Shop.models.Products;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Products")
@Entity(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotNull
    @Column(nullable = false)    
    private String name;

    @NotNull
    private double price;

    private Categorie categorie;

    public Product(String name, double price, Categorie categorie){
        this.name = name;
        this.price = price;
        this.categorie = categorie;
    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
        this.categorie = Categorie.UNDEFINED;
    }
}
