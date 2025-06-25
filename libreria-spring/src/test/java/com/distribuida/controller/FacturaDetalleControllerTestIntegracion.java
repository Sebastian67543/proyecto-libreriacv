package com.distribuida.controller;


import com.distribuida.model.*;
import com.distribuida.service.FacturaDetalleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacturaDetalleController.class)
public class FacturaDetalleControllerTestIntegracion {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacturaDetalleService facturaDetalleService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAll() throws Exception {

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

        FacturaDetalle facturaDetalle = new FacturaDetalle(1,20,35.50,libro,factura,autor);

        Mockito.when(facturaDetalleService.findAll()).thenReturn(List.of(facturaDetalle));

        mockMvc.perform(get("/api/factura-detalles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idFacturaDetalle").value(1));
    }

    @Test
    public void testSave() throws Exception {
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

        FacturaDetalle facturaDetalle = new FacturaDetalle(1,20,35.50,libro,factura,autor);

        Mockito.when(facturaDetalleService.save(any(FacturaDetalle.class))).thenReturn(facturaDetalle);
        mockMvc.perform(post("/api/factura-detalles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(facturaDetalle))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.idFacturaDetalle").value(1));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/api/factura-detalles/1")).andExpect(status().isNoContent());
    }



}
