package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) {
        try {
            Car car = new Car("Tesla", "Model S", 2024);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
            System.out.println("Car as JSON:");
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
