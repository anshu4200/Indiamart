package com.indiamart.service.customer;

import com.indiamart.custom.exception.BusinessException;
import com.indiamart.entity.Product;
import com.indiamart.repository.CRUDRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    CustomerServiceImpl customerService;

    @MockBean
    private CRUDRepository crudRepository;

    @Test
    void getProductByName() {
        Product product = new Product();
        product.withName("hp-12")
                .withType("laptop")
                .withCategory("Electronic")
                .withPrice("10000")
                .withSellerId("1001");
        Mockito.when(crudRepository.findByName("hp-12")).thenReturn(product);
        assertEquals(customerService.getProductByName("hp-12").getName(),"hp-12");
    }

    @Test
    void getProductByNameWithException(){
        Product product = new Product();
        product.withType("laptop")
                .withCategory("Electronic")
                .withPrice("10000")
                .withSellerId("1001");
        try{
            Mockito.when(crudRepository.findByName("hp-12")).thenReturn(product);
        }catch (BusinessException e){
            fail(e.getErrorMessage());
            assertEquals("705",e.getErrorCode());
            assertEquals("Product hp-12 not found",e.getErrorCode());
        }
    }
    @Test
    void getProductByType() {
        Product product = new Product();
        product.withName("hp-12")
                .withType("laptop")
                .withCategory("Electronic")
                .withPrice("10000")
                .withSellerId("1001");
        Product product1 = new Product();
        product1.withName("hp-14")
                .withType("laptop")
                .withCategory("Electronic")
                .withPrice("10000")
                .withSellerId("1001");
        Mockito.when(crudRepository.findByType("laptop")).thenReturn(List.of(product,product1));
        assertEquals(customerService.getProductByType("laptop").get(0).getName(),"hp-12");
    }

    @Test
    void getProductByCategory() {
        Product product = new Product();
        product.withName("hp-12")
                .withType("laptop")
                .withCategory("Electronic")
                .withPrice("10000")
                .withSellerId("1001");
        Product product1 = new Product();
        product1.withName("hp-14")
                .withType("laptop")
                .withCategory("Electronic")
                .withPrice("10000")
                .withSellerId("1001");
        Mockito.when(crudRepository.findByCategory("Electronic")).thenReturn(List.of(product,product1));
        assertEquals(customerService.getProductByCategory("Electronic").get(0).getCategory(),"Electronic");

    }

    @Test
    void getProductByPrice() {
        Product product = new Product();
        product.withName("hp-12")
                .withType("laptop")
                .withCategory("Electronic")
                .withPrice("12000")
                .withSellerId("1001");
        Product product1 = new Product();
        product1.withName("hp-14")
                .withType("laptop")
                .withCategory("Electronic")
                .withPrice("10000")
                .withSellerId("1001");
        Mockito.when(crudRepository.findAll()).thenReturn(List.of(product,product1));
        assertEquals(customerService.getProductByPrice("5000-11500").get(0).getName(),"hp-14");
    }
}