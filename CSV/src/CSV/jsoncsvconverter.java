package CSV;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.*;

public class jsoncsvconverter {

    private static final ObjectMapper mapper = new ObjectMapper();

    // ✅ Convert JSON → CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            List<Map<String, Object>> records = mapper.readValue(
                    new File(jsonFile),
                    new TypeReference<List<Map<String, Object>>>() {}
            );

            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));

            // Write headers
            Set<String> headers = records.get(0).keySet();
            writer.write(String.join(",", headers));
            writer.newLine();

            // Write rows
            for (Map<String, Object> record : records) {
                List<String> row = new ArrayList<>();
                for (String header : headers) {
                    row.add(record.get(header).toString());
                }
                writer.write(String.join(",", row));
                writer.newLine();
            }

            writer.close();
            System.out.println("✅ JSON to CSV conversion complete: " + csvFile);
        } catch (IOException e) {
            System.err.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }

    // ✅ Convert CSV → JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            List<ObjectNode> records = new ArrayList<>();
            String[] headers = reader.readLine().split(",");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                ObjectNode obj = mapper.createObjectNode();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                records.add(obj);
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), records);
            System.out.println("✅ CSV to JSON conversion complete: " + jsonFile);
        } catch (IOException e) {
            System.err.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }

    // ✅ Example main method
    public static void main(String[] args) {
        String jsonInput = "students.json";
        String csvOutput = "students.csv";
        String jsonOutput = "students_back.json";

        jsonToCsv(jsonInput, csvOutput);
        csvToJson(csvOutput, jsonOutput);
    }
}
