package view.common;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

import view.HomeView;
import view.LoginView;

/**
 * Navigation view offers the menu bar for topic selection over all other views.
 */
public abstract class NavigationView extends VerticalLayout {

	private static final long serialVersionUID = 6075640710178739027L;

	public NavigationView() {
		createMenuBar();
	}

	private void createMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.setOpenOnHover(true);

		MenuItem patients = menuBar.addItem("Patients");
		menuBar.addItem("Login", e -> getUI().get().navigate("login"));

		SubMenu patientsSubMenu = patients.getSubMenu();
		patientsSubMenu.addItem("Diaries", e -> getUI().get().navigate("diary"));
		patientsSubMenu.addItem("Add", e -> getUI().get().navigate("add"));

		add(menuBar);
	}

//	void routerLink() {
//		Div menu = new Div();
//		menu.add(new RouterLink("Home", HomeView.class));
//		menu.add(new RouterLink("Login", LoginView.class));
//		// menu.add(new RouterLink("Greeting", GreetingComponent.class, "default"));
//	}
}
