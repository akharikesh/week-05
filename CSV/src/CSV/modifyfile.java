package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class modifyfile {

    public static void main(String[] args) {
        String inputFile = "C:\\Hari\\sample 2 - Sheet1.csv\\";
        String outputFile = "C:\\Hari\\sample 3 - Sheet1.csv\\";
        String line;
        String delimiter = ",";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            // Read and write the header
            String header = br.readLine();
            writer.write(header + "\n");

            while ((line = br.readLine()) != null) {
                String[] emp = line.split(delimiter);

                if (emp.length == 4) {
                    String department = emp[2].trim();
                    double salary = Double.parseDouble(emp[3].trim());

                    if (department.equalsIgnoreCase("IT")) {
                        salary *= 1.10; 
                        emp[3] = String.format("%.2f", salary);
                    }

                    writer.write(String.join(",", emp) + "\n");
                }
            }

            System.out.println("Updated file written to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}

