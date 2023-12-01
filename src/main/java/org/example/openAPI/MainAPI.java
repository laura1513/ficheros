package org.example.openAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainAPI {
    public static List<Players> playersList;
    static ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public static void main(String[] args) throws IOException {
        //https://www.balldontlie.io/api/v1/players
        //Guardar información en JsonNode
        //Gastar ObjectMapper en clase ReadTree
        Path path = Path.of("src", "main", "java", "org", "example", "openAPI", "baloncesto.json");
        JsonNode jsonNode =  objectMapper.readTree(new URL("https://www.balldontlie.io/api/v1/players"));
        //playersList = objectMapper.readValue(jsonNode.)
    }
    public void listarJSON(URL url, Path path) throws IOException {
        Files.deleteIfExists(path);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //objectMapper.writeValue(path.toFile());
    }
}
