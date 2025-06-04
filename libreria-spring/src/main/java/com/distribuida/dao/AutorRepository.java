package com.distribuida.dao;

import com.distribuida.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository // opcional, ya que JpaRepository lo gestiona internamente
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    // Método personalizado para buscar autor por nombre
    Autor findByNombre(String nombre);

    // También podrías agregar otros métodos útiles como:
    Autor findByCorreo(String correo);
    Autor findByApellido(String apellido);
}

