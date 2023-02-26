package com.tienda_l.service.impl;

import com.tienda_l.dao.ClienteDao;
import com.tienda_l.domain.Cliente;
import com.tienda_l.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService { //importa cliente service y metos abstractos
    
    @Autowired//importar
    private ClienteDao clienteDao;//importar

    @Override
    public List<Cliente> getClientes() {
        return clienteDao.findAll();//devuelve todos los clientes
    }
    
}
