package view;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;

import core.Role;

/**
 * Home page after successful login.
 */
@Route(value = "home")
public abstract class HomeView extends VerticalLayout implements RouterLayout {
	private static final long serialVersionUID = -2515746681908568218L;

	public HomeView() {
		add("Willkommen im Leaf Doctors Portal");
//		Role role = (Role) VaadinSession.getCurrent().getAttribute("role");
//		if (role == null) {
//			navigateTo("login");
//			return;
//		}
//		addMenuBar(role);

		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);
	}
	private void addMenuBar(Role role) {
		MenuBar menuBar = new MenuBar();
		menuBar.setOpenOnHover(true);
		switch (role) {
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
			VaadinSession.getCurrent().setAttribute("role", Role.ANONYMOUS);
			VaadinSession.getCurrent().close();
			navigateTo("login");
		});
		add(menuBar);
	}

	private void addDoctorNavigation(MenuBar menuBar) {
		MenuItem patients = menuBar.addItem("Patients");
		SubMenu patientsSubMenu = patients.getSubMenu();
		patientsSubMenu.addItem("Patient Summary", e -> navigateTo("patientSummary"));
	}

	private void addPatientNavigation(MenuBar menuBar) {
		//MenuItem patients = menuBar.addItem("Patients");
		//SubMenu patientsSubMenu = patients.getSubMenu();
		///patientsSubMenu.addItem("Diaries", e -> navigateTo("diaries"));
		//patientsSubMenu.addItem("Ybocs-Test", e -> navigateTo("ybocstest"));
		//patientsSubMenu.addItem("Mood-Test", e -> navigateTo("moodtest"));
	}

	private void addAnonymousNavigation(MenuBar menuBar) {
		menuBar.addItem("Login", e -> navigateTo("login"));
	}

	private void navigateTo(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}
}
