import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy {

    private final Map<String, Object> cache = new HashMap<>();

    public Object invoke(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getMethod(methodName, int.class); // Assumes only int params

            if (method.isAnnotationPresent(CacheResult.class)) {
                String key = methodName + "(" + args[0] + ")";

                if (cache.containsKey(key)) {
                    System.out.println("Returning cached result for input: " + args[0]);
                    return cache.get(key);
                }

                Object result = method.invoke(obj, args);
                cache.put(key, result);
                System.out.println("Computed and cached result for input: " + args[0]);
                return result;
            } else {
                return method.invoke(obj, args);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
