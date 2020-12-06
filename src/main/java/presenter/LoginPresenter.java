package presenter;

import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;

import model.UserSessionModel;
import view.LoginView;
import view.MainView;

/**
 * Login Presenter combines the view and data model.
 */
public class LoginPresenter implements LoginView.LoginViewListener {
	private static final long serialVersionUID = -326401691991648229L;
	private transient UserSessionModel userSessionModel;
	private transient LoginView loginView;
	private MainView mainView;

	public LoginPresenter(UserSessionModel model, LoginView loginView, MainView mainView) {
		userSessionModel = model;
		this.loginView = loginView;
		this.loginView.addListener(this);
		this.mainView = mainView;
	}

	@Override
	public void onComponentEvent(LoginEvent event) {
		boolean isAuthenticated = userSessionModel.authenticate(event);
		if (isAuthenticated) {
			mainView.createNavigation();
		} else {
			loginView.getLoginFormComponent().setError(true);
		}
	}
}
