package org.example.ejercicio1json;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "libro")
public class BookJSON {
    private String isbn;
    private String titulo;
    private String autor;
    private int paginas;
    private int anyo_publicacion;
}
