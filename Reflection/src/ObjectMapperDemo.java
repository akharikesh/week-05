import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectMapperDemo {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Allow access to private field
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("⚠ Field not found: " + fieldName);
                }
            }

            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Failed to map object: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", "Alice");
        userData.put("age", 25);
        userData.put("email", "alice@example.com");

        User user = toObject(User.class, userData);

        System.out.println("✅ Mapped User: " + user);
    }
}

