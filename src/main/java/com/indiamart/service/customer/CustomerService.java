package com.indiamart.service.customer;

import com.indiamart.entity.Product;


import java.util.List;

public interface CustomerService {


    public Product getProductByName(String name);

    public List<Product> getProductByType(String name);

    public List<Product> getProductByCategory(String name);

    public List<Product> getProductByPrice(String price);

}
