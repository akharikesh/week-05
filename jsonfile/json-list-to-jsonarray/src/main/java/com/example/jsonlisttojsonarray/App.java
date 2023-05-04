package com.example.jsonlisttojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30));
        users.add(new User("Bob", 25));

        ObjectMapper mapper = new ObjectMapper();

        String jsonArray = mapper.writeValueAsString(users);

        System.out.println(jsonArray);
    }
}

