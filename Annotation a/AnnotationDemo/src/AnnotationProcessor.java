import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<MyClass> clazz = MyClass.class;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance level: " + annotation.level());
            }
        }
    }
}
