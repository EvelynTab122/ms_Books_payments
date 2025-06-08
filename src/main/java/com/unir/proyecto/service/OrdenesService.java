package com.unir.proyecto.service;

import com.unir.proyecto.data.model.Orden;
import com.unir.proyecto.controller.model.OrdenRequest;
import java.util.List;

public interface OrdenesService {

    Orden createOrden(OrdenRequest request);

    Orden getOrden(String OrdenId);

    List<Orden> getOrdenes();
}
