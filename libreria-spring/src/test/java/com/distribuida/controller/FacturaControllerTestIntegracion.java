package com.distribuida.controller;


import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import com.distribuida.service.FacturaService;
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

@WebMvcTest(FacturaController.class)
public class FacturaControllerTestIntegracion {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacturaService facturaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAll() throws Exception {

        Cliente cliente = new Cliente(1,"1789543820","Enzo","Fernandez","Rosario","0982673489","efernandez@gmail.com");


        Factura factura = new Factura(1,250.00,50.00,200.00,cliente,new Date(),"FAC-0180");

        Mockito.when(facturaService.findAll()).thenReturn(List.of(factura));

        mockMvc.perform(get("/api/facturas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idFactura").value(1));

    }

    @Test
    public void testSave() throws Exception {
        Cliente cliente = new Cliente(1,"1789543820","Enzo","Fernandez","Rosario","0982673489","efernandez@gmail.com");


        Factura factura = new Factura(1,250.00,50.00,200.00,cliente,new Date(),"FAC-0180");

        Mockito.when(facturaService.save(any(Factura.class))).thenReturn(factura);
        mockMvc.perform(post("/api/facturas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(factura))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.idFactura").value(1));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/api/facturas/1")).andExpect(status().isNoContent());
    }




}
