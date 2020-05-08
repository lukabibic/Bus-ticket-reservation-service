package busystem;

public class MainController {
	LoginController loginController;
	AdminController adminController;
	UserController userController;

	public MainController() {
		this.loginController = new LoginController(this);
	}
}
