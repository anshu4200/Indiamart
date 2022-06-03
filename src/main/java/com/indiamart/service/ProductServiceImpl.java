package com.indiamart.service;

import com.indiamart.custom.exception.BusinessException;
import com.indiamart.entity.Product;
import com.indiamart.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CRUDRepository crudRepository;

    @Override
    public Product getProductByName(String name) {
        try{
            Product product = crudRepository.findByName(name);
            if(product.getName().isEmpty() || product.getName().length()==0){
                throw new BusinessException("705","Product "+name+" not found");
            }
            return product;
        }catch (Exception e){
            throw new BusinessException("703","Something went wrong while fetching the product"+e.getMessage());
        }

    }
    @Override
    public List<Product> getProductByType(String type) {
        try{
            List<Product> productList = crudRepository.findByType(type);
            if(productList.isEmpty()){
                throw new BusinessException("702",type+" of product not found");
            }return productList;
        }catch (Exception e){
            throw new BusinessException("703","Something went wrong while fetching the product"+e.getMessage());
        }

    }

    @Override
    public List<Product> getProductByCategory(String category) {
        try{
            List<Product> productList = crudRepository.findByCategory(category);
            if(productList.isEmpty()){
                throw new BusinessException("702",category+" of product not found");
            }return productList;
        }catch (Exception e){
            throw new BusinessException("703","Something went wrong while fetching the product"+e.getMessage());
        }
    }

    @Override
    public List<Product> getProductByPrice(String price) {
        int[] range = getRange(price);
        List<Product> list = crudRepository.findAll();
        List<Product> addList = new ArrayList<>();
        if(list.isEmpty()){
                throw new BusinessException("702","Bad Request");
            }

        list.stream().forEach(e->{
                int a = Integer.parseInt(e.getPrice());
                if(a>range[0] && a<=range[1]){
                    addList.add(e);
                }
            });
               if(addList.isEmpty()){
                   throw new BusinessException("711","No product found for this range");
               }
               return addList;
    }

    private int[] getRange(String price) {
        String[] str = price.split("-",2);
        return new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
    }

    @Override
    public List<Product> addProduct(List<Product> product) {

        List<Product> list = new ArrayList<>();
        product.stream().forEach(productP->{
            if(productP.getName().isEmpty() || productP.getName().length()==0 ||
                        productP.getType().isEmpty() || productP.getType().length()==0 ||
                        productP.getCategory().isEmpty() || productP.getCategory().length()==0 ||
                        productP.getPrice().isEmpty() || productP.getPrice().length()==0 ||
                        productP.getSellerId().isEmpty() || productP.getSellerId().length()==0){
                    throw new BusinessException("701","Please send the proper product details");
                }

            Product product1 = new Product();
            product1.setName(productP.getName());
            product1.setType(productP.getType());
            product1.setCategory(productP.getCategory());
            product1.setPrice(productP.getPrice());
            product1.setSellerId(productP.getSellerId());
            list.add(product1);
        });
        List<Product> savedProduct = crudRepository.saveAll(list);
        return savedProduct;
    }

    @Override
    public void updateProduct(Product product) {
            List<Product> list = crudRepository.findBySellerID(product.getSellerId());
            if(list.isEmpty()){
                throw new BusinessException("741","Product not found to update");
            }
            list.stream().forEach(e->{
            if(product.getId()==e.getId()) {
              crudRepository.save(product);
            }
        });
    }

    @Override
    public void deleteProduct(int id) {
        crudRepository.deleteById(id);
    }
}
