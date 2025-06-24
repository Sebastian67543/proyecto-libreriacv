package com.distribuida.controller;


import com.distribuida.model.Autor;
import com.distribuida.service.AutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutorController.class)
public class AutorControllerTestIntegracion {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutorService autorService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testFindAll() throws Exception {
        Autor autor = new Autor(1,"Neymar","Junior","Brasil","Santos","0927834909","njunior@gmail.com");

        Mockito.when(autorService.findAll()).thenReturn(List.of(autor));

        mockMvc.perform(get("/autor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Neymar"));


    }

    @Test
    public void testSave() throws Exception {
        Autor autor = new Autor(1,"Neymar","Junior","Brasil","Santos","0927834909","njunior@gmail.com");

        Mockito.when(autorService.save(any(Autor.class))).thenReturn(autor);


        mockMvc.perform(post("/autor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(autor))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Neymar"));



    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/autor/1")).andExpect(status().isNoContent());
    }





}
