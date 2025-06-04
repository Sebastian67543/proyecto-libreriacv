package com.distribuida.dao;

import com.distribuida.model.Categoria;
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
public class CategoriaRepositorioTestIntegracion {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        assertNotNull(categorias);
        assertTrue(categorias.size() > 0);

        for (Categoria item : categorias) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne() {
        Optional<Categoria> categoria = categoriaRepository.findById(1);
        assertTrue(categoria.isPresent(), "La categoría con id = 1 debería existir");
        System.out.println(categoria.toString());
    }

    @Test
    public void save() {
        Categoria categoria = new Categoria(0, "Tecnología", "Productos electrónicos y computación");
        categoriaRepository.save(categoria);
        assertNotNull(categoria.getIdCategoria(), "La categoría guardada debe tener un id.");
        assertEquals("Tecnología", categoria.getCategoria());
    }

    @Test
    public void update() {
        Optional<Categoria> categoria = categoriaRepository.findById(40);

        assertTrue(categoria.isPresent(), "La categoría con id = 40 debería existir para ser actualizada");

        categoria.orElse(null).setCategoria("Hogar");
        categoria.orElse(null).setDescripcion("Productos para el hogar");

        Categoria categoriaActualizada = categoriaRepository.save(categoria.orElse(null));

        assertEquals("Hogar", categoriaActualizada.getCategoria());
        assertEquals("Productos para el hogar", categoriaActualizada.getDescripcion());
    }

    @Test
    public void delete() {
        if (categoriaRepository.existsById(39)) {
            categoriaRepository.deleteById(39);
        }
        assertFalse(categoriaRepository.existsById(39), "La categoría con id = 39 debería haberse eliminado");
    }
}

