package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class toppaidemployee {

    public static void main(String[] args) {
        String csvFile = "C:\\Hari\\sample 2 - Sheet1.csv\\";
        String line;
        String delimiter = ",";
        List<String[]> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] emp = line.split(delimiter);
                if (emp.length == 4) {
                    employees.add(emp);
                }
            }

            employees.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3].trim());
                double salaryB = Double.parseDouble(b[3].trim());
                return Double.compare(salaryB, salaryA); 
            });

            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println("------------------------------");
            System.out.println("ID\tName\t\tDepartment\tSalary");

            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                String[] emp = employees.get(i);
                System.out.printf("%s\t%-15s\t%-10s\t%s%n", emp[0], emp[1], emp[2], emp[3]);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

