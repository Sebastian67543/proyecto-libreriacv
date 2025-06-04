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

        for (Factura item: facturas){
            System.out.println(item.toString());
        }

    }

    @Test
    public void findOne(){
        Optional<Factura> factura = facturaRepository.findById(1);

        System.out.println(factura.toString());

    }

    @Test
    public void save(){
        Factura factura = new Factura();

        Optional<Cliente> cliente = clienteRepository.findById(1);

        factura.setIdFactura(0);
        factura.setNumFactura("FAC-0099");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);
        factura.setCliente(cliente.orElse(null));

        facturaRepository.save(factura);
    }

    @Test
    public void update(){
        Optional<Factura> facturaExistente = facturaRepository.findById(86);

        Optional<Cliente> cliente = clienteRepository.findById(2);

        facturaExistente.orElse(null).setNumFactura("FAC-0100");
        facturaExistente.orElse(null).setFecha(new Date());
        facturaExistente.orElse(null).setTotalNeto(200.00);
        facturaExistente.orElse(null).setIva(30.00);
        facturaExistente.orElse(null).setTotal(230.00);
        facturaExistente.orElse(null).setCliente(cliente.orElse(null));

        facturaRepository.save(facturaExistente.orElse(null));

    }

    @Test
    public void delete(){
        if (facturaRepository.existsById(86)){
            facturaRepository.deleteById(86);
        }
    }


}
