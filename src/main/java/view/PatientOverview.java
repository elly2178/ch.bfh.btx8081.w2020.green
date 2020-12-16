package view;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.crud.CrudI18n;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Binder.Binding;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;

import model.Patient;
import view.common.MainLayout;

@Route(value = "patientOverview", layout = MainLayout.class)
public class PatientOverview extends VerticalLayout{
	
	
	/**
	 * 
	private static final long serialVersionUID = 1L;
	TextField filterText = new TextField();
	Button button = new Button("Click me", event -> Notification.show("Clicked!"));
	public PatientOverview() {
		List<Patient> PatientList = new ArrayList<>();
		Grid<Patient> grid = new Grid<>(Patient.class);	
		grid.setItems(PatientList);
		grid.setColumns("First Name", "Second Name");
		add(button, filterText, grid);
		}	
	 */
	
	 public PatientOverview() {
	        setSizeFull();
	        ListDataProvider<Patient> dataProvider = createDataProvider();
	        Crud<Patient> crud = new Crud<>(Patient.class, createGrid(), createPatientEditor());
	        crud.setMaxWidth("800px");
	        crud.setWidth("100%");
	        crud.setDataProvider(dataProvider);
	        setHorizontalComponentAlignment(Alignment.CENTER, crud);
	        
	        CrudI18n customI18n = CrudI18n.createDefault();
	        customI18n.setEditItem("Update Patient");
	        customI18n.setNewItem("Add new Patient");
	        crud.setI18n(customI18n);
			
	        crud.addSaveListener(saveEvent -> {
	            Patient toSave = saveEvent.getItem();
	            // Save the item in the database
	            if (!dataProvider.getItems().contains(toSave)) {
	                dataProvider.getItems().add(toSave);
	            }
	        });
	        /*
	        toSave.addClickListener(event -> {
	            if (binder.writeBeanIfValid(contactBeingEdited)) {
	                infoLabel.setText("Saved bean values: " + contactBeingEdited);
	            } else {
	                BinderValidationStatus<Contact> validate = binder.validate();
	                String errorText = validate.getFieldValidationStatuses()
	                        .stream().filter(BindingValidationStatus::isError)
	                        .map(BindingValidationStatus::getMessage)
	                        .map(Optional::get).distinct()
	                        .collect(Collectors.joining(", "));
	                infoLabel.setText("There are errors: " + errorText);
	            }
	        });
			*/
	        crud.addDeleteListener(deleteEvent -> {
	            // Delete the item in the database
	            dataProvider.getItems().remove(deleteEvent.getItem());
	        });
	        
	

	        add(crud);
	    }

	    private ListDataProvider<Patient> createDataProvider() {
	        List<Patient> data = new ArrayList<>();
	        //data.add(new Patient("Tim", "Frazier", "15.02.1996", "m", "3000", "Bernstrasse 54", "Bern", "Switzerland", "tim.frz@gmail.com", "(972) 924-7669"));
	        //data.add(new Patient("Fallen", "Myrfors", "15.02.1986", "m", "3000", "Gurnigelweg 1","Gurnigel", "Switzerland", "F.myrfors@gmail.com", "(972) 924-7669"));
	        //data.add(new Patient("Brian", "Snøddy", "15.02.1999", "m", "3000", "Burgdorfstrasse 88", "Burgdorf", "Switzerland", "brians1@gmail.com", "(972) 924-7669")); 
	        //data.add(new Patient("Susan", "Van Camp", "15.02.1977", "f", "3000", "Thunstrasse 2", "Thun", "Switzerland", "susan19@gmail.com", "(972) 924-7669"));
	        //data.add(new Patient("Liz", "Danforth", "15.02.1992", "f", "3000", "Bahstrasse 23", "Biel", "Switzerland", "lizd@hotmail.com", "(972) 924-7669"));

	        return new ListDataProvider<>(data);
	    }

	    private Grid<Patient> createGrid() {
	        Grid<Patient> grid = new Grid<>();
	        grid.addColumn(c -> c.getFirstName()).setHeader("First name");
	        grid.addColumn(c -> c.getSecondName()).setHeader("Last name");
	        grid.addColumn(c -> c.isGender()).setHeader("Gender");
	        grid.addColumn(c -> c.getBirthDate()).setHeader("Date of birth");
	        grid.addColumn(c -> c.getPhone()).setHeader("Phone");
	        grid.addColumn(c -> c.calculateAvarageScore()).setHeader("Average score");
	        Crud.addEditColumn(grid);
	        return grid;
	    }
	    
	    // Add a new patient
	    private CrudEditor<Patient> createPatientEditor() {
	        TextField firstName = new TextField("First name");
	        firstName.setRequiredIndicatorVisible(true);
	        setColspan(firstName, 2);
	        
	        TextField secondName = new TextField("Last name");
	        secondName.setRequiredIndicatorVisible(true);
	        setColspan(secondName, 2);
	        
	        ComboBox<String> gender = new ComboBox<>();
	        gender.setAllowCustomValue(true);
	        gender.setRequiredIndicatorVisible(true);
	        gender.setLabel("Gender");
	        setColspan(gender, 2);
	        gender.setItems("female", "male", "other");
	        
	        DatePicker birthDate = new DatePicker("Date of birth");
	        birthDate.setRequiredIndicatorVisible(true);
	        setColspan(birthDate, 2);
	        
	        EmailField email = new EmailField("E-mail");
	        setColspan(email, 2);
	        email.setRequiredIndicatorVisible(true);

	        TextField address = new TextField("Street and number");
	        setColspan(address, 2);

	        TextField city = new TextField("City");
	        NumberField zip = new NumberField("Postal code");

	        ComboBox<String> country = new ComboBox<>();
	        country.setAllowCustomValue(true);
	        country.setLabel("Country");
	        setColspan(country, 2);
	        country.setItems(getCountriesList());

	        TextField phone = new TextField("Phone");
	        setColspan(phone, 2);
	        phone.setRequiredIndicatorVisible(true);

	        FormLayout form = new FormLayout(firstName, secondName, gender, birthDate, email,
	                address, city, zip, country, phone);
	        form.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 4));

	        Binder<Patient> binder = new Binder<>(Patient.class);
	        binder.bind(firstName, Patient::getFirstName, Patient::setFirstName);
	        binder.bind(secondName, Patient::getSecondName, Patient::setSecondName);
	        //binder.bind(gender, Patient::getGender, Patient::isGender);
	        binder.bind(birthDate, Patient::getBirthDate, Patient::setBirthDate);
	        binder.bind(email, Patient::getEmail, Patient::setEmail);
	        //binder.bind(street, Address::getStreet, Address::setStreet);
	        //binder.bind(city, Address::getCity, Address::setCity);
	        //binder.bind(postalCode, Address::getZip, Address::setZip);
	        //binder.bind(country, Address::getCountry, Address::setCountry);
	        binder.bind(phone, Patient::getPhone, Patient::setPhone);
	        
	        // First name, last name, date of birth and gender are required fields
	        binder.forField(firstName)
	                .withValidator(new StringLengthValidator(
	                        "Please add the first name", 1, null))
	                .bind(Patient::getFirstName, Patient::setFirstName);
	        binder.forField(secondName)
	                .withValidator(new StringLengthValidator(
	                        "Please add the last name", 1, null))
	                .bind(Patient::getSecondName, Patient::setSecondName);
	        
	        SerializablePredicate<String> phoneOrEmailPredicate = value -> 
	        	!email.getValue().trim().isEmpty();
	        
	        // E-mail and phone have specific validators
	        Binding<Patient, String> emailBinding = binder.forField(email)
	                .withValidator(new EmailValidator("Incorrect email address"))
	                .bind(Patient::getEmail, Patient::setEmail);

	       
	        

	        return new BinderCrudEditor<>(binder, form);

	        
	    }

	    private void setColspan(Component component, int colspan) {
	        component.getElement().setAttribute("colspan", Integer.toString(colspan));
	    }
	    
	    // List of all countries
	    private List<String> getCountriesList() {
	        return Stream.of(Locale.getISOCountries())
	                .map(iso -> new Locale("", iso).getDisplayCountry()).sorted()
	                .collect(Collectors.toList());
	    }
	
		

}