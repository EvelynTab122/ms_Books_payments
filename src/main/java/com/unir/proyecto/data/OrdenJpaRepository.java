package com.unir.proyecto.data;

import com.unir.proyecto.data.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenJpaRepository extends JpaRepository<Orden, Long> {
}
