package com.indiamart.repository;

import com.indiamart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CRUDRepository extends JpaRepository<Product,Integer> {
    public Product findByName(String name);
    public List<Product> findByType(String type);
    public List<Product> findByCategory(String category);
    public List<Product> findBySellerID(String sellerId);
/*

    @Query("select p from Product p")
    public List<Product> getAllProduct();
*/

}
