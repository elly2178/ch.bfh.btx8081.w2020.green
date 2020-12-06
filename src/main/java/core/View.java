package core;

import view.DiariesView;
import view.LoginViewImpl;
import view.MainView;

/**
 * Available views within Leaf Doctors application.
 */
// TODO - probably not needed.
public enum View {

	HOME(MainView.class),
	LOGIN(LoginViewImpl.class),
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
