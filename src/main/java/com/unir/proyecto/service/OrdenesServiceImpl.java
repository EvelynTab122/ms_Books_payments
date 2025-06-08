package com.unir.proyecto.service;
import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unir.proyecto.facade.model.libro;
import com.unir.proyecto.facade.LibrosFacade;

import com.unir.proyecto.data.OrdenJpaRepository;
import com.unir.proyecto.data.model.Orden;
import com.unir.proyecto.data.model.OrdenItem;
import com.unir.proyecto.controller.model.OrdenRequest;

import java.util.List;
import java.util.Objects;



@Service
public class OrdenesServiceImpl implements OrdenesService {

    @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
    private LibrosFacade librosFacade;

    @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
    private OrdenJpaRepository repository;


    @Override
    public Orden createOrden(OrdenRequest peticion) {

        List<String> libroIds = peticion.getLibros()
                .stream()
                .map(ordenLibro -> String.valueOf(ordenLibro.getLibroId()))
                .toList();

        List<libro> listaLibros = libroIds.stream()
                .map(id -> librosFacade.getLibro(id))
                .filter(Objects::nonNull)
                .toList();

        if (listaLibros.size() != libroIds.size()) {
            return null;
        } else {
            boolean disponible = peticion.getLibros().stream().
                    allMatch(ordenLibro -> listaLibros.stream().anyMatch(libro -> libro.getId().
                            equals(ordenLibro.getLibroId()) && libro.isVisibilidad() && libro.getCantidad()
                            >= ordenLibro.getCantidad()));

            if (!disponible) {
                return null;
            }
            else{
                List<OrdenItem> items = peticion.getLibros().stream()
                        .map(req -> OrdenItem.builder()
                                .libroId(req.getLibroId())
                                .cantidad(req.getCantidad())
                                .precio(req.getPrecio())
                                .subtotal(req.getSubtotal())
                                .build())
                        .collect(Collectors.toList());

                double total = items.stream().mapToDouble(OrdenItem::getSubtotal).sum();

                Orden orden = Orden.builder()
                        .fecha(LocalDate.now())
                        .estado("CONFIRMADA")
                        .total(total)
                        .libros(items)
                        .build();
                return repository.save(orden);
            }
        }

    }

    @Override
    public Orden getOrden(String id) {
        return repository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public List<Orden> getOrdenes() {
        List<Orden> ordenes= repository.findAll();
        return ordenes.isEmpty() ? null : ordenes;
    }

}
