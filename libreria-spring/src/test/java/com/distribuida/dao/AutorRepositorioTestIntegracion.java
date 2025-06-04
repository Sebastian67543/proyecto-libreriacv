package com.distribuida.dao;

import com.distribuida.model.Autor;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class AutorRepositorioTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void findAll() {
        List<Autor> autores = autorRepository.findAll();
        assertNotNull(autores);
        assertTrue(autores.size() > 0);

        for (Autor autor : autores) {
            System.out.println(autor.toString());
        }
    }

    @Test
    public void findOne() {
        Optional<Autor> autor = autorRepository.findById(1);
        assertTrue(autor.isPresent(), "El autor con id = 1 debería existir");
        System.out.println(autor.toString());
    }

    @Test
    public void save() {
        Autor autor = new Autor(0, "Gabriel", "García Márquez", "Colombia", "Aracataca", "0987654321", "gabriel@example.com");
        autorRepository.save(autor);
        assertNotNull(autor.getIdAutor(), "El autor guardado debe tener un ID.");
        assertEquals("Gabriel", autor.getNombre());
    }

    @Test
    public void update() {
        Optional<Autor> autor = autorRepository.findById(40);

        assertTrue(autor.isPresent(), "El autor con id = 40 debería existir para ser actualizado");

        autor.orElse(null).setNombre("Mario");
        autor.orElse(null).setApellido("Vargas Llosa");
        autor.orElse(null).setPais("Perú");
        autor.orElse(null).setDireccion("Lima");
        autor.orElse(null).setTelefono("0991234567");
        autor.orElse(null).setCorreo("mario@example.com");

        Autor autorActualizado = autorRepository.save(autor.orElse(null));

        assertEquals("Mario", autorActualizado.getNombre());
        assertEquals("Vargas Llosa", autorActualizado.getApellido());
    }

    @Test
    public void delete() {
        if (autorRepository.existsById(39)) {
            autorRepository.deleteById(39);
        }
        assertFalse(autorRepository.existsById(39), "El autor con id = 39 debería haberse eliminado");
    }
}

