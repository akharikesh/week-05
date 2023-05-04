public class AdminService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task performed successfully.");
    }

    // ✅ Add this method to avoid "undefined" error
    public void publicTask() {
        System.out.println("This is a public task anyone can access.");
    }
}
