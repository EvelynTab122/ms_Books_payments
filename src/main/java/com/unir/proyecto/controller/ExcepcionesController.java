package com.unir.proyecto.controller;

import com.unir.proyecto.exception.OrdenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExcepcionesController {

    @ExceptionHandler(OrdenException.class)
    public ResponseEntity<Map<String, String>> handleOrdenException(OrdenException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("code", ex.getCode());
        error.put("detailed", ex.getDetailed());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}