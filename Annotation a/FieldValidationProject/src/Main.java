public class Main {
    public static void main(String[] args) {
        User user1 = new User("shortName");  // Valid username
        System.out.println("User1 created: " + user1.getUsername());

        User user2 = new User("thisNameIsWayTooLong");  // This will throw an exception
        System.out.println("User2 created: " + user2.getUsername());
    }
}
