package com.indiamart.service.seller;

import com.indiamart.custom.exception.BusinessException;
import com.indiamart.entity.Product;
import com.indiamart.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private CRUDRepository crudRepository;

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

/*
            product1.setName(productP.getName());
            product1.setType(productP.getType());
            product1.setCategory(productP.getCategory());
            product1.setPrice(productP.getPrice());
            product1.setSellerId(productP.getSellerId());*/

            Product product1 = new Product();
            product1.withName(productP.getName())
                    .withType(productP.getType())
                    .withCategory(productP.getCategory())
                    .withPrice(productP.getPrice())
                    .withSellerId(productP.getSellerId());
            list.add(product1);

        });
        return crudRepository.saveAll(list);

    }

    @Override
    public void updateProduct(Product product) {
        Optional<Product> product1 = crudRepository.findById(product.getId());
        if(product1.isEmpty()){
            throw new BusinessException("741","Product not found to update");
        }
       if(product.getSellerId().equals(product1.get().getSellerId())){
          throw new BusinessException("711","This is not your product,So you will not be able to update the product");
       }
        crudRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        crudRepository.deleteById(id);
    }
}
