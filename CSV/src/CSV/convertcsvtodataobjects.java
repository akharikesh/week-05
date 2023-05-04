package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %d, Marks: %d", id, name, age, marks);
    }
}


public class convertcsvtodataobjects {

    public static void main(String[] args) {
        String csvFile = ""; 
        String line;
        String delimiter = ",";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);

                if (data.length >= 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    int marks = Integer.parseInt(data[3].trim());

                    Student student = new Student(id, name, age, marks);
                    students.add(student);
                }
            }

            System.out.println("Student Records:");
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
