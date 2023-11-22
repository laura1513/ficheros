package org.example.ejercicio1csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainFunko2 {
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
            funkoMasCaro(lista);

            System.out.print("Media de precio: ");
            System.out.println(mediaDePrecios(lista) + "€");

            System.out.println("Funkos por modelo:");
            for (Map.Entry<String, List<Funko>> p : listaPorModelo(lista).entrySet()) {
                System.out.println(p);
            }

            System.out.println("Funkos por modelo:");
            System.out.println(numPorModelo(lista));

            System.out.println("Funkos scados en 2023:");
            for (Funko f: funkosSacadosEn2023(lista)) {
                System.out.println(f);
            }

            System.out.println("BACKUP:");
            backupFunko(lista);

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void funkoMasCaro(List<Funko> lista) {
        String nom = lista.stream().max(Comparator.comparingDouble(Funko::getPrecio)).get().getNombre();
        double pre = lista.stream().max(Comparator.comparingDouble(Funko::getPrecio)).get().getPrecio();
        System.out.println(nom + " y cuesta " + pre + "€");
    }
    public static double mediaDePrecios(List<Funko> lista) {
        return lista.stream().mapToDouble(Funko::getPrecio).average().getAsDouble();
    }
    public static Map<String, List<Funko>> listaPorModelo(List<Funko> lista) {
        return (lista.stream().collect(Collectors.groupingBy(Funko::getModelo)));
    }

    public static Map<String, Long> numPorModelo(List<Funko> lista) {
        return (lista.stream().collect(Collectors.groupingBy(Funko::getModelo, Collectors.counting())));
    }
    public static List<Funko> funkosSacadosEn2023(List<Funko> lista) {
        return (lista.stream().filter(f -> f.getFecha_lanzamiento().getYear() == 2023).toList());
    }
    public static void backupFunko(List<Funko> lista) {
        Funko.backup(lista, "backup.dat");
        List<Funko> backupFunko = Funko.restore("backup.dat");
        for (Funko f : backupFunko) {
            System.out.println(f);
        }
    }
}
