package com.distribuida.controller;

import com.distribuida.model.FacturaDetalle;
import com.distribuida.service.FacturaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/factura-detalles")
public class FacturaDetalleController {

    @Autowired
    private FacturaDetalleService facturaDetalleService;

    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> findAll() {
        List<FacturaDetalle> detalles = facturaDetalleService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalle> findOne(@PathVariable int id) {
        FacturaDetalle detalle = facturaDetalleService.findOne(id);
        if (detalle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalle);
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> save(@RequestBody FacturaDetalle detalle) {
        FacturaDetalle detalleNuevo = facturaDetalleService.save(detalle);
        return ResponseEntity.ok(detalleNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDetalle> update(@PathVariable int id, @RequestBody FacturaDetalle detalle) {
        FacturaDetalle detalleActualizado = facturaDetalleService.update(id, detalle);
        if (detalleActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalleActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        facturaDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint adicional para buscar detalles por factura
    @GetMapping("/factura/{facturaId}")
    public ResponseEntity<List<FacturaDetalle>> findByFacturaId(@PathVariable int facturaId) {
        List<FacturaDetalle> detalles = Collections.singletonList(facturaDetalleService.findById(facturaId));
        return ResponseEntity.ok(detalles);
    }
}

