package com.example.dbjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbToJsonReport {

    public static class User {
        private int id;
        private String name;
        private int age;

        public User(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
    }

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String username = "sa";
        String password = "";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE users(id INT PRIMARY KEY, name VARCHAR(255), age INT)");
            stmt.execute("INSERT INTO users VALUES (1, 'Alice', 30), (2, 'Bob', 22), (3, 'Charlie', 28)");

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
            }

            ObjectMapper mapper = new ObjectMapper();
            String jsonReport = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);

            System.out.println("JSON Report:\n" + jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
