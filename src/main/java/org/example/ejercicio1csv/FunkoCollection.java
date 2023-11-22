package org.example.ejercicio1csv;

import java.util.*;
import java.util.stream.Collectors;

public class FunkoCollection {
    private final List<Funko> funkos;
    public FunkoCollection(Funko[] funkos) {
        this.funkos = Arrays.asList(funkos);
    }
    public FunkoCollection() {
        this.funkos = new ArrayList<>();
    }
    public String funkoMasCaro(List<Funko> lista) {
        String nom = lista.stream().max(Comparator.comparingDouble(Funko::getPrecio)).get().getNombre();
        return nom;
    }
    public double mediaDePrecios(List<Funko> lista) {
        return lista.stream().mapToDouble(Funko::getPrecio).average().getAsDouble();
    }
    public Map<String, List<Funko>> listaPorModelo(List<Funko> lista) {
        return (lista.stream().collect(Collectors.groupingBy(Funko::getModelo)));
    }

    public Map<String, Long> numPorModelo(List<Funko> lista) {
        return (lista.stream().collect(Collectors.groupingBy(Funko::getModelo, Collectors.counting())));
    }
    public List<Funko> funkosSacadosEn2023(List<Funko> lista) {
        return (lista.stream().filter(f -> f.getFecha_lanzamiento().getYear() == 2023).toList());
    }
    public void backupFunko(List<Funko> lista) {
        Funko.backup(lista, "backup.dat");
        List<Funko> backupFunko = Funko.restore("backup.dat");
        for (Funko f : backupFunko) {
            System.out.println(f);
        }
    }
}
