package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class countrows {

    public static void main(String[] args) {
        String csvFile = "C:\\Hari\\sample 2 - Sheet1.csv\\"; 
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    rowCount++;
                }
            }

            System.out.println("Number of records (excluding header): " + rowCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

