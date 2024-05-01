package com.CRUD.Shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.Shop.dtos.ProductDto;
import com.CRUD.Shop.models.Products.Product;
import com.CRUD.Shop.repositories.ProductRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllProducts(){
        List<ProductDto> lista = this.productRepository.findAll().stream().map(ProductDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") @Valid Long id){
        Optional<Product> lista = this.productRepository.findById(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity<?> getProduct(@PathVariable("name") @Valid String name){
        List<Product> lista = this.productRepository.findByName(name);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/add")
    public ResponseEntity<?> newProduct(@RequestBody ProductDto data){
        if(data.categorie() == null){
            this.productRepository.save(new Product(data.name(), data.price()));
        }else{
            this.productRepository.save(new Product(data.name(), data.price(), data.categorie()));
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product newProduct , @Valid @PathVariable("id") long id){
        
        Optional<Product> Product = this.productRepository.findById(id);
        if (Product.isPresent()){

            Product.map(product ->
            {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                product.setCategorie((newProduct.getCategorie()));
                return productRepository.save(product);
            }
            );
        } else{
            return ResponseEntity.badRequest().build();
        }
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") @Valid long id){
        this.productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
