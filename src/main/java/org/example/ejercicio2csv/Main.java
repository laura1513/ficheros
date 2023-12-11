package org.example.ejercicio2csv;

import org.example.ejercicio1csv.Funko;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static final String COMMA_DELIMITER = ",";
    static List<Product> lista = new ArrayList<Product>();
    public static void main(String[] args) throws IOException {
        List<String> linea = Files.readAllLines(Path.of("src","main","resources", "fichero.csv"));
        String[] p;
        System.out.println("Todos los productos");
        for (int i = 1; i < linea.size(); i++) {
            Product producto = new Product();
            p = linea.get(i).split(COMMA_DELIMITER);
            producto.setId(Integer.parseInt(p[0]));
            producto.setName(p[1]);
            producto.setSupplier(Integer.parseInt(p[2]));
            producto.setCategory(Integer.parseInt(p[3]));
            producto.setUnitPrice(Double.parseDouble(p[5]));
            producto.setUnitsInStock(Integer.parseInt(p[6]));
            lista.add(producto);
            System.out.println(producto.toString());
        }

        System.out.println();

        System.out.println("Nombres de los productos:");
        lista.stream().map(Product::getName).forEach(System.out::println);

        System.out.println();

        System.out.println("Nombres de los productos cuyas unidades en stock sean menor que 10");
        lista.stream().filter(product -> product.getUnitsInStock() < 10).map(Product::getName).forEach(System.out::println);

        System.out.println();

        System.out.println("Nombre de los productos con unidades en stock mayor de 10 ordenados por unidad de stock de forma descendente");
        lista.stream().filter(product -> product.getUnitsInStock() > 10).sorted((p1, p2) -> p2.getUnitsInStock() - p1.getUnitsInStock()).map(Product::getName).forEach(System.out::println);

        System.out.println();

        System.out.println("Número de productos agrupados por proveedor");
        Map<Integer, Long> li = lista.stream().collect(Collectors.groupingBy(Product::getSupplier, Collectors.counting()));
        System.out.println(li);

        System.out.println();

        System.out.println("Producto con el precio unitario más alto");
        String name = lista.stream().max(Comparator.comparingDouble(Product::getUnitPrice)).get().getName();
        System.out.println(name);

        System.out.println();

        System.out.println("El promedio de existencias en almacén");
        double media = lista.stream().mapToDouble(Product::getUnitsInStock).average().getAsDouble();
        System.out.println(media);

    }
}
