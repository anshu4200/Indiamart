package com.indiamart.controller;

import com.indiamart.custom.exception.BusinessException;
import com.indiamart.custom.exception.ControllerException;
import com.indiamart.entity.Product;
import com.indiamart.service.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping(value = "/seller/saved")
    public ResponseEntity<?> addProduct(@RequestBody List<Product> product){
        try{
            List<Product> addedProduct = sellerService.addProduct(product);
            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went wrong in controller");
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/seller/update")
    public ResponseEntity<?> updateEmployes(@RequestBody Product product){
        try{
            sellerService.updateProduct(product);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went wrong in controller");
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/seller/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") int id){
        try{
            sellerService.deleteProduct(id);
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        }catch (BusinessException e){
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(controllerException,HttpStatus.NOT_FOUND);
        }catch (Exception e){
            ControllerException controllerException = new ControllerException("711","Something went wrong in controller");
            return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST);
        }
    }
}
