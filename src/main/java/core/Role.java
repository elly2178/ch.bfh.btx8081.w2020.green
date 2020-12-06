package core;

import static core.View.DIARY;
import static core.View.HOME;
import static core.View.LOGIN;

/**
 * Available roles within Leaf Doctors application. Needed for determining the
 * accessible views for each role.
 */
public enum Role {

	/**
	 * User is not logged in.
	 */
	ANONYMOUS(LOGIN, HOME),

	/**
	 * User is logged in as patient.
	 */
	PATIENT(LOGIN, HOME, DIARY),
	/**
	 * User is logged in as doctor.
	 */
	DOCTOR(LOGIN, HOME);

	private View[] viewClasses;

	private Role(View... viewClasses) {
		this.viewClasses = viewClasses;
	}

	public View[] getViewClasses() {
		return viewClasses;
	}
}
