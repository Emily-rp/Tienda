
package com.tienda_l.service.impl;

import com.tienda_l.dao.ClienteDao;
import com.tienda_l.domain.Cliente;
import com.tienda_l.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired //debe haber un cliente dao sino se crea
    private ClienteDao clienteDao;
    
    @Override
    @Transactional(readOnly=true) //va a ir a leer la base de datos
    public List<Cliente> getClientes() { //implemetan los metodos desde el bombillo
        return (List<Cliente>) clienteDao.findAll(); //hace un selc de base de datos
    }

    @Override
    @Transactional(readOnly=true)//solo lectura
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);// busca cliente por id
    }

    @Override
    @Transactional// sin only porqeu si altera los datos
    public void save(Cliente cliente) {
         clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    
}
