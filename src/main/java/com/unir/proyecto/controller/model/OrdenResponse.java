package com.unir.proyecto.controller.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class OrdenResponse {
    private Long orderId;
    private LocalDate fecha;
    private String estado;
    private double total;
}
