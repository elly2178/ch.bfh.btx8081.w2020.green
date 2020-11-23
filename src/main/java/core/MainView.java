package core;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView() {
    	VerticalLayout vertical = new VerticalLayout ();
    	//HorizontalLayout horizontal = new HorizontalLayout ();
    	//vertical.addComponent(horizontal);
    	//horizontal.addComponent(new Textfield("Patient Search"));
    	//horizontal.addComponent(new Textfield("+ Add New Patient"));
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));
        add(button);
    }
}
