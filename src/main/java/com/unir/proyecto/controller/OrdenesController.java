package com.unir.proyecto.controller;

import com.unir.proyecto.controller.model.OrdenRequest;
import com.unir.proyecto.controller.model.OrdenResponse;
import com.unir.proyecto.service.OrdenesService;
import com.unir.proyecto.data.model.Orden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class OrdenesController {

    private final OrdenesService service;

    @PostMapping("/ordenes")
    public ResponseEntity<OrdenResponse> createOrden(@RequestBody @Valid OrdenRequest peticion){

        log.info("Creating order...");
        Orden ordenCreada = service.createOrden(peticion);
        log.info("Orden creada: ");
        if(ordenCreada != null) {
            OrdenResponse response = new OrdenResponse();
            response.setOrderId(ordenCreada.getOrderId());
            response.setFecha(ordenCreada.getFecha());
            response.setEstado(ordenCreada.getEstado());
            response.setTotal(ordenCreada.getTotal());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/ordenes")
    public ResponseEntity<List<Orden>> getOrdenes() {

        List<Orden> ordenes = service.getOrdenes();
        if (ordenes != null) {
            return ResponseEntity.ok(ordenes);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/ordenes/{id}")
    public ResponseEntity<Orden> getOrden(@PathVariable String id) {

        Orden orden = service.getOrden(id);
        if (orden != null) {
            return ResponseEntity.ok(orden);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

