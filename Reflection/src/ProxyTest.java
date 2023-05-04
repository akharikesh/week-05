import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Greeting original = new GreetingImpl(); // ✅ Interface type

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingHandler(original) // ✅ LoggingHandler accepts Object
        );

        proxy.sayHello(); // ✅ Should log method name and execute
    }
}
