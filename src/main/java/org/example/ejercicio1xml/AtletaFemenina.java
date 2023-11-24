package org.example.ejercicio1xml;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JacksonXmlRootElement(localName = "atleta_femenina")
public class AtletaFemenina {

    @JacksonXmlProperty(isAttribute = true)
    private String nombre;
    private int edad;
    private String pais;
    @JacksonXmlElementWrapper(localName = "pruebas")
    @JacksonXmlProperty(localName = "prueba")
    private List<String> prueba;
}
