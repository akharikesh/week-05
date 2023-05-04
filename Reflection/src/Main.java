public class Main {
    public static void main(String[] args) throws Exception {
        UserController userController = SimpleDIContainer.createInstance(UserController.class);
        userController.process(); // ✅ Should send email via injected EmailService
    }
}
