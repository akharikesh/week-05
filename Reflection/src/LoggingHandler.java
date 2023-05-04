import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler implements InvocationHandler {

    private Object target;

    public LoggingHandler(Object target) {  // ✅ Accept any Object
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("🔍 Logging: Method called - " + method.getName());
        return method.invoke(target, args);
    }
}
