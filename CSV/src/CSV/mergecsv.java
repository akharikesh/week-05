package CSV;

import java.io.*;
import java.util.*;

public class mergecsv {

    public static void main(String[] args) {
        String file1 = "";  
        String file2 = "";  
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentDetails = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine(); 
            String line;
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    studentDetails.put(data[0].trim(), new String[] {data[1].trim(), data[2].trim()});
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file1 + ": " + e.getMessage());
        }

        try (
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            writer.write("ID,Name,Age,Marks,Grade\n"); 
            br2.readLine(); 
            String line;
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String id = data[0].trim();
                    String marks = data[1].trim();
                    String grade = data[2].trim();

                    String[] nameAge = studentDetails.get(id);
                    if (nameAge != null) {
                        writer.write(String.format("%s,%s,%s,%s,%s\n", id, nameAge[0], nameAge[1], marks, grade));
                    }
                }
            }
            System.out.println("Merged data written to: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error merging files: " + e.getMessage());
        }
    }
}

