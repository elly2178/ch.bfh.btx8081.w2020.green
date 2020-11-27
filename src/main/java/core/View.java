package core;

import view.DiariesView;
import view.HomeView;
import view.LoginView;

/**
 * Available views within Leaf Doctors application.
 */
public enum View {

	HOME(HomeView.class),
	LOGIN(LoginView.class),
	DIARY(DiariesView.class);

	private Class<?> viewClass;

	private View(Class<?> viewClass) {
		this.viewClass = viewClass;
	}

	/**
	 * @return the view class
	 */
	public Class<?> getViewClass() {
		return viewClass;
	}
}
