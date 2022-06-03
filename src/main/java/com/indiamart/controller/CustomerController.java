package com.indiamart.controller;

import com.indiamart.custom.exception.BusinessException;
import com.indiamart.custom.exception.ControllerException;
import com.indiamart.entity.Product;
import com.indiamart.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
/*
Exception handling can also be done with the help @ControllerAdvice
 */

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "customer/name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable("name") String name){
        try{
            Product getProduct = customerService.getProductByName(name);
            return new ResponseEntity<>(getProduct,HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went wrong in controller");
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "customer/type/{type}")
    public ResponseEntity<?> getProductByType(@PathVariable("type") String type){
        try{
            List<Product> getProduct = customerService.getProductByType(type);
            return new ResponseEntity<>(getProduct,HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went wrong in controller");
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "customer/category/{category}")
    public ResponseEntity<?> getProductByCategory(@PathVariable("category") String category){
        try{
            List<Product> getProduct = customerService.getProductByCategory(category);
            return new ResponseEntity<>(getProduct,HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went wrong in controller");
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "customer/priceRange/{price}")
    public ResponseEntity<? > getProductByPrice(@PathVariable("price") String price){
        try{
            List<Product> getProduct = customerService.getProductByPrice(price);
            return new ResponseEntity<>(getProduct,HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went wrong in controller");
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }

    }


}
