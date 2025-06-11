package com.distribuida.service;

import com.distribuida.dao.AutorRepository;
import com.distribuida.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Aquí se gestiona la lógica de negocio de Autor

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor findById(int id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public Autor findOne(int id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.orElse(null);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor update(int id, Autor autorNuevo) {
        Autor autorExistente = findOne(id);

        if (autorExistente == null) {
            return null;
        }

        autorExistente.setNombre(autorNuevo.getNombre());
        autorExistente.setApellido(autorNuevo.getApellido());
        autorExistente.setPais(autorNuevo.getPais());
        autorExistente.setDireccion(autorNuevo.getDireccion());
        autorExistente.setTelefono(autorNuevo.getTelefono());
        autorExistente.setCorreo(autorNuevo.getCorreo());

        return autorRepository.save(autorExistente);
    }

    @Override
    public void delete(int id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
        }
    }
}


