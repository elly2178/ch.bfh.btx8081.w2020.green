package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import view.common.MenuBarView;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Vaadin Main Page", shortName = "Home")
public class HomeView extends MenuBarView {

	public HomeView() {
		VerticalLayout vertical = new VerticalLayout();
		HorizontalLayout horizontal = new HorizontalLayout();
		vertical.add(horizontal);
		horizontal.add(new TextField("Patient Search"));
		horizontal.add(new TextField("+ Add New Patient"));
		Button button = new Button("Click me", event -> Notification.show("Clicked!"));
		add(vertical, button);
	}
}
