package org.example.ejercicio1json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainJSON {
    public static List<BookJSON> lista = new ArrayList<>();
    public static Path fichero = Path.of("src","main","java","org","example","ejercicio1json", "books.json");
    static boolean ok = false;
    public static void main(String[] args) {


        BookJSON potter = new BookJSON("123-456","Harry Potter y la piedra filosofal", "J. K. Rowling",400, 1997);
        BookJSON hambre = new BookJSON("987-654", "Los Juegos del Hambre", "Suzanne Collins", 600, 2008);
        lista.add(potter);
        lista.add(hambre);

        ListaBook listaBook = new ListaBook(lista);

        escribirListaObjetosJson(lista, fichero);

        Scanner read = new Scanner(System.in);
        int op;
        do {
            System.out.println("~~MENÚ~~\n" +
                    "1. Agregar nuevos libros\n" +
                    "2. Buscar libros\n" +
                    "3. Ver todos los libros\n" +
                    "4. Salir");
            System.out.print("Introduce una opción: ");
            op = read.nextInt();
            read.nextLine();
            if (op == 1) {
                anyadirLibros();
            } else if (op == 2) {
                buscarLibro();
            } else if (op == 3) {
                todosLosLibros();
            } else if (op == 4) {
                System.out.println("Has salido");
            } else {
                System.out.println("Opción no válida");
            }
        } while (op != 4);
    }
    public static void escribirListaObjetosJson(List<BookJSON> books, Path ruta) {
        try {
            Files.deleteIfExists(ruta);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ruta.toFile(), books);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    public static void anyadirLibros() {
        Scanner read = new Scanner(System.in);
        System.out.print("ISBN: ");
        String isbn = read.nextLine();

        System.out.print("Título: ");
        String titulo = read.nextLine();

        System.out.print("Autor: ");
        String autor = read.nextLine();

        System.out.print("Paginas: ");
        int paginas = read.nextInt();

        System.out.print("Año de publicación: ");
        int anyo = read.nextInt();
        read.nextLine();

        BookJSON newBook = new BookJSON(isbn, titulo, autor, paginas, anyo);
        System.out.println(newBook.getTitulo());
        lista.add(newBook);
        escribirListaObjetosJson(lista, fichero);
        System.out.println("Libro añadido correctamente");
    }

    public static void buscarLibro() {
        Scanner read = new Scanner(System.in);
        String busqueda;

        System.out.print("Introduce que quieres buscar: ");
        busqueda = read.nextLine().toLowerCase();

        lista.stream().filter(l -> l.getTitulo().toLowerCase().contains(busqueda) || l.getAutor().toLowerCase().contains(busqueda)).forEach(l->{
            System.out.println(l.toString());
            ok = true;
        });

        if (!ok) {
            System.out.println("No se ha encontrado el libro");
        }
    }

    private static void todosLosLibros() {
    System.out.println("Lista de todos los libros:");
    for (BookJSON l : lista) {
        System.out.println(l.toString());
    }
    }
}
