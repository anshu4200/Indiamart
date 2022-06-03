package com.indiamart.service;

import com.indiamart.entity.Product;


import java.util.List;

public interface ProductService {


    public Product getProductByName(String name);

    public List<Product> getProductByType(String name);

    public List<Product> getProductByCategory(String name);

    public List<Product> getProductByPrice(String price);

    public List<Product> addProduct(List<Product> product);

    public void updateProduct(Product product);

    public void deleteProduct(int id);
}
