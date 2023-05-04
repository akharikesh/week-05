import java.lang.reflect.Field;

public class JsonConverter {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        Class<?> clazz = obj.getClass();
        json.append("{");

        Field[] fields = clazz.getDeclaredFields();
        int count = 0;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String name = field.getName();
                Object value = field.get(obj);
                json.append("\"").append(name).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if (++count < fields.length) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        Users user = new Users("Alice", 25, "alice@example.com");
        String json = toJson(user);
        System.out.println("✅ JSON Output:\n" + json);
    }
}
