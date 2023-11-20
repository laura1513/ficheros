package org.example.ejercicio1csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public final static String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws IOException {
        String[] funk;
        List<Funko> lista = new ArrayList<Funko>();
        Path fichero =  Path.of("src/main/java/org/example/ejercicio1csv/funkos.csv");
        try {
            List<String> linea = Files.readAllLines(fichero);
            for (int i = 1; i < linea.size(); i++) {
                Funko funko = new Funko();
                funk = linea.get(i).split(COMMA_DELIMITER);
                funko.setCod(funk[0]);
                funko.setNombre(funk[1]);
                funko.setModelo(funk[2]);
                funko.setPrecio(Double.parseDouble(funk[3]));
                funko.setFecha_lanzamiento(LocalDate.parse(funk[4]));
                lista.add(funko);
            }

            System.out.print("El funko más caro es ");
            String nom = lista.stream().max(Comparator.comparingDouble(Funko::getPrecio)).get().getNombre();
            double pre = lista.stream().max(Comparator.comparingDouble(Funko::getPrecio)).get().getPrecio();
            System.out.println(nom + " y cuesta " + pre + "€");

            System.out.println();

            System.out.print("Media de precio: ");
            double media = lista.stream().mapToDouble(Funko::getPrecio).average().getAsDouble();
            System.out.println(media + "€");

            System.out.println();

            System.out.println("Funkos por modelo:");
            Map<String, List<Funko>> porModelo = lista.stream().collect(Collectors.groupingBy(Funko::getModelo));
            for (Map.Entry<String, List<Funko>> p : porModelo.entrySet()) {
                System.out.println(p);
            }

            System.out.println();

            System.out.println("Funkos por modelo:");
            Map<String, Long> numPorModelo = lista.stream().collect(Collectors.groupingBy(Funko::getModelo, Collectors.counting()));
            System.out.println(numPorModelo);

            System.out.println();

            System.out.println("Funkos scados en 2023:");
            List<Funko> funko2023 = lista.stream().filter(f -> f.getFecha_lanzamiento().getYear() == 2023).toList();
            for (Funko f: funko2023) {
                System.out.println(f);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
