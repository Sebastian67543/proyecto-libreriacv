package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.service.AutorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AutorControllerTestUnitaria {

    @InjectMocks
    private AutorController autorController;


    @Mock
    private AutorService autorService;

    private Autor autor;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);


        autor = new Autor();

        autor.setIdAutor(1);
        autor.setNombre("Xabi");
        autor.setApellido("Alonso");
        autor.setPais("España");
        autor.setDireccion("Madrid");
        autor.setTelefono("0942897620");
        autor.setCorreo("xalonso@gmail.com");
    }

    @Test
    public void testFindAll(){
        when(autorService.findAll()).thenReturn(List.of(autor));
        ResponseEntity<List<Autor>> respuesta = autorController.findAll();
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(autorService, times(1)).findAll();
    }

    @Test
    public void testFindOneExistente(){
        when(autorService.findOne(1)).thenReturn(autor);
        ResponseEntity<Autor> respuesta = autorController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(autor.getNombre(),respuesta.getBody().getNombre());
    }

    @Test
    public void testFindOneNoExistente(){
        when(autorService.findOne(2)).thenReturn(null);
        ResponseEntity<Autor> respuesta = autorController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testSave(){
        when(autorService.save(any(Autor.class))).thenReturn(autor);
        ResponseEntity<Autor> respuesta = autorController.save(autor);
        assertEquals(200,respuesta.getStatusCodeValue());
        assertEquals("Xabi", respuesta.getBody().getNombre());
    }

    @Test
    public void testUpdateExistente(){
        when(autorService.update(eq(1),any(Autor.class))).thenReturn(autor);
        ResponseEntity<Autor> respuesta = autorController.update(1,autor);
        assertEquals(200, respuesta.getStatusCodeValue());
    }

    @Test
    public void testUpdateNoExistente(){
        when(autorService.update(eq(2),any(Autor.class))).thenReturn(null);
        ResponseEntity<Autor> respuesta = autorController.update(2,autor);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testDelete(){
        doNothing().when(autorService).delete(1);
        ResponseEntity<Void> respuesta = autorController.delete(1);
        assertEquals(204, respuesta.getStatusCodeValue());
        verify(autorService, times(1)).delete(1);
    }



}
