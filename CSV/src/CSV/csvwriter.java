package CSV;

import java.io.FileWriter;
import java.io.IOException;

public class csvwriter {

    public static void main(String[] args) {
        String filePath = "C:\\Hari\\sample 2 - Sheet1.csv\\";

        // Sample data
        String[] employees = {
            "101,John Doe,HR,50000",
            "102,Jane Smith,Finance,60000",
            "103,Bob Johnson,IT,70000",
            "104,Alice Brown,Marketing,55000",
            "105,David Lee,Operations,58000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID,Name,Department,Salary\n"); // Header

            for (String emp : employees) {
                writer.write(emp + "\n");
            }

            System.out.println("Data written to " + filePath + " successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
