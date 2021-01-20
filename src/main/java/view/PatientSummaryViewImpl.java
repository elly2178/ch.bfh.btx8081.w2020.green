package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.crud.CrudI18n;
import com.vaadin.flow.component.crud.CrudVariant;
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

import model.common.Address;
import model.common.Patient;
import view.common.MainLayout;

/**
 * View class of the patient overview and the pop-up to add a new patient.
 */

@Route(value = "patientSummary", layout = MainLayout.class)
public class PatientSummaryViewImpl extends VerticalLayout implements PatientSummaryView {
	
	private List<PatientSummarySaveListener> listeners = new ArrayList<>();
	private Crud<Patient> crud;
	
	 public PatientSummaryViewImpl() {
	        setSizeFull();
	        ListDataProvider<Patient> dataProvider = createDataProvider();
	        Crud<Patient> crud = new Crud<>(Patient.class, createGrid(), createPatientEditor());
	        crud.setMaxWidth("1000px");
	        crud.setWidth("100%");
	        crud.setDataProvider(dataProvider);
	        setHorizontalComponentAlignment(Alignment.CENTER, crud);
	        
	        
	        CrudI18n customI18n = CrudI18n.createDefault();
	        customI18n.setEditItem("Update patient");
	        customI18n.setNewItem("Add new patient");
	        crud.setI18n(customI18n);
	        
	        crud.addSaveListener(e -> listeners.forEach(event -> event.onComponentEvent(e)));
			
	        crud.addSaveListener(saveEvent -> {
	          Patient toSave = saveEvent.getItem();
	          // Save the item in the database
	           if (!dataProvider.getItems().contains(toSave)) {
	                dataProvider.getItems().add(toSave);
	           }
	        });
	      

	        crud.addDeleteListener(deleteEvent -> {
	            // Delete the item in the database
	            dataProvider.getItems().remove(deleteEvent.getItem());
	        });
	        
	        add(crud);
	    }

	    private ListDataProvider<Patient> createDataProvider() {
	        List<Patient> data = new ArrayList<>();
	        data.add(new Patient(10, "Tim", "Frazier", "01.09.1996", "male", new Address(3000, "Bernstrasse 54", "Bern", "Schweiz"), "tim.frz@gmail.com", "972 9247669", "Helsana", "4653"));
	        data.add(new Patient(11, "Fallen", "Myrfors", "15.11.1986", "male", new Address(3021, "Gurnigelweg 1","Gurnigel", "Schweiz"), "F.myrfors@gmail.com", "031 9244469", "Atupri", "1290"));
	        data.add(new Patient(12, "Brian", "Snøddy", "18.05.1999", "male", new Address(3099, "Burgdorfstrasse 88", "Burgdorf", "Schweiz"), "brians1@gmail.com", "032 9247611", "Swica", "993")); 
	        data.add(new Patient(13, "Susan", "Van Camp", "12.12.1977", "female", new Address(3123, "Thunstrasse 2", "Thun", "Schweiz"), "susan19@gmail.com", "044 9243369", "Assura", "2345"));
	        data.add(new Patient(14, "Liz", "Danforth", "15.02.1992", "female", new Address(3001, "Bahnstrasse 23", "Biel", "Schweiz"), "lizd@hotmail.com", "032 9247611", "Concordia", "9583"));

	        return new ListDataProvider<>(data);
	    }

	    private Grid<Patient> createGrid() {
	        Grid<Patient> grid = new Grid<>();
	        grid.addColumn(c -> c.getPatientId()).setHeader("Patient ID");
	        grid.addColumn(c -> c.getFirstName()).setHeader("First name");
	        grid.addColumn(c -> c.getSecondName()).setHeader("Last name");
	        grid.addColumn(c -> c.isGender()).setHeader("Gender");
	        grid.addColumn(c -> c.getBirthDate()).setHeader("Date of birth");
	        //grid.addColumn(c -> c.getPhone()).setHeader("Phone");
	        grid.addColumn(c -> c.calculateAvarageScore()).setHeader("Average score");
	        Crud.addEditColumn(grid);
	        return grid;
	    }
	    
	    // Add a new patient
	    private CrudEditor<Patient> createPatientEditor() {
	        // Attribute: first name 
	    	TextField firstName = new TextField("First name");
	        firstName.setRequiredIndicatorVisible(true);
	        setColspan(firstName, 2);
	        // Attribute: seconde name
	        TextField secondName = new TextField("Last name");
	        secondName.setRequiredIndicatorVisible(true);
	        setColspan(secondName, 2);
	       	// Attribute: gender
	        ComboBox<String> gender = new ComboBox<>();
	        gender.setAllowCustomValue(true);
	        gender.setRequiredIndicatorVisible(true);
	        gender.setLabel("Gender");
	        setColspan(gender, 2);
	        gender.setItems("female", "male", "other");
	        // Attribute: date of birth
	        DatePicker birthDate = new DatePicker("Date of birth");
	        birthDate.setRequiredIndicatorVisible(true);
	        //birthDate.setMaxDate("getDate");
	        setColspan(birthDate, 2);
	        // Attribute: patient's e-mail
	        EmailField email = new EmailField("E-mail");
	        setColspan(email, 2);
	        email.setRequiredIndicatorVisible(true);
	        // Attribute: patient's address (street and number)
	        TextField street = new TextField("Street and number");
	        setColspan(street, 2);
	        street.setRequiredIndicatorVisible(true);
	        // Attribute: patient's address (city)
	        TextField city = new TextField("City");
	        setColspan(city, 2);
	        city.setRequiredIndicatorVisible(true);
	        // Attribute: patient's address (postal code)
	        NumberField zip = new NumberField("Postal code");
	        zip.setRequiredIndicatorVisible(true);
	        setColspan(zip, 2);
	        // Attribute: patient's address (country)
	        ComboBox<String> country = new ComboBox<>();
	        country.setAllowCustomValue(true);
	        country.setLabel("Country");
	        setColspan(country, 2);
	        country.setItems(getCountriesList());
	        // Attribute: phone
	        TextField phone = new TextField("Phone");
	        setColspan(phone, 2);
	        phone.setRequiredIndicatorVisible(true);
	        // Attribute: patient insurance
	        ComboBox<String> patientInsurance = new ComboBox<>();
	        patientInsurance.setAllowCustomValue(true);
	        patientInsurance.setRequiredIndicatorVisible(true);
	        patientInsurance.setLabel("Health Insurance");
	        setColspan(patientInsurance, 2);
	        patientInsurance.setItems("Assura", "Atupri", "Concordia", "Groupe Mutuel", "Helsana", "Sanitas", "Swica", "Visana", "other");
	        // Attribute: patient insurance ID
	        TextField patientInsuranceId = new TextField("Patient insurance ID number");
	        setColspan(patientInsuranceId, 2);
	        patientInsuranceId.setRequiredIndicatorVisible(true);
	        
	        

	        FormLayout form = new FormLayout(firstName, secondName, gender, birthDate, email, phone, street, zip, city, country, 
	        		patientInsurance, patientInsuranceId);
	        form.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 4));

	        Binder<Patient> binder = new Binder<>(Patient.class);
	        //binder.bind(patientId, Patient::getPatientId, Patient::setPatientId);
	        binder.bind(firstName, Patient::getFirstName, Patient::setFirstName);
	        binder.bind(secondName, Patient::getSecondName, Patient::setSecondName);
	        //binder.bind(gender, Patient::getGender, Patient::isGender);
	        //binder.bind(birthDate, Patient::getBirthDate, Patient::setBirthDate);
	        binder.bind(email, Patient::getEmail, Patient::setEmail);
	        //binder.bind(street, Address::getStreet, Address::setStreet);
	        //binder.bind(city, Address::getCity, Address::setCity);
	        //binder.bind(postalCode, Address::getZip, Address::setZip);
	        //binder.bind(country, Address::getCountry, Address::setCountry);
	        binder.bind(phone, Patient::getPhone, Patient::setPhone);
	        binder.bind(patientInsurance, Patient::getPatientInsurance, Patient::setPatientInsurance);
	        binder.bind(patientInsuranceId, Patient::getPatientInsuranceId, Patient::setPatientInsuranceId);
	        
	        
	        // First name and last name are required fields
	        binder.forField(firstName)
	                .withValidator(new StringLengthValidator(
	                        "Please add the first name", 1, null))
	                .bind(Patient::getFirstName, Patient::setFirstName);
	        
	        binder.forField(secondName)
	                .withValidator(new StringLengthValidator(
	                        "Please add the last name", 1, null))
	                .bind(Patient::getSecondName, Patient::setSecondName);
	        
	        /**binder.forField(birthDate)
            		.withValidator(new StringLengthValidator(
            				"Please add the birthdate", 1, null))
            		.bind(Patient::getBirthDate, Patient::setBirthDate);
	        */

	        // E-mail and phone have specific validators
	        SerializablePredicate<String> phoneOrEmailPredicate = value -> 
	        	!email.getValue().trim().isEmpty();
	        		        
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
	    
	    @Override
	    public void addListener(PatientSummarySaveListener listener) {
	    	listeners.add(listener);
	    }
	    
	    @Override
	    public Crud<Patient> getCrud() {
	    	return crud;
	    }
}