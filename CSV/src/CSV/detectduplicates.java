package CSV;

import java.io.*;
import java.util.*;

public class detectduplicates {

    public static void main(String[] args) {
        String csvFile = ""; 
        String line;
        String delimiter = ",";

        Set<String> seenIds = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length < 1) continue;

                String id = data[0].trim();

                if (!seenIds.add(id)) {
                    if (duplicateIds.add(id)) {

                        duplicateRecords.add(line);
                    }
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

