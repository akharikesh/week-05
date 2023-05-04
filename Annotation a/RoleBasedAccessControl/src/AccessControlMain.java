import java.lang.reflect.Method;

public class AccessControlMain {
    public static void main(String[] args) throws Exception {
        // Simulate users
        User admin = new User("Alice", "ADMIN");
        User normalUser = new User("Bob", "USER");

        AdminService service = new AdminService();

        // Try access with ADMIN
        System.out.println("=== Trying with ADMIN ===");
        invokeIfAllowed(service, "performAdminTask", admin);

        // Try access with USER
        System.out.println("=== Trying with USER ===");
        invokeIfAllowed(service, "performAdminTask", normalUser);

        // Always allowed
        System.out.println("=== Public method ===");
        service.publicTask();
    }

    public static void invokeIfAllowed(Object obj, String methodName, User user) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (!roleAllowed.value().equals(user.getRole())) {
                    System.out.println("Access Denied for user: " + user.getName() + " (Role: " + user.getRole() + ")");
                    return;
                }
            }
            method.invoke(obj);
        } catch (Exception e) {
            System.out.println("Error invoking method: " + e.getMessage());
        }
    }
}
