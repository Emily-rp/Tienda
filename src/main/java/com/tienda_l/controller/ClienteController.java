package com.tienda_l.controller;

import com.tienda_l.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //anotación sale error entonces se le da al bombillo rojo e importa lo de arriba
@Slf4j // no es tan necesario

public class ClienteController {
    
    //metodo al ejecutar en local host
    @GetMapping("/") //)(va a salir error , relax)\
    
    //nombre del metodo / devuelve un string
    public String inicio(Model model){ //clase(se importa) y objeto
        var saludo="Hola desde el BackEnd"; //variable
        model.addAttribute("variable", saludo);
        
        Cliente cliente1 = new Cliente("Juan",
                "Cervantes",
                "jcervante@gmail.com",
                "70675631"); //importo cliente
        
         Cliente cliente2 = new Cliente("Pedro",
                "Cervantes",
                "pcervante@gmail.com",
                "70342431"); //importo cliente
         
          Cliente cliente3 = new Cliente("Ana",
                "Cervantes",
                "acervante@gmail.com",
                "70672331"); //importo cliente
          
        var clientes=Arrays.asList(cliente1,cliente2,cliente3); //lo importa bolbillo, VARIABLE DE LISTA
          
        model.addAttribute("clientes",clientes);//pasa del cliente el modelo de datos al index
        
        
        
        
        return "index"; //devuelve index en local host
    }
    
    
}
