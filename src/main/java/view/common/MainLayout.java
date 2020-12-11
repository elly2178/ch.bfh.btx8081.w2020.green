package view.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.StreamResource;

/**
 * Common layout for all views.
 */
public class MainLayout extends VerticalLayout implements RouterLayout {
	private static final String PATH_HEADER_IMAGE = "src/main/webapp/WEB-INF/images/leaf_doctors.png";

	public MainLayout() {
		addHeaderImage();
	}

	private void addHeaderImage() {
		try {
			File file = new File(PATH_HEADER_IMAGE);
			byte[] fileContent = Files.readAllBytes(file.toPath());
			StreamResource resource = new StreamResource("leaf_doctors.png",
					() -> new ByteArrayInputStream(fileContent));
			Image image = new Image(resource, "leaf_doctors");
			image.setWidth("400px");
			image.addClickListener(e -> navigateTo(""));
			add(image);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void navigateTo(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}
}