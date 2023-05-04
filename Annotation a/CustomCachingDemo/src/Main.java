public class Main {
    public static void main(String[] args) {
        MathService service = new MathService();
        CacheProxy proxy = new CacheProxy();

        long start, end;

        start = System.currentTimeMillis();
        System.out.println("Result: " + proxy.invoke(service, "slowSquare", 5));
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println("Result: " + proxy.invoke(service, "slowSquare", 5));
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println("Result: " + proxy.invoke(service, "slowSquare", 6));
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");
    }
}
