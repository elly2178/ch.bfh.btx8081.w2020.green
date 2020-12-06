package view;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import core.Role;
import model.UserSessionModel;

/**
 * Home page after successful login.
 */
@Route("home")
public class HomeView extends VerticalLayout {
	private static final long serialVersionUID = -2515746681908568218L;
	private transient UserSessionModel userSessionModel;

	public HomeView(UserSessionModel userSessionModel) {
		this.userSessionModel = userSessionModel;
		addMenuBar();
	}

	private void addMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.setOpenOnHover(true);

		switch (userSessionModel.getRole()) {
		case ANONYMOUS:
			addAnonymousNavigation(menuBar);
			break;
		case PATIENT:
			addPatientNavigation(menuBar);
			break;
		case DOCTOR:
			addDoctorNavigation(menuBar);
			break;
		default:
			throw new IllegalStateException("role is undefined");
		}

		menuBar.addItem("Logout", e -> {
			userSessionModel.setRole(Role.ANONYMOUS);
			userSessionModel.getSession().close();
			navigateTo("");
		});
		add(menuBar);
	}

	private void addDoctorNavigation(MenuBar menuBar) {
		MenuItem patients = menuBar.addItem("Patients");
		SubMenu patientsSubMenu = patients.getSubMenu();
		patientsSubMenu.addItem("Add", e -> navigateTo("add"));
	}

	private void addPatientNavigation(MenuBar menuBar) {
		MenuItem patients = menuBar.addItem("Patients");
		SubMenu patientsSubMenu = patients.getSubMenu();
		patientsSubMenu.addItem("Diaries", e -> navigateTo("diaries"));
	}

	private void addAnonymousNavigation(MenuBar menuBar) {
		menuBar.addItem("Login", e -> navigateTo("login"));
	}

	private void navigateTo(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}
}
