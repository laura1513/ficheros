package org.example.ejercicio1csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Funko implements Serializable {
    private String cod;
    private String nombre;
    private String modelo;
    private double precio;
    private LocalDate fecha_lanzamiento;

    public static void backup(List<Funko> funkos, String file) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))){
            os.writeObject(funkos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Funko> restore(String file) {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
            return (List<Funko>) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }
}
