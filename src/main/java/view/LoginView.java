package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginView extends VerticalLayout {

	public LoginView() {
		LoginForm component = new LoginForm();
		// component.addLoginListener(e -> {
		// boolean isAuthenticated = authenticate(e);
		// if (isAuthenticated) {
		// navigateToMainPage();
		// } else {
		// component.setError(true);
		// }
		// });

		Button button = new Button("Click me", event -> Notification.show("Clicked!"));
		add(component, button);
	}
}
