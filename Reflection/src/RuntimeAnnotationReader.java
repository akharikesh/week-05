public class RuntimeAnnotationReader {
    public static void main(String[] args) {
        try {
            // Step 1: Load the class
            Class<?> clazz = Class.forName("Book");

            // Step 2: Check if @Author is present
            if (clazz.isAnnotationPresent(Author.class)) {
                // Step 3: Get the annotation
                Author author = clazz.getAnnotation(Author.class);

                // Step 4: Display the value
                System.out.println("📘 Author: " + author.name());
            } else {
                System.out.println("No @Author annotation present.");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
