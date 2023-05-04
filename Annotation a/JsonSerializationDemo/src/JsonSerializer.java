import java.lang.reflect.Field;

public class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name();
                try {
                    Object value = field.get(obj);
                    if (!firstField) {
                        json.append(", ");
                    }
                    json.append("\"").append(key).append("\": ");

                    // Wrap strings in quotes, leave others raw
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }

                    firstField = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        json.append("}");
        return json.toString();
    }
}
