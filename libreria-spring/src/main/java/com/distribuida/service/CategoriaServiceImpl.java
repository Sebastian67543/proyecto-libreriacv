package com.distribuida.service;

import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Aquí se gestiona la lógica de negocio de Categoría

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(int id) {
        // Alternativa si quieres evitar el uso de Optional en el controlador
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria findOne(int id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(int id, Categoria categoriaNueva) {
        Categoria categoriaExistente = findOne(id);

        if (categoriaExistente == null) {
            return null;
        }

        categoriaExistente.setCategoria(categoriaNueva.getCategoria());
        categoriaExistente.setDescripcion(categoriaNueva.getDescripcion());

        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public void delete(int id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        }
    }
}

