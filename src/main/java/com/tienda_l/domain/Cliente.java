
package com.tienda_l.domain;

import jakarta.persistence.*;//asterisco*
import java.io.Serializable;//persistencia en objetos
import lombok.Data;

@Data//genera get, set equals ...
@Entity //va mapiar una tabla de la base de datos
@Table(name="cliente")

public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id //el atributo que sigue es linea primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//vuando genere un valor use el que genera en base de datos
    private Long idCliente;
   
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
