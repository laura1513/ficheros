package org.example.ejercicio5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ObjectMapperEj {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static void main(String[] args) {
        try {
            Path ficheropersona = Path.of("src", "main", "java", "org", "example","ejercicio5", "persona.json");
            ArrayList<Persona> personas = JSON_MAPPER.readValue(ficheropersona.toFile(), new TypeReference<>(){});
            personas.forEach(System.out::println);

        } catch (IOException ex) {

        }

    }
}
