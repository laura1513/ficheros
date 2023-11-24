package org.example.ejercicio1csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainFunko {
    public final static String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws IOException {
        FunkoCollection funkoCollection = new FunkoCollection();
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

            System.out.println("El funko más caro es " + funkoCollection.funkoMasCaro(lista));


            System.out.print("Media de precio: ");
            System.out.println(funkoCollection.mediaDePrecios(lista) + "€");

            System.out.println("Funkos por modelo:");
            for (Map.Entry<String, List<Funko>> p : funkoCollection.listaPorModelo(lista).entrySet()) {
                System.out.println(p);
            }

            System.out.println("Numero de funkos por modelo:");
            System.out.println(funkoCollection.numPorModelo(lista));

            System.out.println("Funkos scados en 2023:");
            for (Funko f: funkoCollection.funkosSacadosEn2023(lista)) {
                System.out.println(f);
            }

            System.out.println("BACKUP:");
            funkoCollection.backupFunko(lista);

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
