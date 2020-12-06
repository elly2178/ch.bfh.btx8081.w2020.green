package view;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.login.LoginForm;

/**
 * Interface defines interactions inside the login view.
 */
public interface LoginView {
	
	interface LoginViewListener extends ComponentEventListener<LoginEvent> { }

	public void addListener(LoginViewListener listener);
	public LoginForm getLoginFormComponent();
}
