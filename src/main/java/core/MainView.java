package core;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {

	public MainView() {
		VerticalLayout vertical = new VerticalLayout();
		HorizontalLayout horizontal = new HorizontalLayout();
		vertical.add(horizontal);
		horizontal.add(new TextField("Patient Search"));
		horizontal.add(new TextField("+ Add New Patient"));
		Button button = new Button("Click me", event -> Notification.show("Clicked!"));
		add(vertical, button);
	}
}
