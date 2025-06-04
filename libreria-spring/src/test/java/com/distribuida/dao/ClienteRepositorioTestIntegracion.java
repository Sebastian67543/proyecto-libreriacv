package com.distribuida.dao;

import com.distribuida.model.Cliente;
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
public class ClienteRepositorioTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;


    @Test
    public void findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() > 0);

        for(Cliente item : clientes){
            System.out.println(item.toString());
        }
    }


    @Test
    public void findOne(){
        Optional<Cliente> cliente = clienteRepository.findById(1);
        assertTrue(cliente.isPresent(), "El cliente con id = 1, deberia existir");
        System.out.println(cliente.toString());
    }

    @Test
    public void save(){
        Cliente cliente = new Cliente(0, "1753848215", "Juan","Taipe","av.los conquistadores","0979332474","juanraipe@.com");
        clienteRepository.save(cliente);
        assertNotNull(cliente.getIdCliente(), "El cliente guardado debe tener un id.");
        assertEquals("1753848215",cliente.getCedula());
        assertEquals("Juan",cliente.getNombre());
    }

    @Test
    public void update(){
        Optional<Cliente> cliente = clienteRepository.findById(40);

        assertTrue(cliente.isPresent(), "El cliente con id = 40, deberia existir, para ser actualizado");

        cliente.orElse(null).setCedula("5555554254");
        cliente.orElse(null).setNombre("Juanito");
        cliente.orElse(null).setApellido("Perez");
        cliente.orElse(null).setDireccion("Panama");
        cliente.orElse(null).setTelefono("0979332564");
        cliente.orElse(null).setCorreo("sacomrte@.com");

        Cliente clienteactualizado = clienteRepository.save(cliente.orElse(null));

        assertEquals("Juanito",clienteactualizado.getNombre());
        assertEquals("Perez",clienteactualizado.getApellido());
    }

    @Test
    public void delete(){
        if (clienteRepository.existsById(39)){
            clienteRepository.deleteById(39);
        }
        assertFalse(clienteRepository.existsById(39), "el id 39, deberia haberse eliminado");
    }
}
