package com.Authenticatioon_Service.Authentication_Service.Exception;


import org.springframework.stereotype.Component;


public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
