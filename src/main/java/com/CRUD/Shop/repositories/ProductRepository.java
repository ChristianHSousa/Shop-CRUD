package com.CRUD.Shop.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.Shop.models.Products.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    List<Product> findByName(String name);
}
