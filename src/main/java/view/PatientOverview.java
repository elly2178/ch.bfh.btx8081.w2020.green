package view;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.crud.CrudI18n;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

import model.common.Address;
import model.common.Person;

@Route("patientOverview")
public class PatientOverview extends VerticalLayout{
	
	
	/**
	 * 
	private static final long serialVersionUID = 1L;

	TextField filterText = new TextField();
	Button button = new Button("Click me", event -> Notification.show("Clicked!"));

	public PatientOverview() {

		List<Person> personList = new ArrayList<>();
		Grid<Person> grid = new Grid<>(Person.class);	
		
		grid.setItems(personList);
		grid.setColumns("First Name", "Second Name");
		add(button, filterText, grid);
		}	
	 */
	
	 public PatientOverview() {
	        setSizeFull();
	        ListDataProvider<Person> dataProvider = createDataProvider();
	        Crud<Person> crud = new Crud<>(Person.class, createGrid(), createPersonEditor());
	        crud.setMaxWidth("800px");
	        crud.setWidth("100%");
	        crud.setDataProvider(dataProvider);
	        setHorizontalComponentAlignment(Alignment.CENTER, crud);

	        CrudI18n customI18n = CrudI18n.createDefault();
	        customI18n.setEditItem("Update Patient");
	        customI18n.setNewItem("New Patient");
	        crud.setI18n(customI18n);

	        crud.addSaveListener(saveEvent -> {
	            Person toSave = saveEvent.getItem();
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

	    private ListDataProvider<Person> createDataProvider() {
	        List<Person> data = new ArrayList<>();
	        //data.add(new Person("Tim", "Frazier", "15.02.1996", "m", "3000", "Bernstrasse 54", "Bern", "Switzerland", "tim.frz@gmail.com", "(972) 924-7669"));
	        //data.add(new Person("Fallen", "Myrfors", "15.02.1986", "m", "3000", "Gurnigelweg 1","Gurnigel", "Switzerland", "F.myrfors@gmail.com", "(972) 924-7669"));
	        //data.add(new Person("Brian", "Snøddy", "15.02.1999", "m", "3000", "Burgdorfstrasse 88", "Burgdorf", "Switzerland", "brians1@gmail.com", "(972) 924-7669")); 
	        //data.add(new Person("Susan", "Van Camp", "15.02.1977", "f", "3000", "Thunstrasse 2", "Thun", "Switzerland", "susan19@gmail.com", "(972) 924-7669"));
	        //data.add(new Person("Liz", "Danforth", "15.02.1992", "f", "3000", "Bahstrasse 23", "Biel", "Switzerland", "lizd@hotmail.com", "(972) 924-7669"));

	        return new ListDataProvider<>(data);
	    }

	    private Grid<Person> createGrid() {
	        Grid<Person> grid = new Grid<>();
	        grid.addColumn(c -> c.getFirstName()).setHeader("First name")
	                .setWidth("160px");
	        grid.addColumn(c -> c.getSecondName()).setHeader("Last name");
	        grid.addColumn(c -> c.isGender()).setHeader("Gender");
	        grid.addColumn(c -> c.getBirthDate()).setHeader("Birthdate");
	        grid.addColumn(c -> c.getPhone()).setHeader("Phone");
	        Crud.addEditColumn(grid);
	        return grid;
	    }

	    private CrudEditor<Person> createPersonEditor() {
	        TextField firstName = new TextField("First name");
	        firstName.setRequiredIndicatorVisible(true);
	        setColspan(firstName, 2);
	        
	        TextField secondName = new TextField("Last name");
	        secondName.setRequiredIndicatorVisible(true);
	        setColspan(secondName, 2);
	        
	        ComboBox<String> gender = new ComboBox<>();
	        gender.setAllowCustomValue(true);
	        gender.setLabel("Gender");
	        setColspan(gender, 2);
	        gender.setItems("female", "male", "other");
	        
	        TextField birthDate = new TextField("Date of birth");
	        birthDate.setRequiredIndicatorVisible(true);
	        setColspan(birthDate, 2);
	        
	        EmailField email = new EmailField("Contact E-mail");
	        setColspan(email, 2);
	        email.setRequiredIndicatorVisible(true);

	        TextField address = new TextField("Address");
	        setColspan(address, 2);

	        TextField city = new TextField("City");
	        TextField zip = new TextField("Postal code");

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

	        Binder<Person> binder = new Binder<>(Person.class);
	        binder.bind(firstName, Person::getFirstName, Person::setFirstName);
	        binder.bind(secondName, Person::getSecondName, Person::setSecondName);
	        binder.bind(email, Person::getEmail, Person::setEmail);
	        //binder.bind(address, Person::getAddress, Person::setAddress);
	        //binder.bind(city, Person::getCity, Person::setCity);
	        //binder.bind(zip, Person::getZip, Person::setZip);
	        //binder.bind(country, Person::getCountry, Person::setCountry);
	        binder.bind(phone, Person::getPhone, Person::setPhone);

	        return new BinderCrudEditor<>(binder, form);
	    }

	    private void setColspan(Component component, int colspan) {
	        component.getElement().setAttribute("colspan", Integer.toString(colspan));
	    }

	    private List<String> getCountriesList() {
	        return Stream.of(Locale.getISOCountries())
	                .map(iso -> new Locale("", iso).getDisplayCountry()).sorted()
	                .collect(Collectors.toList());
	    }
	
		

}