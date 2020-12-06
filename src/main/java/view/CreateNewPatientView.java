package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("newPatient")
public class CreateNewPatientView extends VerticalLayout {
	
	public CreateNewPatientView() {
		

	
	Button button = new Button("Click me ", event -> Notification.show("Clicked!"));
	
	add(button);
	
	}

}
