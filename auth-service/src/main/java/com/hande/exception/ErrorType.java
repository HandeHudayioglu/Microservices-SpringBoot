package com.hande.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {


    LOGIN_ERROR_WRONG(1000,"Username or password is wrong",INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_REQUIRED_PASSWORD(1001,"Enter a valid password",INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_USERNAME_ERROR (1002,"Enter a valid username",INTERNAL_SERVER_ERROR),
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    LOGIN_ERROR_USERNAME_DUPLICATE (1003,"This username already exist",INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(2002,"Invalid Token", BAD_REQUEST);

    private int code;
    private String message;
    HttpStatus httpStatus;

}
