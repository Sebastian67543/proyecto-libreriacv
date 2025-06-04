package com.distribuida.test;

import org.distribuida.entities.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    private Autor autor;

    @BeforeEach
    public void setup() {
        autor = new Autor(1, "Gabriel", "Garcia Marquez", "Colombia", "Calle 123", "0987654321", "gabriel@mail.com");
    }

    @Test
    public void testAutorConstructorAndGetters() {
        assertAll("Validar datos Autor - Constructor y Getters",
                () -> assertEquals(1, autor.getIdAutor()),
                () -> assertEquals("Gabriel", autor.getNombre()),
                () -> assertEquals("Garcia Marquez", autor.getApellido()),
                () -> assertEquals("Colombia", autor.getPais()),
                () -> assertEquals("Calle 123", autor.getDireccion()),
                () -> assertEquals("0987654321", autor.getTelefono()),
                () -> assertEquals("gabriel@mail.com", autor.getCorreo())
        );
    }

    @Test
    public void testAutorSetters() {
        autor.setIdAutor(2);
        autor.setNombre("Mario");
        autor.setApellido("Vargas Llosa");
        autor.setPais("Peru");
        autor.setDireccion("Av. Siempre Viva 456");
        autor.setTelefono("0998877665");
        autor.setCorreo("mario@mail.com");

        assertAll("Validar datos Autor - Setters",
                () -> assertEquals(2, autor.getIdAutor()),
                () -> assertEquals("Mario", autor.getNombre()),
                () -> assertEquals("Vargas Llosa", autor.getApellido()),
                () -> assertEquals("Peru", autor.getPais()),
                () -> assertEquals("Av. Siempre Viva 456", autor.getDireccion()),
                () -> assertEquals("0998877665", autor.getTelefono()),
                () -> assertEquals("mario@mail.com", autor.getCorreo())
        );
    }

    @Test
    public void testAutorToString() {
        String str = autor.toString();
        assertAll("Validar método toString de Autor",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Gabriel")),
                () -> assertTrue(str.contains("Garcia Marquez")),
                () -> assertTrue(str.contains("Colombia")),
                () -> assertTrue(str.contains("Calle 123")),
                () -> assertTrue(str.contains("0987654321")),
                () -> assertTrue(str.contains("gabriel@mail.com"))
        );
    }
}

