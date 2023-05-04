import java.lang.reflect.Field;

public class SimpleDIContainer {

    public static <T> T createInstance(Class<T> clazz) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = fieldType.getDeclaredConstructor().newInstance();

                field.setAccessible(true); // to access private fields
                field.set(obj, dependency);
            }
        }

        return obj;
    }
}
