package com.indiamart.custom.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ControllerException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public ControllerException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public ControllerException(){
        
    }


}
