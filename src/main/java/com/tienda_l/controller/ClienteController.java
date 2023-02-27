package com.tienda_l.controller;

import com.tienda_l.domain.Cliente;
import com.tienda_l.dao.ClienteDao;
import com.tienda_l.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@Controller //anotación sale error entonces se le da al bombillo rojo e importa lo de arriba
@Slf4j // no es tan necesario
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
     //metodo al ejecutar en local host
    @GetMapping("/")// (va a salir error , relax)\
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();//lista de la tabla y mete en clientes , muestra la informacion en pantalla
        model.addAttribute("clientes", clientes);//pasa del cliente el modelo de datos al index
        return "index";//devuelve index en local host
    }
    
    @GetMapping("/cliente/nuevo")// index <a th:href="@{/cliente/nuevo}">Nuevo Cliente</a>
    public String clienteNuevo(Cliente cliente) {
        return "modificaCliente";//devuelve la vista html
    }
    
    @PostMapping("/cliente/guardar")// html modificaCliente <a th:href="@{/cliente/nuevo}">Nuevo Cliente</a>
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente); //para guardar el registro
        return "redirect:/";//se devuelve al index
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")// index <td><a th:href="@{cliente/eliminar/} + ${cliente.idCliente}"> Eliminar </td>
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente); //elimina cliente
        return "redirect:/";//se devuelve al index
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")// index  <td><a th:href="@{cliente/modificar/} + ${cliente.idCliente}"> Modificar </td>
    public String clienteModificar(Cliente cliente, Model model){
        cliente=clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);//incluye un clientes con valores
        return "modificaCliente";//se devuelve a modificar 
    }
    
    
}
