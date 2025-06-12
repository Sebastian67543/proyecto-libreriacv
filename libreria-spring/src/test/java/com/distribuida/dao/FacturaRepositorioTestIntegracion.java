package com.distribuida.dao;


import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
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
@Rollback(value = false)
public class FacturaRepositorioTestIntegracion {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void findAll(){
        List<Factura> facturas = facturaRepository.findAll();
        assertNotNull(facturas);
        for (Factura item: facturas){
            System.out.println(item.toString());
        }

    }

    @Test
    public void findOne(){
        Optional<Factura> factura = facturaRepository.findById(1);

        assertTrue(factura.isPresent());

        System.out.println(factura.toString());

    }

    @Test
    public void save(){
        Factura factura = new Factura();

        Optional<Cliente> cliente = clienteRepository.findById(1);

        assertTrue(cliente.isPresent());

        factura.setIdFactura(0);
        factura.setNumFactura("FAC-0099");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);
        factura.setCliente(cliente.orElse(null));

        Factura facturaGuardada = facturaRepository.save(factura);

        facturaRepository.save(factura);
    }

    @Test
    public void update(){
        int facturaId = 87;
        int clienteId = 1;

        Optional<Factura> facturaExistenteOpt = facturaRepository.findById(facturaId);
        Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);

        assertTrue(facturaExistenteOpt.isPresent(), "Factura no encontrada para el id: " + facturaId);
        assertTrue(clienteOpt.isPresent(), "Cliente no encontrado para el id: " + clienteId);

        Factura facturaExistente = facturaExistenteOpt.get();
        Cliente cliente = clienteOpt.get();

        facturaExistente.setNumFactura("FAC-0100");
        facturaExistente.setFecha(new Date());
        facturaExistente.setTotalNeto(200.00);
        facturaExistente.setIva(30.00);
        facturaExistente.setTotal(230.00);
        facturaExistente.setCliente(cliente);

        Factura facturaActualizada = facturaRepository.save(facturaExistente);

        assertEquals(230.00, facturaActualizada.getTotal(), 0.01);
        System.out.println("Factura actualizada: " + facturaActualizada);
    }


    @Test
    public void delete(){
        if (facturaRepository.existsById(86)){
            facturaRepository.deleteById(86);
            
            Optional<Factura> facturaEliminada = facturaRepository.findById(87);
            assertFalse(facturaEliminada.isPresent());
        }
    }


}
