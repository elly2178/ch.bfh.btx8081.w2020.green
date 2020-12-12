package view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import view.common.MainLayout;

/**
 * The main view contains a button and a click listener.
 */
@Route(value = "", layout = MainLayout.class)
@PWA(name = "Vaadin Main Page", shortName = "Home")
public class MainView extends VerticalLayout {
	private static final long serialVersionUID = 1373875260083544921L;

}
