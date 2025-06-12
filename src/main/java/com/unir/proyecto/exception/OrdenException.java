package com.unir.proyecto.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrdenException extends RuntimeException {
    private final String code;
    private final String detailed;
}