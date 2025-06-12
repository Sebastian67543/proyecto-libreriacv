package com.distribuida.dao;


import com.distribuida.model.Autor;
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
public class LibroRepositorioTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void findAll(){
        List<Autor> autores = autorRepository.findAll();
        assertNotNull(autores);
        for (Autor item: autores){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Autor> autor = autorRepository.findById(1);

        assertTrue(autor.isPresent());

        System.out.println(autor.toString());
    }


    @Test
    public void save(){
        Autor autor = new Autor();

        Optional<Categoria> categoria = categoriaRepository.findById(1);

        assertTrue(categoria.isPresent());

        autor.setIdAutor(1);
        autor.setNombre("Tiago");
        autor.setApellido("Silva");
        autor.setPais("Brasil");
        autor.setDireccion("Rio de Janeiro");
        autor.setTelefono("0964281752");
        autor.setCorreo("tsilva@gmail.com");

        Autor autorGuardado = autorRepository.save(autor);

        autorRepository.save(autor);

    }

    @Test
    public void update(){
        int autorId = 1;
        int categoriaId= 1;

        Optional<Autor> autorExistente = autorRepository.findById(autorId);
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(categoriaId);


        assertTrue(autorExistente.isPresent(),"Autor no encontrado para el id: "+autorId);
        assertTrue(categoriaExistente.isPresent(),"Categoria no encontrada para el id: "+categoriaId);

        Autor autorExistente1 = autorExistente.get();
        Categoria categoria1 = categoriaExistente.get();

        autorExistente1.setIdAutor(1);
        autorExistente1.setNombre("Roberto");
        autorExistente1.setApellido("Villa");
        autorExistente1.setPais("Ecuador");
        autorExistente1.setDireccion("Quito");
        autorExistente1.setTelefono("0932816732");
        autorExistente1.setCorreo("rvilla@gmail.com");

        Autor autorActualizado = autorRepository.save(autorExistente1);
        assertEquals("Roberto", autorActualizado.getNombre());
        System.out.println("Autor actualizado"+autorActualizado);

    }

    @Test
    public void delete(){
        if (autorRepository.existsById(1)){
            autorRepository.deleteById(1);

            Optional<Autor> autorEliminado = autorRepository.findById(1);
            assertFalse(autorEliminado.isPresent());

        }
    }





}
