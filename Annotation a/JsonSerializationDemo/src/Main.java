public class Main {
    public static void main(String[] args) {
        User user = new User("alice123", 25, "alice@example.com");
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
