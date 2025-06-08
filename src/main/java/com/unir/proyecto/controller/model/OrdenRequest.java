package com.unir.proyecto.controller.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenRequest {
    @NotNull(message= "`libros` cannot be null")
    @NotEmpty(message = "`libros` cannot be empty")
    private List<OrdenLibroRequest> libros;
}
