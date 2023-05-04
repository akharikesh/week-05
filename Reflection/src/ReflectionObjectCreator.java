import java.lang.reflect.Constructor;

public class ReflectionObjectCreator {
    public static void main(String[] args) {
        try {
            // Step 1: Load the Student class
            Class<?> studentClass = Class.forName("Student");

            // Step 2: Get the constructor with parameters (String, int)
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

            // Step 3: Create a new instance dynamically
            Object studentObj = constructor.newInstance("Alice", 21);

            // Step 4: Call the displayInfo method
            studentClass.getMethod("displayInfo").invoke(studentObj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
