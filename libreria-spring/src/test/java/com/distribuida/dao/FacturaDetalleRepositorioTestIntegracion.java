package com.distribuida.dao;

import com.distribuida.model.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false) // Para que persista y puedas ver cambios si lo necesitas
public class FacturaDetalleRepositorioTestIntegracion {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void findAll() {
        List<Factura> facturas = facturaRepository.findAll();
        assertNotNull(facturas);
        for (Factura item: facturas){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne() {
        Optional<Factura> factura = facturaRepository.findById(1);

        assertTrue(factura.isPresent());

        System.out.println(factura.toString());
    }

    @Test
    public void save() {
        Factura factura = new Factura();

        Optional<Cliente> cliente = clienteRepository.findById(1);

        assertTrue(cliente.isPresent());
        factura.setIdFactura(0);
        factura.setNumFactura("FAC-0002");
        factura.setFecha(new Date());
        factura.setTotalNeto(120.00);
        factura.setIva(10.00);
        factura.setTotal(130.00);
        factura.setCliente(cliente.orElse(null));

        Factura facturaGuardada = facturaRepository.save(factura);

        facturaRepository.save(factura);

    }

    @Test
    public void update() {
        int facturaId = 87;
        int clienteId = 1;

        Optional<Factura> facturaExistente = facturaRepository.findById(facturaId);
        Optional<Cliente> clienteExistente = clienteRepository.findById(clienteId);

        assertTrue(facturaExistente.isPresent(),"Factura no encontrada para el id: "+facturaId);
        assertTrue(clienteExistente.isPresent(),"Cliente no encontrado para el id: "+clienteId);

        Factura facturaExistente1 = facturaExistente.get();
        Cliente cliente = clienteExistente.get();

        facturaExistente1.setNumFactura("FAC-0150");
        facturaExistente1.setFecha(new Date());
        facturaExistente1.setTotalNeto(320.00);
        facturaExistente1.setIva(15.00);
        facturaExistente1.setTotal(325.00);
        facturaExistente1.setCliente(cliente);

        Factura facturaActualizada = facturaRepository.save(facturaExistente1);

        assertEquals(325.00, facturaActualizada.getTotal(),0.01);
        System.out.println("Factura Actualizada: "+facturaActualizada);

    }

    @Test
    public void delete() {
       if (facturaRepository.existsById(87)){
           facturaRepository.deleteById(87);

           Optional<Factura> facturaEliminada = facturaRepository.findById(87);
           assertFalse(facturaEliminada.isPresent());

       }
    }
}


