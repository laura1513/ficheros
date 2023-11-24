package org.example.ejercicio1xml;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListaPruebas {
    private List<AtletaFemenina> atleta;
    public void setPruebas(List<AtletaFemenina> atleta) {
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        return "ListaPruebas{" +
                "atleta=" + atleta +
                '}';
    }
}
