package com.distribuida.service;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//aqui se gestiona la logica de negocio

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired //inyeccion de dependencias
    private ClienteRepository clienteRepository;



    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(int id) {
        return null;
    }

    @Override
    public Cliente findOne(int id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(int id, Cliente clienteNuevo) {
        Cliente clienteExistente = findOne(id);

        if(clienteExistente == null){
            return null;
        }

        clienteExistente.setCedula(clienteNuevo.getCedula ());
        clienteExistente.setNombre(clienteNuevo.getNombre());
        clienteExistente.setApellido(clienteNuevo.getApellido());
        clienteExistente.setDireccion(clienteNuevo.getDireccion());
        clienteExistente.setTelefono(clienteNuevo.getTelefono());
        clienteExistente.setCorreo(clienteNuevo.getCorreo());

        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void delete(int id) {
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }

    }
}
