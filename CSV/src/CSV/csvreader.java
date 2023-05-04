package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csvreader {

    public static void main(String[] args) {
        String csvFile = "C:\\Hari\\day.csv\\"; 
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] studentDetails = line.split(delimiter);

                int id = Integer.parseInt(studentDetails[0]);
                String name = studentDetails[1];
                int age = Integer.parseInt(studentDetails[2]);
                int marks = Integer.parseInt(studentDetails[3]);

                System.out.printf("ID: %d, Name: %s, Age: %d, Marks: %d\n", id, name, age, marks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

