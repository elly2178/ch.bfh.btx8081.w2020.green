package view.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;

import core.Role;
import model.LoginModel;
import presenter.LoginPresenter;
import view.LoginViewImpl;

/**
 * Common layout for all views.
 */
public class MainLayout extends VerticalLayout implements RouterLayout {
	private static final long serialVersionUID = -4892183322719539790L;
	private static final String PATH_HEADER_IMAGE = "src/main/webapp/WEB-INF/images/leaf_doctors.png";
	private LoginViewImpl loginView = new LoginViewImpl();
	private MenuBar menuBar;

	public MainLayout() {
		addHeaderImage();
		addMenuBar();
	}

	public void navigateToHomeView() {
		remove(loginView);
		remove(menuBar);
		addMenuBar();
	}

	private void addLoginForm() {
		new LoginPresenter(new LoginModel(), loginView, this);
		add(loginView);
	}

	private void addHeaderImage() {
		try {
			File file = new File(PATH_HEADER_IMAGE);
			byte[] fileContent = Files.readAllBytes(file.toPath());
			StreamResource resource = new StreamResource("leaf_doctors.png",
					() -> new ByteArrayInputStream(fileContent));
			Image image = new Image(resource, "leaf_doctors");
			image.setWidth("300px");
			image.addClickListener(e -> navigateTo(""));
			add(image);
		} catch (IOException e) {
			e.printStackTrace();
			throw new UncheckedIOException("the header image could not have been loaded.", e);
		}
	}

	private void addMenuBar() {
		menuBar = new MenuBar();
		menuBar.setOpenOnHover(true);
		Role role = (Role) VaadinSession.getCurrent().getAttribute("role");
		if (role == null) {
			role = Role.ANONYMOUS;
		}
		switch (role) {
		case ANONYMOUS:
			addLoginForm();
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
		add(menuBar);
	}

	private void addDoctorNavigation(MenuBar menuBar) {
		MenuItem patients = menuBar.addItem("Patients");
		SubMenu patientsSubMenu = patients.getSubMenu();
		patientsSubMenu.addItem("Patient Summary", e -> navigateTo("patientSummary"));
		addLogoutItem(menuBar);
	}

	private void addPatientNavigation(MenuBar menuBar) {
		MenuItem patients = menuBar.addItem("Patients");
		SubMenu patientsSubMenu = patients.getSubMenu();
		patientsSubMenu.addItem("Diaries", e -> navigateTo("diaries"));
		patientsSubMenu.addItem("Ybocs-Test", e -> navigateTo("ybocstest"));
		patientsSubMenu.addItem("Mood-Test", e -> navigateTo("moodtest"));
		addLogoutItem(menuBar);
	}

	private void addLogoutItem(MenuBar menuBar) {
		menuBar.addItem("Logout", e -> {
			VaadinSession.getCurrent().setAttribute("role", Role.ANONYMOUS);
			VaadinSession.getCurrent().close();
			navigateTo("login");
		});
	}

	private void navigateTo(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}
}