package com.indiamart.service.seller;

import com.indiamart.entity.Product;

import java.util.List;

public interface SellerService {


    public List<Product> addProduct(List<Product> product);

    public void updateProduct(Product product);

    public void deleteProduct(int id);
}
