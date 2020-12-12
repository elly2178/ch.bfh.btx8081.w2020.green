package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for {@link LoginModel}.
 */
public class LoginModelTest {
	private LoginModel cut = new LoginModel();
	
	/**
	 * Tests if login model authenticates user as patient.
	 */
	@Test
	public void shouldAuthenticateWithPatient() {
		assertTrue(cut.authenticate("patient", "123"));
	}
	
	/**
	 * Tests if login model authenticates user as doctor.
	 */
	@Test
	public void shouldAuthenticateWithDoctor() {
		assertTrue(cut.authenticate("doctor", "123"));
	}
	
	/**
	 * Tests if given login parameters do not authenticate.
	 */
	@Test
	public void shoulNotAuthenticate() {
		assertFalse(cut.authenticate("patient", "abc"));
	}
}
