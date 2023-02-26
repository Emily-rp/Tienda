
package com.tienda_l.domain;

import lombok.Data;

@Data//genera get, set equals ...

public class Cliente {
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    public Cliente() { //click derecho , insertar contructor (no marca nada)
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) { // aqui si se marcan todos
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
   
}
