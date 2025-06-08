package com.unir.proyecto.controller.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenLibroRequest {
    @NotNull(message = "`libroId` no puede ser nulo")
    private Long libroId;

    @NotNull(message = "`cantidad` no puede ser nulo")
    @Positive(message = "`precio` debe ser mayor que 0")
    @Min(value = 1, message = "`cantidad` debe ser al menos 1")
    private Integer cantidad;

    @NotNull(message = "`precio` no puede ser nulo")
    @Positive(message = "`precio` debe ser mayor que 0")
    private Double precio;

    @NotNull(message = "`subtotal` no puede ser nulo")
    @PositiveOrZero(message = "`subtotal` no puede ser negativo")
    private Double subtotal;
}
