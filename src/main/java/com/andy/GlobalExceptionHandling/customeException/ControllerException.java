package com.andy.GlobalExceptionHandling.customeException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ControllerException {
    private String errorCode;
    private String errorMessage;
}
