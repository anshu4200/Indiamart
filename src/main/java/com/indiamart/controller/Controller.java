package com.indiamart.controller;

import com.indiamart.custom.exception.BusinessException;
import com.indiamart.custom.exception.ControllerException;
import com.indiamart.entity.Product;
import com.indiamart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {


    @Autowired
    private ProductService productService;

    @GetMapping(value = "customer/name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable("name") String name){
        try{
            Product getProduct = productService.getProductByName(name);
            return new ResponseEntity<>(getProduct,HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went worng in controller");
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "customer/type/{type}")
    public ResponseEntity<?> getProductByType(@PathVariable("type") String type){
        try{
            List<Product> getProduct = productService.getProductByType(type);
            return new ResponseEntity<>(getProduct,HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went worng in controller");
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "customer/category/{category}")
    public ResponseEntity<?> getProductByCategory(@PathVariable("category") String category){
        try{
            List<Product> getProduct = productService.getProductByCategory(category);
            return new ResponseEntity<>(getProduct,HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went worng in controller");
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "customer/priceRange/{price}")
    public ResponseEntity<? > getProductByPrice(@PathVariable("price") String price){
        try{
            List<Product> getProduct = productService.getProductByPrice(price);
            return new ResponseEntity<List<Product>>(getProduct,HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went worng in controller");
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/seller/saved")
    public ResponseEntity<?> addProduct(@RequestBody List<Product> product){
        try{
            List<Product> addedProduct = productService.addProduct(product);
            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went worng in controller");
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/seller/update")
    public ResponseEntity<?> updateEmployes(@RequestBody Product product){
        try{
              productService.updateProduct(product);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went worng in controller");
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/seller/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") int id){
        try{
            productService.deleteProduct(id);
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went worng in controller");
            return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }
}
