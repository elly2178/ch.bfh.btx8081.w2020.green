package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "login", layout = HomeView.class)
public class LoginViewImpl extends VerticalLayout implements LoginView {
	private static final long serialVersionUID = 5694264706543533720L;

	private List<LoginViewListener> listeners = new ArrayList<>();
	private LoginForm loginFormComponent;

	public LoginViewImpl() {
		addLoginForm();
	}

	private void addLoginForm() {
		loginFormComponent = new LoginForm();
		loginFormComponent.addLoginListener(e -> listeners.forEach(event -> event.onComponentEvent(e)));
		add(loginFormComponent);
	}

	@Override
	public void addListener(LoginViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public LoginForm getLoginFormComponent() {
		return loginFormComponent;
	}

}
