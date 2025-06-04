package com.distribuida.test;

import org.distribuida.entities.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {

    private Categoria categoria;

    @BeforeEach
    public void setup() {
        categoria = new Categoria(1, "Ficción", "Libros de género ficción");
    }

    @Test
    public void testCategoriaConstructorAndGetters() {
        assertAll("Validar datos Categoria - Constructor y Getters",
                () -> assertEquals(1, categoria.getIdCategoria()),
                () -> assertEquals("Ficción", categoria.getCategoria()),
                () -> assertEquals("Libros de género ficción", categoria.getDescripcion())
        );
    }

    @Test
    public void testCategoriaSetters() {
        categoria.setIdCategoria(2);
        categoria.setCategoria("No ficción");
        categoria.setDescripcion("Libros basados en hechos reales");

        assertAll("Validar datos Categoria - Setters",
                () -> assertEquals(2, categoria.getIdCategoria()),
                () -> assertEquals("No ficción", categoria.getCategoria()),
                () -> assertEquals("Libros basados en hechos reales", categoria.getDescripcion())
        );
    }

    @Test
    public void testCategoriaToString() {
        String str = categoria.toString();
        assertAll("Validar método toString de Categoria",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Ficción")),
                () -> assertTrue(str.contains("Libros de género ficción"))
        );
    }
}

