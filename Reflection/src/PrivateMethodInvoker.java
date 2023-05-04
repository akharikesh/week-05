import java.lang.reflect.Method;

public class PrivateMethodInvoker {

    public static void main(String[] args) {
        try {
            // Step 1: Create an instance of Calculator
            Calculator calc = new Calculator();

            // Step 2: Get the private method reference
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Step 3: Make it accessible
            method.setAccessible(true);

            // Step 4: Invoke the method with parameters
            Object result = method.invoke(calc, 7, 5);

            // Step 5: Display the result
            System.out.println("Result of multiply(7, 5): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
