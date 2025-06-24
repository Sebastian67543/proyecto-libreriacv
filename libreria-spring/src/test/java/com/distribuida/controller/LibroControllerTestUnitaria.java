package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Libro;
import com.distribuida.service.AutorService;
import com.distribuida.service.LibroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LibroControllerTestUnitaria {

    @InjectMocks
    private LibroController libroController;

    @InjectMocks
    private AutorController autorController;

    @Mock
    private LibroService libroService;

    @Mock
    private AutorService autorService;

    private Libro libro;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setCategoria("Deportes");

        Autor autor = new Autor();
        autor.setIdAutor(1);
        autor.setNombre("Luis");
        autor.setApellido("Suarez");

        libro = new Libro();

        libro.setIdlibro(1);
        libro.setTitulo("Futbol Basico");
        libro.setIsbn("978-3-16-148410-0");
        libro.setNumpaginas(230);
        libro.setEdicion("Primera");
        libro.setDescripcion("Tecnicas basicas del futbol");
        libro.setPrecio(35.90);
        libro.setNumejemplares(10);
        libro.setCategoria(categoria);
        libro.setAutor(autor);
    }

    @Test
    public void testFindAll(){
        when(libroService.findAll()).thenReturn(List.of(libro));
        ResponseEntity<List<Libro>> respuesta = libroController.findAll();
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(libroService, times(1)).findAll();
    }


    @Test
    public void testFindOneExistente(){
        when(libroService.findOne(1)).thenReturn(libro);
        ResponseEntity<Libro> respuesta = libroController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(libro.getAutor(),respuesta.getBody().getAutor());
    }

    @Test
    public void testFindOneNoExistente(){
        when(libroService.findOne(2)).thenReturn(null);
        ResponseEntity<Libro> respuesta = libroController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testSave(){
        when(libroService.save(any(Libro.class))).thenReturn(libro);
        ResponseEntity<Libro> respuesta = libroController.save(libro);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals("Futbol Basico",respuesta.getBody().getTitulo());
    }

    @Test
    public void testUpdateExistente() {
        when(libroService.update(eq(1), any(Libro.class))).thenReturn(libro);
        ResponseEntity<Libro> respuesta = libroController.update(1, libro);
        assertEquals(200, respuesta.getStatusCodeValue());
    }

    @Test
    public void testUpdateNoExistente(){
        when(libroService.update(eq(2),any(Libro.class))).thenReturn(null);
        ResponseEntity<Libro> respuesta = libroController.update(2,libro);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testDelete(){
        doNothing().when(libroService).delete(1);
        ResponseEntity<Void> respuesta = libroController.delete(1);
        assertEquals(204, respuesta.getStatusCodeValue());
        verify(libroService, times(1)).delete(1);
    }

}
