package org.example.ejercicio1csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public final static String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws IOException {
        String[] funk;
        List<Funko> lista = new ArrayList<Funko>();
        Path fichero =  Path.of("src/main/java/org/example/ejercicio1csv/funkos.csv");
        try {
            List<String> linea = Files.readAllLines(fichero);
            System.out.println("Todos los funkos:");
            for (int i = 1; i < linea.size(); i++) {
                Funko funko = new Funko();
                funk = linea.get(i).split(COMMA_DELIMITER);
                funko.setCod(funk[0]);
                funko.setNombre(funk[1]);
                funko.setModelo(funk[2]);
                funko.setPrecio(Double.parseDouble(funk[3]));
                funko.setFecha_lanzamiento(LocalDate.parse(funk[4]));
                lista.add(funko);
                System.out.println(lista);
            }
            System.out.println();

            System.out.print("Funko más caro: ");
            String nom = lista.stream().max(Comparator.comparingDouble(Funko::getPrecio)).get().getNombre();
            Double pre = lista.stream().max(Comparator.comparingDouble(Funko::getPrecio)).get().getPrecio();
            System.out.println("El funko más caro es " + nom + " y cuesta " + pre + "€");
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
