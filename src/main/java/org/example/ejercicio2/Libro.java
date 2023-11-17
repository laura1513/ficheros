package org.example.ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;
import org.example.ejercicio1.DeportistaFemenina;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static void buscarLibros (List<Libro> libros) {
        Scanner read = new Scanner(System.in);
        System.out.println("Introduce titulo o autor");
        String l = read.nextLine();

        List<Libro> res = new ArrayList<>();

        for (Libro lib : libros) {
            if (lib.getTitulo().toLowerCase().contains(l.toLowerCase()) || lib.getAutor().toLowerCase().contains(l.toLowerCase())) {
                res.add(lib);
            }
        }
        if (res.isEmpty()) {
            System.out.println("No se han encontrado libros");
        } else {
            System.out.println("Se han encontrado los siguientes libros:");
            for (Libro r : res) {
                System.out.println(r);
            }
        }
    }
}
