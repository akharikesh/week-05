import java.lang.reflect.Field;

public class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (field.getName().equals("username")) {
                    if (username != null && username.length() > maxLength.value()) {
                        throw new IllegalArgumentException(
                            "Field '" + field.getName() + "' exceeds max length of " + maxLength.value());
                    }
                }
            }
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
