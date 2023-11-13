package org.example.ejercicio1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;
import org.example.FicherosDeIntercambio.Entities.Lenguaje2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaFemenina {
    private String nombre;
    private String deporte;
    private int edad;
    private String pais;
    public static void escribirListaObjetosJson(List<DeportistaFemenina> deportistaFemeninas, Path ruta) {
        try {
            Files.deleteIfExists(ruta);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ruta.toFile(), deportistaFemeninas);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }
}
