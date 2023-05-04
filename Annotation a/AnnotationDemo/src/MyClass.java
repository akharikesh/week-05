public class MyClass {

    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        System.out.println("Performing a critical task.");
    }

    @ImportantMethod(level = "MEDIUM")
    public void normalTask() {
        System.out.println("Performing a normal task.");
    }

    public void regularTask() {
        System.out.println("Performing a regular task.");
    }
}
