package com.unir.proyecto.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orden")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ordenId")
    private Long orderId;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado")
    private String estado;

    @Column(name = "total")
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ordenId")
    @JsonManagedReference
    private List<OrdenItem> libros;
}
