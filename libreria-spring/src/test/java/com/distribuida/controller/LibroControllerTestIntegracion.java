package com.distribuida.controller;


import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Libro;
import com.distribuida.service.LibroService;
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

@WebMvcTest(LibroController.class)
public class LibroControllerTestIntegracion {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroService libroService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testFindAll() throws Exception {

        Categoria categoria = new Categoria(1,"Deportes","Mira la historia de Leonel Messi");

        Autor autor = new Autor(1,"Leonel","Messi","Argentina","Rosario","0962737853","lmessi@gmail.com");


        Libro libro = new Libro(1,"La Pulga","ismac",240,"literario","español",new Date(),"Mira la historia de Leonel Messi","pasta dura","978-3-16-148410-0",30,"La pulga","fisica",25.50,categoria,autor);

        Mockito.when(libroService.findAll()).thenReturn(List.of(libro));


        mockMvc.perform(get("/libros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("La Pulga"));
    }


    @Test
    public void testSave() throws Exception {

        Categoria categoria = new Categoria(1,"Deportes","Mira la historia de Leonel Messi");

        Autor autor = new Autor(1,"Leonel","Messi","Argentina","Rosario","0962737853","lmessi@gmail.com");


        Libro libro = new Libro(1,"La Pulga","ismac",240,"literario","español",new Date(),"Mira la historia de Leonel Messi","pasta dura","978-3-16-148410-0",30,"La pulga","fisica",25.50,categoria,autor);

        Mockito.when(libroService.save(any(Libro.class))).thenReturn(libro);
        mockMvc.perform(post("/libros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(libro))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("La Pulga"));

    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/libros/1")).andExpect(status().isNoContent());
    }



}
