import java.lang.reflect.Method;

public class TodoProcessor {
    public static void main(String[] args) {
        Class<ProjectFeatures> clazz = ProjectFeatures.class;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Pending Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method Name: " + method.getName());
                System.out.println("----------------------------");
            }
        }
    }
}
