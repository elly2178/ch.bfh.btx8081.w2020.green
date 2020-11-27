package view;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("patient")
public class PatientViewImplementation extends VerticalLayout implements IPatientView {
/** 
 * PatientViewImpl rename
 */
	private List<IPatientViewListener> listeners = new ArrayList<IPatientViewListener>();

	public PatientViewImplementation() {
		TextArea textArea = new TextArea("Wilkommen bei der Patient aussicht.");
		textArea.getStyle().set("minWidth", "250px");
		textArea.setPlaceholder("Write someting here");
		add(textArea);

		HorizontalLayout layout1 = new HorizontalLayout();
		layout1.getStyle().set("width", "250px");

		layout1.add(createButton("YSCOB Test"));
		add(layout1);

		HorizontalLayout layout2 = new HorizontalLayout();
		layout2.add(createButton("Tagesbuch"));
		add(layout2);

		HorizontalLayout layout3 = new HorizontalLayout();
		layout3.add(createButton("Stimmung"));
		add(layout3);
	}

	private Button createButton(String opeation) {
		return new Button(opeation, event -> getUI().get().navigate("diary"));
	}

	 void RouterLink() {
		 Div buttonsDiv = new Div();
		 buttonsDiv.add(new RouterLink("Diary", DiariesView.class));
	 }

	@Override
	public void addListener(IPatientViewListener listener) {
		listeners.add(listener);

	}

	@Override
	public void showPID(int pid) {
		// TODO Auto-generated method stub
		
	}

}
