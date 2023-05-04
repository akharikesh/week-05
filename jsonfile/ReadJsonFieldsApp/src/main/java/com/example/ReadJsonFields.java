package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJsonFields {
    public static void main(String[] args) {
        try {
            // Load JSON file
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File("src/main/resources/user.json"));

            // Extract specific fields
            String name = root.get("name").asText();
            String email = root.get("email").asText();

            // Print them
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
