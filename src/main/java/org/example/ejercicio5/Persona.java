package org.example.ejercicio5;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Persona {
    private String nombre;
    private String apellidos;
    private int dni;
}
