package com.gustavogonzaga.system_gym.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ErroException extends RuntimeException{
    public ErroException(String msg){
        super(msg);
    }
}
