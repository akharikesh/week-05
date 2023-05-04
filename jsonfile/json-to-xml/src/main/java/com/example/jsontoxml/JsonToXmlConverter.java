package com.example.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter {

    public static void main(String[] args) throws Exception {
        String json = """
            {
                "name": "Alice",
                "age": 30,
                "city": "New York"
            }
            """;

        // Create ObjectMapper to parse JSON
        ObjectMapper jsonMapper = new ObjectMapper();

        // Parse JSON string into JsonNode tree
        JsonNode jsonNode = jsonMapper.readTree(json);

        // Create XmlMapper to write XML
        XmlMapper xmlMapper = new XmlMapper();

        // Convert JsonNode to XML string
        String xml = xmlMapper.writeValueAsString(jsonNode);

        System.out.println(xml);
    }
}
