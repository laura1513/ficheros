package org.example.ejercicio2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static void main(String[] args) {
        Path path = Path.of("src", "main", "java", "org", "example", "ejercicio2", "libros.json");

        Libro potter = new Libro("Harry Potter y la piedra filosofal", "J. K. Rowling", 1997, 12);
        Libro hambre = new Libro("Los Juegos del Hambre", "Suzanne Collins", 2008, 80);

        List<Libro> libros = List.of(potter, hambre);

        try {
            Libro.escribirLibros(libros, path);
            ArrayList<Libro> l = JSON_MAPPER.readValue(path.toFile(), new TypeReference<>(){});
            l.forEach(System.out::println);
        } catch (Exception e) {

        }
    }
}
