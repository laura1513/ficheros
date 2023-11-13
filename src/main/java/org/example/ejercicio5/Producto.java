package org.example.ejercicio5;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Producto {
    private String nombre;
    private String modelo;
    private int precio;
    private float valoracion;
}
