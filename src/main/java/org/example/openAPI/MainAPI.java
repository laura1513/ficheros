package org.example.openAPI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainAPI {
    public static List<Players> playersList;
    static ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public static void main(String[] args) throws IOException {
        //https://www.balldontlie.io/api/v1/players
        Scanner read = new Scanner(System.in);
        Path path = Path.of("src", "main", "java", "org", "example", "openAPI", "baloncesto.json");
        JsonNode jsonNode =  objectMapper.readTree(new URL("https://www.balldontlie.io/api/v1/players"));
        playersList = objectMapper.readValue(jsonNode.get("data").traverse(), new TypeReference<>(){});
        //playersList.forEach(System.out::println);
        listarJSON(playersList, path);
        System.out.println("Jugadres del equipo con abreviación OKC");
        listarOklahoma(playersList);
        System.out.print("Introduce el id del jugador: ");
        int n = read.nextInt();
        buscarid(playersList, n);
    }
    public static void listarJSON(List<Players> players, Path path) throws IOException {
        Files.deleteIfExists(path);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(path.toFile(), players);
    }

    public static void listarOklahoma(List<Players> players) {
        players.stream().filter(p -> Objects.equals(p.getTeam().getAbbreviation(), "OKC")).forEach(System.out::println);
    }
    public static void buscarid(List<Players> lista, int id) {
        for (Players p:lista) {
            if (p.getId() == id) {
                System.out.println(p);
            }
        }
    }
}
