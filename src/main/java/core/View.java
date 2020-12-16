package core;

import view.DiaryViewImpl;
import view.LoginViewImpl;
import view.MainView;
import view.YbocsTestImpl;
import view.MoodTestImpl;

/**
 * Available views within Leaf Doctors application.
 */
// TODO - probably not needed.
public enum View {

	HOME(MainView.class),
	LOGIN(LoginViewImpl.class),
	DIARY(DiaryViewImpl.class),
	// added lines 17 to 20
	YBOCS(YbocsTestImpl.class),
	MOOD(MoodTestImpl.class);
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
