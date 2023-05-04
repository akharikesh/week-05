import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicInvoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Ask for method name and parameters
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Step 2: Get Class and instance
            Class<?> clazz = Class.forName("MathOperations");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // Step 3: Get method with parameter types
            Method method = clazz.getMethod(methodName, int.class, int.class);

            // Step 4: Invoke method
            Object result = method.invoke(obj, num1, num2);

            System.out.println("✅ Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("❌ Method not found. Please enter a valid method name.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
