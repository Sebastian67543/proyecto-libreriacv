package com.distribuida.test;

import org.distribuida.entities.FacturaDetalle;
import org.distribuida.entities.Libro;
import org.distribuida.entities.Factura;
import org.distribuida.entities.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaDetalleTest {

    private FacturaDetalle facturaDetalle;
    private Libro libro;
    private Factura factura;
    private Autor autor;

    @BeforeEach
    public void setup() {
        // Crear objetos dependientes simples para la prueba
        libro = new Libro();    // Asumiendo constructor sin parámetros
        factura = new Factura();
        autor = new Autor();

        facturaDetalle = new FacturaDetalle(1, 5, 150.0, libro, factura, autor);
    }

    @Test
    public void testFacturaDetalleConstructorAndGetters() {
        assertAll("Validar datos FacturaDetalle - Constructor y Getters",
                () -> assertEquals(1, facturaDetalle.getIdFacuraDetalle()),
                () -> assertEquals(5, facturaDetalle.getCantidad()),
                () -> assertEquals(150.0, facturaDetalle.getSubtotal()),
                () -> assertEquals(libro, facturaDetalle.getLibro()),
                () -> assertEquals(factura, facturaDetalle.getFactura()),
                () -> assertEquals(autor, facturaDetalle.getAutor())
        );
    }

    @Test
    public void testFacturaDetalleSetters() {
        Libro libro2 = new Libro();
        Factura factura2 = new Factura();
        Autor autor2 = new Autor();

        facturaDetalle.setIdFacuraDetalle(2);
        facturaDetalle.setCantidad(10);
        facturaDetalle.setSubtotal(300.0);
        facturaDetalle.setLibro(libro2);
        facturaDetalle.setFactura(factura2);
        facturaDetalle.setAutor(autor2);

        assertAll("Validar datos FacturaDetalle - Setters",
                () -> assertEquals(2, facturaDetalle.getIdFacuraDetalle()),
                () -> assertEquals(10, facturaDetalle.getCantidad()),
                () -> assertEquals(300.0, facturaDetalle.getSubtotal()),
                () -> assertEquals(libro2, facturaDetalle.getLibro()),
                () -> assertEquals(factura2, facturaDetalle.getFactura()),
                () -> assertEquals(autor2, facturaDetalle.getAutor())
        );
    }

    @Test
    public void testFacturaDetalleToString() {
        String str = facturaDetalle.toString();
        assertAll("Validar método toString de FacturaDetalle",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("5")),
                () -> assertTrue(str.contains("150.0")),
                // Solo comprobamos que los objetos están representados (no el contenido interno)
                () -> assertTrue(str.contains("libro")),
                () -> assertTrue(str.contains("factura")),
                () -> assertTrue(str.contains("autor"))
        );
    }
}

