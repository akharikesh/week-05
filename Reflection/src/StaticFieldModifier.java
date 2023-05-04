import java.lang.reflect.Field;

public class StaticFieldModifier {
    public static void main(String[] args) {
        try {
            // Step 1: Get Class object
            Class<?> configClass = Class.forName("Configuration");

            // Step 2: Get the static private field
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Step 3: Make it accessible
            apiKeyField.setAccessible(true);

            // Step 4: Modify the static field (pass null since it's static)
            apiKeyField.set(null, "NEW_SECRET_KEY_123");

            // Step 5: Confirm updated value
            System.out.println("✅ Modified API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
