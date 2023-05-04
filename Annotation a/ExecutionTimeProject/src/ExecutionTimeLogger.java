import java.lang.reflect.Method;

public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        TaskRunner runner = new TaskRunner();

        for (Method method : TaskRunner.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(runner);
                long end = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (end - start) + " ns");
            }
        }
    }
}
