package com.CRUD.Shop.models.Products;

public enum Categorie {
    UNDEFINED("undefined"),
    ELETRONIC("eletronic"),
    FOOD("food"),
    HEALTHCARE("health care");

    private String category;

    private Categorie(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }
}
