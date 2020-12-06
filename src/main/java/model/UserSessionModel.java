package model;

import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.server.VaadinSession;

import core.Role;

/**
 * Model class representing the active user session.
 */
public class UserSessionModel {
	private static final String PATIENT_USERNAME = "patient";
	private static final String PATIENT_PASSWORD = "123";
	private static final String DOCTOR_USERNAME = "doctor";
	private static final String DOCTOR_PASSWORD = "123";

	private VaadinSession session;
	private Role role;

	public UserSessionModel() {
		session = VaadinSession.getCurrent();
		if (session == null) {
			throw new IllegalStateException("Current VaadinSession not available");
		}
		setRole(Role.ANONYMOUS);
	}

	public boolean authenticate(LoginEvent e) {
		if (e.getUsername().equals(PATIENT_USERNAME) && e.getPassword().equals(PATIENT_PASSWORD)) {
			setRole(Role.PATIENT);
			return true;
		} else if (e.getUsername().equals(DOCTOR_USERNAME) && e.getPassword().equals(DOCTOR_PASSWORD)) {
			setRole(Role.DOCTOR);
			return true;
		} else {
			setRole(Role.ANONYMOUS);
			return false;
		}
	}

	/**
	 * @return the VaadinSession
	 */
	public VaadinSession getSession() {
		return session;
	}

	/**
	 * @param role
	 *            the user role
	 */
	public void setRole(Role role) {
		session.setAttribute("role", role);
		this.role = role;
	}

	/**
	 * @return the user role
	 */
	public Role getRole() {
		return role;
	}
}
