package org.example.ejercicio1json;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ListaBook {
    private List<BookJSON> books;

    public void setLenguajes(List<BookJSON> books) {
        this.books = books;
    }
}
