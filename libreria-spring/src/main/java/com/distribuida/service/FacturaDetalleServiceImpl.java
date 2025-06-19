package com.distribuida.service;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Override
    public List<FacturaDetalle> findAll() {
        return facturaDetalleRepository.findAll();
    }

    @Override
    public FacturaDetalle findById(int id) {
        return null; // Puedes implementar igual que findOne o eliminar este método si no lo usas
    }

    @Override
    public FacturaDetalle findOne(int id) {
        Optional<FacturaDetalle> detalle = facturaDetalleRepository.findById(id);
        return detalle.orElse(null);
    }

    @Override
    public FacturaDetalle save(FacturaDetalle facturaDetalle) {
        return facturaDetalleRepository.save(facturaDetalle);
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle facturaDetalleNuevo) {
        FacturaDetalle detalleExistente = findOne(id);

        if (detalleExistente == null) {
            return null;
        }

        // Actualizamos todos los campos relevantes
        detalleExistente.setCantidad(facturaDetalleNuevo.getCantidad());
        detalleExistente.setSubtotal(facturaDetalleNuevo.getSubtotal());
        detalleExistente.setLibro(facturaDetalleNuevo.getLibro());
        detalleExistente.setFactura(facturaDetalleNuevo.getFactura());
        //detalleExistente.setAutor(facturaDetalleNuevo.getAutor());

        return facturaDetalleRepository.save(detalleExistente);
    }

    @Override
    public void delete(int id) {
        if (facturaDetalleRepository.existsById(id)) {
            facturaDetalleRepository.deleteById(id);
        }
    }
}


