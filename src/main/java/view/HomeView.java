package view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Vaadin Main Page", shortName = "Home")
public class HomeView extends VerticalLayout {

	public HomeView() {
		createMenuBar();
		VerticalLayout vertical = new VerticalLayout();
		HorizontalLayout horizontal = new HorizontalLayout();
		vertical.add(horizontal);
		horizontal.add(new TextField("Patient Search"));
		horizontal.add(new TextField("+ Add New Patient"));
		Button button = new Button("Click me", event -> Notification.show("Clicked!"));
		add(vertical, button);
	}

	private void createMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.setOpenOnHover(true);

		Text selected = new Text("");
		Div message = new Div(new Text("Selected: "), selected);

		MenuItem patients = menuBar.addItem("Patients");
		menuBar.addItem("Login", e -> selected.setText("Login")); // navigate to LoginView

		SubMenu patientsSubMenu = patients.getSubMenu();
		patientsSubMenu.addItem("Diaries", e -> selected.setText("Diaries")); // navigate to DiaryView
		patientsSubMenu.addItem("Add", e -> selected.setText("Add")); // navigate to AddPatientView

		add(menuBar, message);
		routerLink();
	}

	void routerLink() {
		Div menu = new Div();
		menu.add(new RouterLink("Home", HomeView.class));
		menu.add(new RouterLink("Login", LoginView.class));
//		menu.add(new RouterLink("Greeting", GreetingComponent.class, "default"));
	}
}
