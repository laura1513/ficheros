package org.example.ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;
import org.example.ejercicio1.DeportistaFemenina;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    private String titulo;
    private String autor;
    private int anyoPublicacion;
    private int isbn;
    public static void escribirLibros(List<Libro> libros, Path ruta) {
        try {
            Files.deleteIfExists(ruta);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ruta.toFile(), libros);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }
}
