package org.example.ejercicio1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejercicio5.Persona;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static void main(String[] args) {
        Path path = Path.of("src", "main", "java", "org", "example", "ejercicio1", "deportistas_femeninas.json");

        DeportistaFemenina carolina = new DeportistaFemenina("Carolina", "Badminton", 30, "España");
        DeportistaFemenina simone = new DeportistaFemenina("Simone", "Gimnasia", 26, "Estados Unidos");

        List<DeportistaFemenina> deportista = List.of(carolina, simone);

        try {
            DeportistaFemenina.escribirListaObjetosJson(deportista, path);
            ArrayList<DeportistaFemenina> d = JSON_MAPPER.readValue(path.toFile(), new TypeReference<>(){});
            d.forEach(System.out::println);
        } catch (Exception e) {

        }
    }
}
