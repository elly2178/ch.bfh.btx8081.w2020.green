package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("newPatient")
public class CreateNewPatientView extends VerticalLayout {
	
	public CreateNewPatientView() {
		

	
	Button button = new Button("Click me ", event -> Notification.show("Clicked!"));
	
	FormLayout columnLayout = new FormLayout();
	// Setting the desired responsive steps for the columns in the layout
	//columnLayout.setResponsiveSteps();
	           //new ResponsiveStep("25em", 1),
	           //new ResponsiveStep("32em", 2),
	          // new ResponsiveStep("40em", 3));
	   TextField firstName = new TextField();
	   firstName.setPlaceholder("First Name");
	   TextField lastName = new TextField();
	   lastName.setPlaceholder("Last Name");
	   TextField email = new TextField();
	   email.setPlaceholder("Email");
	   TextField birthdate = new TextField();
	   birthdate.setPlaceholder("Birthdate");
	   TextField website = new TextField();
	   website.setPlaceholder("Link to personal website");
	   TextField description = new TextField();
	   description.setPlaceholder("Enter a short description about yourself");
	   columnLayout.add(firstName, lastName,  birthdate, email, website); 
	   // You can set the desired column span for the components individually.
	   columnLayout.setColspan(website, 2);
	   // Or just set it as you add them.
	   columnLayout.add(description, 3);
	   Button buttonSaved = new Button("Save new patient", event -> Notification.show("Saved!"));
	   add(button, columnLayout, buttonSaved);
	
	}

}
