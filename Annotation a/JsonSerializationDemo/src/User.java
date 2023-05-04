public class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    // ✅ Define constructor that matches the usage
    public User(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}
