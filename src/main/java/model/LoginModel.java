package model;

import com.vaadin.flow.server.VaadinSession;

import core.Role;

/**
 * Model class handles login action and sets the user role.
 */
public class LoginModel {
	private static final String PATIENT_USERNAME = "patient";
	private static final String PATIENT_PASSWORD = "123";
	private static final String DOCTOR_USERNAME = "doctor";
	private static final String DOCTOR_PASSWORD = "123";

	public LoginModel() {
		setRole(Role.ANONYMOUS);
	}

	public boolean authenticate(String username, String password) {
		if (username.equals(PATIENT_USERNAME) && password.equals(PATIENT_PASSWORD)) {
			setRole(Role.PATIENT);
			return true;
		} else if (username.equals(DOCTOR_USERNAME) && password.equals(DOCTOR_PASSWORD)) {
			setRole(Role.DOCTOR);
			return true;
		} else {
			setRole(Role.ANONYMOUS);
			return false;
		}
	}

	/**
	 * @param role
	 *            the user role
	 */
	public void setRole(Role role) {
		VaadinSession.getCurrent().setAttribute("role", role);
	}
}
