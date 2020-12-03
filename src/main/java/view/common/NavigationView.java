package view.common;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * Navigation view offers the menu bar for topic selection over all other views.
 */
public abstract class NavigationView extends VerticalLayout {

	private static final long serialVersionUID = 6075640710178739027L;

	public NavigationView() {
		addHeaderImage();
		addMenuBar();
	}

	private void addHeaderImage() {
		// https://memorynotfound.com/java-read-image-file-url-classpath-inputstream/
		Image headerImage = new Image("/ch.bfh.btx8081.w2020.green/src/main/resources/leaf_doctors.png", "leafDoctors");
		headerImage.addClickListener(e -> navigateTo(""));
		add(headerImage);
	}

	private void addMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.setOpenOnHover(true);
		MenuItem patients = menuBar.addItem("Patients");
		SubMenu patientsSubMenu = patients.getSubMenu();
		menuBar.addItem("Login", e -> navigateTo("login"));
		patientsSubMenu.addItem("Diaries", e -> navigateTo("diaries"));
		patientsSubMenu.addItem("Add", e -> navigateTo("add"));
		add(menuBar);
	}

	// Might not be used. Work with MenuBar instead.
	// void routerLink() {
	// Div menu = new Div();
	// menu.add(new RouterLink("Home", HomeView.class));
	// menu.add(new RouterLink("Login", LoginView.class));
	// add(menu);
	// // menu.add(new RouterLink("Greeting", GreetingComponent.class, "default"));
	// }

	private void navigateTo(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}
}