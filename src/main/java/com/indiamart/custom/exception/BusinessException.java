package com.indiamart.custom.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BusinessException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public BusinessException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(){

    }


}
