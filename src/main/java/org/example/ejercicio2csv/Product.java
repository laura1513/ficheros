package org.example.ejercicio2csv;

import lombok.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private int supplier;
    private int category;
    private double unitPrice;
    private int unitsInStock;

    public void writeFile(String nomfich) {
        Path ruta = Path.of(nomfich);

        String coma = ",";
        String producto = this.getId() + coma +
                this.getName() + coma +
                this.getSupplier() + coma +
                this.getCategory() + coma + coma +
                this.getUnitPrice() + coma +
                this.getUnitsInStock() + coma + coma + coma;

        try {
            if (Files.exists(ruta)){
                Files.writeString(ruta, "\n" + producto, APPEND);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeFileEj6(String nomfich) {
        String coma = ",";
        String producto = this.getId() + coma +
                this.getName() + coma +
                this.getSupplier() + coma +
                this.getCategory() + coma + coma +
                this.getUnitPrice() + coma +
                this.getUnitsInStock() + coma + coma + coma;

        try (RandomAccessFile raf = new RandomAccessFile(nomfich, "rws")) {
            String nombre = this.getName();
            String linea;
            long pos = 0;
            boolean encontrado = false;

            linea = raf.readLine(); // leemos la primera línea
            if (linea != null) linea = raf.readLine(); // y si no es final de fichero, la primera se descarta

            while (linea != null && !encontrado) { // mientras no lleguemos a final de fichero y no se haya encontrado
                String[] partesProducto = linea.split(","); // separamos los campos de la línea
                if (partesProducto[1].equals(nombre)) { // si el nombre del producto coincide con el leído
                    raf.seek(pos); // nos posicionamos al principio de la línea actual
                    raf.writeBytes(producto); // sobreescribimos la línea completa
                    encontrado = true; // no se requiere buscar más
                }
                pos = raf.getFilePointer(); // posición de la línea a leer
                linea = raf.readLine(); // lectura de la nueva línea
            }

            if (!encontrado) {
                raf.seek(raf.length());
                raf.writeBytes(producto);
                raf.writeBytes("\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public int compareTo(Product p) {
        if (this.getUnitsInStock() < p.getUnitsInStock())
            return -1;
        else if (this.getUnitsInStock() > p.getUnitsInStock())
            return 1;
        else
            return 0;
    }
}

