package com.distribuida.controller;

import com.distribuida.model.*;
import com.distribuida.service.FacturaDetalleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FacturaDetalleControllerTestUnitaria {

    @InjectMocks
    private FacturaDetalleController facturaDetalleController;

    @Mock
    private FacturaDetalleService facturaDetalleService;

    private FacturaDetalle facturaDetalle;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        Autor autor = new Autor();

        autor.setIdAutor(1);
        autor.setNombre("Jamal");
        autor.setApellido("Musiala");
        autor.setDireccion("Bayern");
        autor.setPais("Alemania");
        autor.setTelefono("0986782567");
        autor.setCorreo("jmusiala@gmail.com");

        Categoria categoria = new Categoria();

        categoria.setIdCategoria(1);
        categoria.setCategoria("Deportes");
        categoria.setDescripcion("Futbol");


        Libro libro = new Libro();
        libro.setIdlibro(1);
        libro.setTitulo("Goles Imposibles");
        libro.setDescripcion("Goles Importantes");
        libro.setAutor(autor);
        libro.setCategoria(categoria);
        libro.setNumejemplares(20);
        libro.setPrecio(25.50);
        libro.setIsbn("978-3-16-148410-0");
        libro.setNumpaginas(50);
        libro.setEdicion("limitada");
        libro.setEditorial("ismac");
        libro.setTipopasta("Pasta Dura");
        libro.setFechapublicacion(new Date());
        libro.setIdioma("español");
        libro.setPortada("Goles Imposibles");


        Cliente cliente = new Cliente();

        cliente.setIdCliente(1);
        cliente.setNombre("Lucas");
        cliente.setApellido("Vasquez");
        cliente.setCedula("1730289456");
        cliente.setDireccion("Madrid");
        cliente.setTelefono("0967826743");
        cliente.setCorreo("lvasquez@gmail.com");


        Factura factura = new Factura();

        factura.setIdFactura(1);
        factura.setNumFactura("FAC-0095");
        factura.setFecha(new Date());
        factura.setIva(15.00);
        factura.setTotal(215.00);
        factura.setTotalNeto(230.00);
        factura.setCliente(cliente);

        this.facturaDetalle = new FacturaDetalle(1,20,38.50,libro,factura,autor);
    }

    @Test
    public void testFindAll(){
        when(facturaDetalleService.findAll()).thenReturn(List.of(facturaDetalle));
        ResponseEntity<List<FacturaDetalle>> respuesta = facturaDetalleController.findAll();
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(facturaDetalleService, times(1)).findAll();
    }

    @Test
    public void testFindOneExistente(){
        when(facturaDetalleService.findOne(1)).thenReturn(facturaDetalle);
        ResponseEntity<FacturaDetalle> respuesta = facturaDetalleController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(facturaDetalle.getIdFacturaDetalle(),respuesta.getBody().getIdFacturaDetalle());
    }

    @Test
    public void testFindOneNOExistente(){
        when(facturaDetalleService.findOne(2)).thenReturn(null);
        ResponseEntity<FacturaDetalle> respuesta = facturaDetalleController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testSave(){
        when(facturaDetalleService.save(any(FacturaDetalle.class))).thenReturn(facturaDetalle);
        ResponseEntity<FacturaDetalle> respuesta = facturaDetalleController.save(facturaDetalle);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().getIdFacturaDetalle());
    }

    @Test
    public void testUpdateExistente(){
        when(facturaDetalleService.update(eq(1),any(FacturaDetalle.class))).thenReturn(facturaDetalle);
        ResponseEntity<FacturaDetalle> respuesta = facturaDetalleController.update(1,facturaDetalle);
        assertEquals(200, respuesta.getStatusCodeValue());
    }

    @Test
    public void testUpdateNoExistente(){
        when(facturaDetalleService.update(eq(2),any(FacturaDetalle.class))).thenReturn(null);
        ResponseEntity<FacturaDetalle> respuesta = facturaDetalleController.update(2,facturaDetalle);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testDelete(){
        doNothing().when(facturaDetalleService).delete(1);
        ResponseEntity<Void> respuesta = facturaDetalleController.delete(1);
        assertEquals(204, respuesta.getStatusCodeValue());
        verify(facturaDetalleService, times(1)).delete(1);
    }


}
