package org.example.ejercicio1csv;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Funko {
    private String cod;
    private String nombre;
    private String modelo;
    private double precio;
    private LocalDate fecha_lanzamiento;
}
