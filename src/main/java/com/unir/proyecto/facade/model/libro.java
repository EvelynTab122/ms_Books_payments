package com.unir.proyecto.facade.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class libro {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private String categoria;
    private int isbn;
    private boolean visibilidad;
    private int valoracion;
    private int cantidad;
    private double precio;
}
