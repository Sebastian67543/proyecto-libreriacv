package com.distribuida.service;

import com.distribuida.dao.CarritoItemRepository;
import com.distribuida.dao.CarritoRepository;
import com.distribuida.dao.ClienteRepository;
import com.distribuida.dao.LibroRepository;
import com.distribuida.model.Carrito;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CarritoServiceImpl implements CarritoService{


    private final CarritoRepository carritoRepository;
    private final CarritoItemRepository carritoItemRepository;
    private final ClienteRepository clienteRepository;
    private final LibroRepository libroRepository;

    private static final BigDecimal IVA = new BigDecimal("0.15");

    public CarritoServiceImpl(CarritoRepository carritoRepository
                              ,CarritoItemRepository carritoItemRepository
                              ,ClienteRepository clienteRepository
                              ,LibroRepository libroRepository
    ){

        this.carritoRepository = carritoRepository;
        this.carritoItemRepository = carritoItemRepository;
        this.clienteRepository = clienteRepository;
        this.libroRepository = libroRepository;
    }


    @Override
    public Carrito getOrCreateByClienteId(int clienteId, String token) {
        return null;
    }

    @Override
    public Carrito addItem(int clienteId, int libroId, int cantidad) {
        return null;
    }

    @Override
    public Carrito updateItemCantidad(int clienteId, long carritoItemid, int nuevaCantidad) {
        return null;
    }

    @Override
    public void removeItem(int clienteId, long carritoItemId) {

    }

    @Override
    public void clear(int clienteId) {

    }

    @Override
    public Carrito getByClienteId(int clienteId) {
        return null;
    }

    @Override
    public Carrito getOrCreateByClienteId(String token) {
        return null;
    }

    @Override
    public Carrito addItem(String token, int libroId, int cantidad) {
        return null;
    }

    @Override
    public Carrito updateItemCantidad(String token, long carritoItemid, int nuevaCantidad) {
        return null;
    }

    @Override
    public void removeItem(String token, long carritoItemId) {

    }

    @Override
    public void clear(String token) {

    }

    @Override
    public Carrito getByClienteId(String token) {
        return null;
    }
}
