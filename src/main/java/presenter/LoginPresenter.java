package presenter;

import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;

import model.LoginModel;
import view.LoginView;
import view.common.MainLayout;

/**
 * Login Presenter combines the view and data model.
 */
public class LoginPresenter implements LoginView.LoginViewListener {
	private static final long serialVersionUID = -326401691991648229L;
	private transient LoginModel loginModel;
	private transient LoginView loginView;
	private MainLayout mainLayout;
	
	public LoginPresenter(LoginModel model, LoginView loginView, MainLayout mainLayout) {
		this.loginModel = model;
		this.loginView = loginView;
		this.loginView.addListener(this);
		this.mainLayout = mainLayout;
	}

	@Override
	public void onComponentEvent(LoginEvent event) {
		boolean isAuthenticated = loginModel.authenticate(event);
		if (isAuthenticated) {
			mainLayout.navigateToHomeView();
		} else {
			loginView.getLoginFormComponent().setError(true);
		}
	}
}
