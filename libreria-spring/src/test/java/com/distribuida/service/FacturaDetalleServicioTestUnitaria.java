package com.distribuida.service;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FacturaDetalleServicioTestUnitaria {

    @Mock
    private FacturaDetalleRepository facturaDetalleRepository;

    @InjectMocks
    private FacturaDetalleServiceImpl facturaDetalleService;

    private FacturaDetalle facturaDetalle;
    private Libro libro;
    private Factura factura;
    private Autor autor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        autor = new Autor();
        autor.setIdAutor(1);
        autor.setNombre("Isaac");
        autor.setApellido("Asimov");

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setDescripcion("Descripción de la categoría");

        libro = new Libro(1, "Fundación", "Planeta", 320, "1ra", "Español", new Date(),
                "Obra maestra", "Dura", "123456789", 10, "url.jpg", "presentación", 29.99, categoria, autor);

        Cliente cliente = new Cliente(1, "1234567890", "John", "Doe", "Calle Falsa 123", "0999999999", "john@correo.com");

        factura = new Factura(1, 59.98, 0.00, 59.98, cliente, new Date(), "FAC-002");

        facturaDetalle = new FacturaDetalle(1, 2, 59.98, libro, factura, autor);
    }

    @Test
    public void testFindAll() {
        when(facturaDetalleRepository.findAll()).thenReturn(Arrays.asList(facturaDetalle));
        List<FacturaDetalle> detalles = facturaDetalleService.findAll();
        assertNotNull(detalles);
        assertEquals(1, detalles.size());
        verify(facturaDetalleRepository, times(1)).findAll();
    }

    @Test
    public void testFindOne() {
        when(facturaDetalleRepository.findById(1)).thenReturn(Optional.of(facturaDetalle));
        FacturaDetalle detalle = facturaDetalleService.findOne(1);
        assertNotNull(detalle);
        assertEquals(2, detalle.getCantidad());
        assertEquals(59.98, detalle.getSubtotal());
        verify(facturaDetalleRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        when(facturaDetalleRepository.save(facturaDetalle)).thenReturn(facturaDetalle);
        FacturaDetalle saved = facturaDetalleService.save(facturaDetalle);
        assertNotNull(saved);
        assertEquals(2, saved.getCantidad());
        verify(facturaDetalleRepository, times(1)).save(facturaDetalle);
    }

    @Test
    public void testUpdate() {
        FacturaDetalle detalleActualizado = new FacturaDetalle(1, 3, 89.97, libro, factura, autor);

        when(facturaDetalleRepository.findById(1)).thenReturn(Optional.of(facturaDetalle));
        when(facturaDetalleRepository.save(any(FacturaDetalle.class))).thenReturn(detalleActualizado);

        FacturaDetalle updated = facturaDetalleService.update(1, detalleActualizado);

        assertNotNull(updated);
        assertEquals(3, updated.getCantidad());
        assertEquals(89.97, updated.getSubtotal());
        verify(facturaDetalleRepository).save(any(FacturaDetalle.class));
    }

    @Test
    public void testDelete() {
        when(facturaDetalleRepository.existsById(1)).thenReturn(false);
        facturaDetalleService.delete(1);
        verify(facturaDetalleRepository, times(0)).deleteById(1); // Ajusta según lógica del servicio
    }
}
