package com.jmo.jwttemplate.global.error;

public interface CustomError {
    String getMessage();

    int getStatus();

    String getCode();
}
