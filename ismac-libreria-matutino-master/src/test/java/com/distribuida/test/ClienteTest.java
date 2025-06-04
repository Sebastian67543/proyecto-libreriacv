package com.distribuida.test;


import org.distribuida.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente;


    @BeforeEach
    public void setup(){

        cliente = new Cliente(1,"175338482", "juan", "Caiza", "tropico", "0979332474", "jcaia@gmauil.com");




    }

    @Test
    public void testCLienteConstructorAndGetter(){

        assertAll("validar datos Cliente, Contructor y Getter",
                () -> assertEquals(1,cliente.getIdCliente()),
                () -> assertEquals("175338482",cliente.getCedula()),
                () -> assertEquals("juan",cliente.getNombre()),
                () -> assertEquals("Caiza",cliente.getApellido()),
                () -> assertEquals("tropico",cliente.getDireccion()),
                () -> assertEquals("0979332474",cliente.getTelefono()),
                () -> assertEquals("jcaia@gmauil.com",cliente.getCorreo())
        );


    }


    @Test
    public void testClienteSetters(){

        cliente.setIdCliente(2);
        cliente.setCedula("173549565564");
        cliente.setNombre("Pepe");
        cliente.setApellido("chupin");
        cliente.setDireccion("perro");
        cliente.setTelefono("0978896435");
        cliente.setCorreo("pepeAgmail.com");


        assertAll("Validar Datos Clientes - Setters",
                () -> assertEquals(2,cliente.getIdCliente()),
                () -> assertEquals("173549565564",cliente.getCedula()),
                () -> assertEquals("Pepe",cliente.getNombre()),
                () -> assertEquals("chupin",cliente.getApellido()),
                () -> assertEquals("perro",cliente.getDireccion()),
                () -> assertEquals("0978896435",cliente.getTelefono()),
                () -> assertEquals("pepeAgmail.com",cliente.getCorreo())
                );

    }


     @Test
    public void testClienteToString(){

        String str = cliente.toString();
        assertAll("Validacion Datos Cliente - ToString",
         () -> assertTrue(str.contains("1")),
                 () -> assertTrue(str.contains("175338482")),
                 () -> assertTrue(str.contains("juan")),
                 () -> assertTrue(str.contains("Caiza")),
                 () -> assertTrue(str.contains("tropico")),
                 () -> assertTrue(str.contains("0979332474")),
                 () -> assertTrue(str.contains("jcaia@gmauil.com"))
        );
     }




}
