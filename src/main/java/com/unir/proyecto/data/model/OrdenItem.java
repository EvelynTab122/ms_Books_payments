package com.unir.proyecto.data.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orderItems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrdenItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long libroId;
    private Integer cantidad;
    private Double precio;
    private Double subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordenId", nullable = false)
    private Orden ordenId;
}
