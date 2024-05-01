package com.CRUD.Shop.dtos;

import com.CRUD.Shop.models.Products.Categorie;
import com.CRUD.Shop.models.Products.Product;

public record ProductDto(Long id, String name, double price, Categorie categorie) {
    public ProductDto(Product product){
        this(product.getId(), product.getName(),product.getPrice(),product.getCategorie());
    }

    
}
