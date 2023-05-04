package com.example.jsonfilter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

    public static class User {
        private String name;
        private int age;

        public User() {}

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        @Override
        public String toString() {
            return "User{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25},{\"name\":\"Charlie\",\"age\":28}]";

        ObjectMapper mapper = new ObjectMapper();

        List<User> users = mapper.readValue(json, new TypeReference<List<User>>() {});

        List<User> filtered = users.stream()
                                   .filter(user -> user.getAge() > 25)
                                   .collect(Collectors.toList());

        filtered.forEach(System.out::println);
    }
}
