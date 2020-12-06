package view;

import java.time.LocalDate;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import common.Address;
import model.PatientModel;
import model.UserSessionModel;
import presenter.LoginPresenter;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Vaadin Main Page", shortName = "Home")
public class MainView extends VerticalLayout {
	private static final long serialVersionUID = 1373875260083544921L;
	private transient UserSessionModel userSessionModel = new UserSessionModel();
	private LoginViewImpl loginView = new LoginViewImpl();

	public MainView() {
		addHeaderImage();

		new LoginPresenter(userSessionModel, loginView, this);
		add(loginView);
		// addMenuBar();
		//
		// VerticalLayout vertical = new VerticalLayout();
		// HorizontalLayout horizontal = new HorizontalLayout();
		// vertical.add(horizontal);
		// horizontal.add(new TextField("Patient Search"));
		// horizontal.add(new TextField("+ Add New Patient"));
		// Button button = new Button("Click me", event ->
		// Notification.show("Clicked!"));
		// add(vertical, button);

		// added new lines ( 33 to 36 )
		Address patAddress = new Address(2502, "Freistrasse", "Biel", "Schweiz");
		LocalDate birthDate = LocalDate.of(1989, 05, 18);
		PatientModel model = new PatientModel("Georgiana", "Dumitru", birthDate, false, patAddress, "random@email.com");
	}

	public void createNavigation() {
		HomeView homeView = new HomeView(userSessionModel);
		remove(loginView);
		add(homeView);
	}

	private void navigateTo(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}

	private void addHeaderImage() {
		// https://memorynotfound.com/java-read-image-file-url-classpath-inputstream/
		Image headerImage = new Image("/ch.bfh.btx8081.w2020.green/src/main/resources/leaf_doctors.png", "leafDoctors");
		headerImage.addClickListener(e -> navigateTo(""));
		add(headerImage);
	}
}
