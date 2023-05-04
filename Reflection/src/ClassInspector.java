import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInspector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter fully qualified class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            // Load the class
            Class<?> cls = Class.forName(className);

            System.out.println("\n📦 Class: " + cls.getName());

            // Display constructors
            System.out.println("\n🔧 Constructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }

            // Display fields
            System.out.println("\n📂 Fields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("  " + field);
            }

            // Display methods
            System.out.println("\n⚙️ Methods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("  " + method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Class not found: " + className);
        }

        scanner.close();
    }
}

