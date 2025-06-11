package com.distribuida.service;


import com.distribuida.dao.AutorRepository;
import com.distribuida.dao.CategoriaRepository;
import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibroServicioTestUnitaria {

    @Mock
    private AutorRepository autorRepository;
    @InjectMocks
    private AutorServiceImpl autorService;

    @Mock
    private CategoriaRepository categoriaRepository;
    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    private Autor autor;
    private Categoria categoria;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        autor = new Autor(1,"Luis","Suarez","Uruguay","Montevideo","0952836721","lsuarez@gmail.com");

        categoria = new Categoria(1,"Tecnologia","Java Basico");

    }

    @Test
    public void testFindAll(){
        when(autorRepository.findAll()).thenReturn(Arrays.asList(autor));
        List<Autor> autores = autorService.findAll();
        assertNotNull(autores);
        assertEquals(1, autores.size());
        verify(autorRepository, times(1)).findAll();
    }

    @Test
    public void testFindOne(){
        when(autorRepository.findById(1)).thenReturn(Optional.of(autor));

        Autor autor = autorService.findOne(1);
        assertNotNull(autor);
        assertEquals("Luis" , autor.getNombre());
        verify(autorRepository, times(1)).findById(1);
    }

    @Test
    public void save(){
        when(autorRepository.save(autor)).thenReturn(autor);
        Autor autor1 = autorService.save(autor);
        assertNotNull(autor1);
        assertEquals("Luis", autor.getNombre());
        verify(autorRepository, times(1)).save(autor);
    }

    @Test
    public void update(){
        Autor autorActualizado = new Autor(1,"Neymar","Da Silva","Brasil","Santos","0986254793","neyamr@gmail.com");
        when(autorRepository.findById(1)).thenReturn(Optional.of(autor));
        when(autorRepository.save(any(Autor.class))).thenReturn(autorActualizado);
        when(autorRepository.findById(1)).thenReturn(Optional.of(autor));
        Autor autor2 = autorService.update(1, autorActualizado);
        assertNotNull(autor2);
        assertEquals(1, autor2.getIdAutor());
        assertEquals("Neymar", autor2.getNombre());
        verify(autorRepository).save(any(Autor.class));
    }

    @Test
    public void testDelete(){
        when(autorRepository.existsById(1)).thenReturn(false);
        autorService.delete(1);
        verify(autorRepository, times(0)).deleteById(1);
    }


}

