package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginView extends VerticalLayout {
	private static final String PATIENT_USERNAME = "patient";
	private static final String PATIENT_PASSWORD = "123";

	public LoginView() {
		LoginForm component = new LoginForm();
		component.addLoginListener(e -> {
			boolean isAuthenticated = authenticate(e);
			if (isAuthenticated) {
				getUI().get().navigate("");
			} else {
				component.setError(true);
			}
		});
		Button button = new Button("Click me", event -> Notification.show("Clicked!"));
		add(component, button);
	}

	private boolean authenticate(LoginEvent e) {
		return e.getUsername().equals(PATIENT_USERNAME) && e.getPassword().equals(PATIENT_PASSWORD);
	}
}
