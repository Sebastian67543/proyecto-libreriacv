package com.distribuida.service;

import com.distribuida.dao.AutorRepository;
import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AutorServicioTestUnitaria {

    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private AutorServiceImpl autorService;

    private Autor autor;

    @BeforeEach
    public void setUp(){
        autor = new Autor();
        autor.setIdAutor(1);
        autor.setNombre("Leonel");
        autor.setApellido("Messi");
        autor.setPais("Argentina");
        autor.setDireccion("Rosario");
        autor.setTelefono("0937264593");
        autor.setCorreo("lmessi@gmail.com");
    }

    @Test
    public void testFindAll(){
        when(autorRepository.findAll()).thenReturn(List.of(autor));
        List<Autor> autores = autorService.findAll();
        assertNotNull(autores);
        assertEquals(1, autores.size());
        verify(autorRepository, times(1)).findAll();
    }

    @Test
    public void testFindOneExistente(){
        when(autorRepository.findById(1)).thenReturn(Optional.of(autor));
        Autor autor = autorService.findOne(1);
        assertNotNull(autor);
        assertEquals("Leonel", autor.getNombre());
    }

    @Test
    public void testFindOneNoExistente(){
        when(autorRepository.findById(2)).thenReturn(Optional.empty());
        Autor autor = autorService.findOne(2);
        assertNull(autor);
    }

    @Test
    public void testSave(){
        when(autorRepository.save(autor)).thenReturn(autor);
        Autor autor1 = autorService.save(autor);
        assertNotNull(autor1);
        assertEquals("Leonel", autor1.getNombre());
    }

    @Test
    public void testUpdateExistente(){
        Autor autorActualizado = new Autor();

        autorActualizado.setIdAutor(1);
        autorActualizado.setNombre("Lamine");
        autorActualizado.setApellido("Yamal");
        autorActualizado.setPais("España");
        autorActualizado.setDireccion("Barcelona");
        autorActualizado.setTelefono("0979264962");
        autorActualizado.setCorreo("lyamal@gmail.com");

        when(autorRepository.findById(1)).thenReturn(Optional.of(autor));
        when(autorRepository.save(any())).thenReturn(autorActualizado);
        Autor autorResultado = autorService.update(1, autorActualizado);
        assertNotNull(autorResultado);
        assertEquals("Lamine", autorResultado.getNombre());
        verify(autorRepository, times(1)).save(autor);
    }

    @Test
    public void testUpdateNoExistente(){
        Autor autorNuevo = new Autor();
        when(autorRepository.findById(2)).thenReturn(Optional.empty());
        Autor autorResultado = autorService.update(2, autorNuevo);
        assertNull(autorResultado);
        verify(autorRepository, never()).save(any());
    }

    @Test
    public void testDelete(){
        when(autorRepository.existsById(1)).thenReturn(true);
        autorService.delete(1);
        verify(autorRepository).deleteById(1);
    }

    @Test
    public void testDeleteNoExistente(){
        when(autorRepository.existsById(2)).thenReturn(false);
        autorService.delete(2);
        verify(autorRepository, never()).deleteById(anyInt());
    }


}
