package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readlargecsv {

    public static void main(String[] args) {
        String csvFile = ""; 
        int chunkSize = 100;
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = br.readLine(); 
            if (line == null) {
                System.out.println("Empty file.");
                return;
            }

            String[] chunk = new String[chunkSize];
            int index = 0;

            while ((line = br.readLine()) != null) {
                chunk[index++] = line;

                if (index == chunkSize) {
                    processChunk(chunk, index);
                    totalRecords += index;
                    System.out.println("Processed records: " + totalRecords);
                    index = 0; 
                }
            }

            if (index > 0) {
                processChunk(chunk, index);
                totalRecords += index;
                System.out.println("Processed records: " + totalRecords);
            }

        } catch (IOException e) {
        	System.out.println("Error reading file: " + e.getMessage());
        }
    }


    private static void processChunk(String[] lines, int count) {
        for (int i = 0; i < count; i++) {
            
        }
    }
}
        

