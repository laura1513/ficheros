package org.example.openAPI;

import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainAPI {
    public static void main(String[] args) {
        //https://pokeapi.co/api/v2/
        //Guardar información en JsonNode
        //Gastar ObjectMapper en clase ReactTree
        try {
            URL url=new URL("https://pokeapi.co/api/v2/pokemon/");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void listarJSON(URL url) throws IOException {

    }
}
