package view;

import java.util.Optional;
import java.util.stream.Collectors;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.charts.model.Select;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormItem;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Binder.Binding;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;

import common.Person;

@Route("newPatient")
public class CreateNewPatientView extends VerticalLayout {
	
	public CreateNewPatientView() {
		

	Label header = new Label("Add a new patient");
	
	FormLayout columnLayout = new FormLayout();
	// Setting the desired responsive steps for the columns in the layout
	//columnLayout.setResponsiveSteps();
	           //new ResponsiveStep("25em", 1),
	           //new ResponsiveStep("32em", 2),
	          // new ResponsiveStep("40em", 3));
	   TextField firstName = new TextField();
	   firstName.setLabel("First Name");
	   //firstName.setPlaceholder("e. g. Max");
	   
	   TextField secondName = new TextField();
	   secondName.setLabel("Last Name");
	   //secondName.setPlaceholder("e. g. Muster");
	  /* 
	   Select gender = new Select();
	   gender.setItems("female", "male", "other");
	   gender.setPlaceholder("Gender");
	   */
	   ComboBox<String> gender = new ComboBox<>();
       gender.setAllowCustomValue(true);
       gender.setLabel("Gender");
       gender.setItems("female", "male", "other");
       //setColspan(country, 2);
	   
	   
	   TextField phone = new TextField();
	   phone.setLabel("Phone");
	   
	   TextField email = new TextField();
	   email.setLabel("E-Mail");
	   //email.setPlaceholder("e. g. max.muster@hotmail.com");
	   
	   DatePicker birthDate = new DatePicker();
	   birthDate.setLabel("Birthdate");
	   //birthDate.setPlaceholder("e. g. 28.08.2001");
	   
	   TextField streetAndNr = new TextField();
	   streetAndNr.setLabel("Street, Nr.");
	   //streetAndNr.setPlaceholder("e. g. Bernstrasse, 77");
	   
	   NumberField postalCode = new NumberField("Postal Code");
	   postalCode.setLabel("Postal code");
	   //postalCode.setPlaceholder("e. g. 3018");
	   
	   TextField city = new TextField();
	   city.setLabel("City");
	   //postalCode.setPlaceholder("e.g. Barcelona");
	   
	   TextField country = new TextField();
	   country.setLabel("Country");
	   //country.setPlaceholder("e. g. Switzerland");
	   
	   columnLayout.add(firstName, secondName,  birthDate, gender, phone, email, streetAndNr, postalCode, city, country); 
	   
	   // 
	   //columnLayout.setColspan(email, 2);
	   columnLayout.setColspan(streetAndNr, 2);
	   columnLayout.setColspan(country, 2);
	   
	   // Or just set it as you add them.
	   //columnLayout.add(streetAndNr, 3);
	   Button buttonSaved = new Button("Save new patient", event -> Notification.show("Saved!"));



	  /*
	   FormLayout layoutWithBinder = new FormLayout();
	   Binder<Person> binder = new Binder<>();

	   // The object that will be edited
	   Person personBeingEdited = new Person();

	   // Create the fields
	   TextField firstName = new TextField();
	   firstName.setValueChangeMode(ValueChangeMode.EAGER);
	   TextField lastName = new TextField();
	   lastName.setValueChangeMode(ValueChangeMode.EAGER);
	   TextField phone = new TextField();
	   phone.setValueChangeMode(ValueChangeMode.EAGER);
	   TextField email = new TextField();
	   email.setValueChangeMode(ValueChangeMode.EAGER);
	   DatePicker birthDate = new DatePicker();
	   Checkbox doNotCall = new Checkbox("Do not call");
	   Label infoLabel = new Label();
	   NativeButton save = new NativeButton("Save");
	   NativeButton reset = new NativeButton("Reset");

	   layoutWithBinder.addFormItem(firstName, "First name");
	   layoutWithBinder.addFormItem(lastName, "Last name");
	   layoutWithBinder.addFormItem(birthDate, "Birthdate");
	   layoutWithBinder.addFormItem(email, "E-mail");
	   FormItem phoneItem = layoutWithBinder.addFormItem(phone, "Phone");
	   phoneItem.add(doNotCall);

	   // Button bar
	   HorizontalLayout actions = new HorizontalLayout();
	   actions.add(save, reset);
	   save.getStyle().set("marginRight", "10px");

	   SerializablePredicate<String> phoneOrEmailPredicate = value -> !phone
	           .getValue().trim().isEmpty()
	           || !email.getValue().trim().isEmpty();

	   // E-mail and phone have specific validators
	   Binding<Person, String> emailBinding = binder.forField(email)
	           .withValidator(phoneOrEmailPredicate,
	                   "Both phone and email cannot be empty")
	           .withValidator(new EmailValidator("Incorrect email address"))
	           .bind(Person::getEmail, Person::setEmail);

	   Binding<Person, String> phoneBinding = binder.forField(phone)
	           .withValidator(phoneOrEmailPredicate,
	                   "Both phone and email cannot be empty")
	           .bind(Person::getPhone, Person::setPhone);

	   // Trigger cross-field validation when the other field is changed
	   email.addValueChangeListener(event -> phoneBinding.validate());
	   phone.addValueChangeListener(event -> emailBinding.validate());

	   // First name and last name are required fields
	   firstName.setRequiredIndicatorVisible(true);
	   lastName.setRequiredIndicatorVisible(true);

	   binder.forField(firstName)
	           .withValidator(new StringLengthValidator(
	                   "Please add the first name", 1, null))
	           .bind(Person::getFirstName, Person::setFirstName);
	   binder.forField(lastName)
	           .withValidator(new StringLengthValidator(
	                   "Please add the last name", 1, null))
	           .bind(Person::getSecondName, Person::setSecondName);

	   // Birthdate and doNotCall don't need any special validators
	   //binder.bind(doNotCall, Person::isDoNotCall, Person::setDoNotCall);
	   binder.bind(birthDate, Person::getBirthDate, Person::setBirthDate);

	   // Click listeners for the buttons
	   save.addClickListener(event -> {
	       if (binder.writeBeanIfValid(personBeingEdited)) {
	           infoLabel.setText("Saved bean values: " + personBeingEdited);
	       } else {
	           BinderValidationStatus<Person> validate = binder.validate();
	           String errorText = validate.getFieldValidationStatuses()
	                   .stream().filter(BindingValidationStatus::isError)
	                   .map(BindingValidationStatus::getMessage)
	                   .map(Optional::get).distinct()
	                   .collect(Collectors.joining(", "));
	           infoLabel.setText("There are errors: " + errorText);
	       }
	   });
	   reset.addClickListener(event -> {
	       // clear fields by setting null
	       binder.readBean(null);
	       infoLabel.setText("");
	       doNotCall.setValue(false);
	   });
	   
	   
	   add(layoutWithBinder, actions, infoLabel);
	   */
	   
	   add(columnLayout, buttonSaved);
	
	}



}
