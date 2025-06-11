package com.distribuida.service;

import com.distribuida.model.FacturaDetalle;

import java.util.List;

public interface FacturaDetalleService {

    // Métodos estándar
    List<FacturaDetalle> findAll();
    FacturaDetalle findOne(int id);
    FacturaDetalle save(FacturaDetalle facturaDetalle);
    FacturaDetalle update(int id, FacturaDetalle facturaDetalle);
    void delete(int id);

    // Métodos alternativos que usan IDs para relaciones
    FacturaDetalle save(FacturaDetalle detalle, int idLibro, int idFactura, int idAutor);
    FacturaDetalle update(int id, int idLibro, int idFactura, int idAutor, FacturaDetalle detalle);
}

