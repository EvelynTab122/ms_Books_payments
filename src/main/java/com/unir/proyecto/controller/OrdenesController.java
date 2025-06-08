package com.unir.proyecto.controller;

import com.unir.proyecto.controller.model.OrdenRequest;
import com.unir.proyecto.service.OrdenesService;
import com.unir.proyecto.data.model.Orden;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrdenesController {

    private final OrdenesService service;

    @PostMapping("/ordenes")
    public ResponseEntity<Orden> createOrden(@RequestBody @Valid OrdenRequest peticion){

        log.info("Creating order...");
        Orden ordenCreada = service.createOrden(peticion);

        if(ordenCreada != null) {
            return ResponseEntity.ok(ordenCreada);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
