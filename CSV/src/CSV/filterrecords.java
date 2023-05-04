package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class filterrecords {

    public static void main(String[] args) {
        String csvFile = "C:\\Hari\\day.csv\\";  
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header
            br.readLine();

            System.out.println("Students scoring more than 80 marks:");
            System.out.println("-------------------------------------");

            while ((line = br.readLine()) != null) {
                String[] student = line.split(delimiter);

                if (student.length >= 4) {
                    int marks = Integer.parseInt(student[3].trim());

                    if (marks > 80) {
                        String id = student[0].trim();
                        String name = student[1].trim();
                        String age = student[2].trim();
                        System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %d%n", id, name, age, marks);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

