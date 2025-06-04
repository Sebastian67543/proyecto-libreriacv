package com.distribuida.test;

import org.distribuida.entities.Autor;
import org.distribuida.entities.Categoria;
import org.distribuida.entities.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    private Libro libro;
    private Categoria categoria;
    private Autor autor;
    private Date fechaPublicacion;

    @BeforeEach
    public void setup() {
        categoria = new Categoria(1, "Ficción", "Libros de ficción");
        autor = new Autor(1, "Gabriel", "García Márquez", "Colombia", "Bogotá", "123456789", "gabriel@mail.com");
        fechaPublicacion = new Date();

        libro = new Libro(1, "Cien Años de Soledad", "Sudamericana", 471,
                "Primera", "Español", fechaPublicacion, "Novela clásica",
                "Tapa dura", "978-3-16-148410-0", 100,
                "portada.jpg", "Presencial", 25.99,
                categoria, autor);
    }

    @Test
    public void testLibroConstructorAndGetters() {
        assertAll("Validar datos Libro - Constructor y Getters",
                () -> assertEquals(1, libro.getIdlibro()),
                () -> assertEquals("Cien Años de Soledad", libro.getTitulo()),
                () -> assertEquals("Sudamericana", libro.getEditorial()),
                () -> assertEquals(471, libro.getNumpaginas()),
                () -> assertEquals("Primera", libro.getEdicion()),
                () -> assertEquals("Español", libro.getIdioma()),
                () -> assertEquals(fechaPublicacion, libro.getFechapublicacion()),
                () -> assertEquals("Novela clásica", libro.getDescipcion()),
                () -> assertEquals("Tapa dura", libro.getTipopasta()),
                () -> assertEquals("978-3-16-148410-0", libro.getIsbn()),
                () -> assertEquals(100, libro.getNumejemplares()),
                () -> assertEquals("portada.jpg", libro.getPortada()),
                () -> assertEquals("Presencial", libro.getPresentacion()),
                () -> assertEquals(25.99, libro.getPrecio()),
                () -> assertEquals(categoria, libro.getCategoria()),
                () -> assertEquals(autor, libro.getAutor())
        );
    }

    @Test
    public void testLibroSetters() {
        Categoria nuevaCategoria = new Categoria(2, "No Ficción", "Libros de no ficción");
        Autor nuevoAutor = new Autor(2, "Isabel", "Allende", "Chile", "Santiago", "987654321", "isabel@mail.com");
        Date nuevaFecha = new Date(System.currentTimeMillis() - 1000000000L);

        libro.setIdlibro(2);
        libro.setTitulo("La Casa de los Espíritus");
        libro.setEditorial("Plaza & Janes");
        libro.setNumpaginas(450);
        libro.setEdicion("Segunda");
        libro.setIdioma("Español");
        libro.setFechapublicacion(nuevaFecha);
        libro.setDescipcion("Novela histórica");
        libro.setTipopasta("Tapa blanda");
        libro.setIsbn("978-1-23-456789-0");
        libro.setNumejemplares(50);
        libro.setPortada("portada2.jpg");
        libro.setPresentacion("Digital");
        libro.setPrecio(30.50);
        libro.setCategoria(nuevaCategoria);
        libro.setAutor(nuevoAutor);

        assertAll("Validar datos Libro - Setters",
                () -> assertEquals(2, libro.getIdlibro()),
                () -> assertEquals("La Casa de los Espíritus", libro.getTitulo()),
                () -> assertEquals("Plaza & Janes", libro.getEditorial()),
                () -> assertEquals(450, libro.getNumpaginas()),
                () -> assertEquals("Segunda", libro.getEdicion()),
                () -> assertEquals("Español", libro.getIdioma()),
                () -> assertEquals(nuevaFecha, libro.getFechapublicacion()),
                () -> assertEquals("Novela histórica", libro.getDescipcion()),
                () -> assertEquals("Tapa blanda", libro.getTipopasta()),
                () -> assertEquals("978-1-23-456789-0", libro.getIsbn()),
                () -> assertEquals(50, libro.getNumejemplares()),
                () -> assertEquals("portada2.jpg", libro.getPortada()),
                () -> assertEquals("Digital", libro.getPresentacion()),
                () -> assertEquals(30.50, libro.getPrecio()),
                () -> assertEquals(nuevaCategoria, libro.getCategoria()),
                () -> assertEquals(nuevoAutor, libro.getAutor())
        );
    }

    @Test
    public void testLibroToString() {
        String str = libro.toString();
        assertAll("Validar método toString de Libro",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Cien Años de Soledad")),
                () -> assertTrue(str.contains("Sudamericana")),
                () -> assertTrue(str.contains("471")),
                () -> assertTrue(str.contains("Primera")),
                () -> assertTrue(str.contains("Español")),
                () -> assertTrue(str.contains(fechaPublicacion.toString())),
                () -> assertTrue(str.contains("Novela clásica")),
                () -> assertTrue(str.contains("Tapa dura")),
                () -> assertTrue(str.contains("978-3-16-148410-0")),
                () -> assertTrue(str.contains("100")),
                () -> assertTrue(str.contains("portada.jpg")),
                () -> assertTrue(str.contains("Presencial")),
                () -> assertTrue(str.contains("25.99")),
                // Comprobamos que la cadena incluye referencias a categoria y autor (depende de toString en esas clases)
                () -> assertTrue(str.contains("categoria")),
                () -> assertTrue(str.contains("autor"))
        );
    }
}
