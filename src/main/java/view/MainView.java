package view;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import model.LoginModel;
import presenter.LoginPresenter;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Vaadin Main Page", shortName = "Home")
public class MainView extends VerticalLayout {
	private static final long serialVersionUID = 1373875260083544921L;
	private transient LoginModel loginModel = new LoginModel();
	private LoginViewImpl loginView = new LoginViewImpl();

	public MainView() {
		addHeaderImage();
		new LoginPresenter(loginModel, loginView, this);
		add(loginView);
	}

	public void createNavigation() {
		HomeView homeView = new HomeView();
		remove(loginView);
		add(homeView);
	}

	private void navigateTo(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}

	private void addHeaderImage() {
//		try {
//			URL path = VaadinService.getCurrent().getStaticResource("/ch.bfh.btx8081.w2020.green/src/main/resources/META-INF/leaf_doctors.png");
//			BufferedImage image = ImageIO.read(path);
//			Image header = new Image(image, "bla");
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}

		// https://memorynotfound.com/java-read-image-file-url-classpath-inputstream/
		Image headerImage = new Image();
		headerImage.setSrc("/ch.bfh.btx8081.w2020.green/src/main/resources/META-INF/leaf_doctors.png");
		headerImage.addClickListener(e -> navigateTo(""));
		add(headerImage);
	}
}
