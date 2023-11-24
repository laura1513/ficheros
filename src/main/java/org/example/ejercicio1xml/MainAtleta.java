package org.example.ejercicio1xml;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainAtleta {
    public static void main(String[] args) throws IOException {
        Path fichero = Path.of("src","main","java","org","example","ejercicio1xml", "atletaFemenina.xml");
        Files.createFile(fichero);
        AtletaFemenina a = new AtletaFemenina("Maria", 21, "España", List.of("100 metros", "Salto de altura", "Salto con pertiga"));
        AtletaFemenina b = new AtletaFemenina("Lucia", 30, "Francia", List.of("100 metros", "Carrer de relevos", "Salto de longitud"));
        List<AtletaFemenina> lista = List.of(a, b);

        ListaPruebas listaPruebas = new ListaPruebas(lista);

        escribirAtleta(listaPruebas, fichero);
        System.out.println(escribirListaObjetosXml(listaPruebas));
    }
    public static void escribirAtleta(ListaPruebas pruebas, Path ruta) {

        try {
            Files.deleteIfExists(ruta);
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ruta.toFile(), pruebas);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }
    public static String escribirListaObjetosXml(ListaPruebas atleta) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return xmlMapper.writeValueAsString(atleta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
