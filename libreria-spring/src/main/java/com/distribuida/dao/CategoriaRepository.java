package com.distribuida.dao;

import com.distribuida.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository // el @Repository es opcional ya que JpaRepository ya lo maneja internamente
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    // Método personalizado para buscar por nombre de categoría
    Categoria findByCategoria(String categoria);
}

