public class ProjectFeatures {

    @Todo(task = "Implement login functionality", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        // pending implementation
    }

    @Todo(task = "Add user profile page", assignedTo = "Bob")
    public void userProfileFeature() {
        // pending implementation
    }

    public void completedFeature() {
        System.out.println("This feature is done.");
    }
}
