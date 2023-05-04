package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class validatecsv {

    public static void main(String[] args) {
        String csvFile = "C:\\Hari\\sample 3 - Sheet1.csv\\"; 
        String line;
        String delimiter = ",";

        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine(); 
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] data = line.split(delimiter);

                if (data.length < 4) {
                    System.out.println("Line " + lineNumber + ": Invalid record format - too few fields.");
                    continue;
                }

                String email = data[2].trim();
                String phone = data[3].trim();

                boolean isValid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Line " + lineNumber + ": Invalid email - " + email);
                    isValid = false;
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Line " + lineNumber + ": Invalid phone number - " + phone);
                    isValid = false;
                }

                if (isValid) {
                    System.out.println("Line " + lineNumber + ": Valid record - " + String.join(", ", data));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

