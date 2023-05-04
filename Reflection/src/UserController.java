public class UserController {
    
    @Inject
    private EmailService emailService;  // This should be injected

    public void process() {
        emailService.sendEmail("Welcome user!");
    }
}
