package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class searchrecord {

    public static void main(String[] args) {
        String csvFile = "C:\\Hari\\sample 2 - Sheet1.csv\\"; // Adjust path as needed
        String line;
        String delimiter = ",";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] emp = line.split(delimiter);

                if (emp.length >= 4) {
                    String name = emp[1].trim();

                    if (name.equalsIgnoreCase(searchName)) {
                        String department = emp[2].trim();
                        String salary = emp[3].trim();

                        System.out.println("Employee Found:");
                        System.out.println("Department: " + department);
                        System.out.println("Salary    : " + salary);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Employee '" + searchName + "' not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

