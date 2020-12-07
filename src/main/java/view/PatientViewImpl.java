package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("patient")
public class PatientViewImpl extends VerticalLayout implements IPatientView {

	private List<IPatientViewListener> listeners = new ArrayList<IPatientViewListener>();

	public PatientViewImpl() {
		Text subtitle = new Text("Wilkommen beim Selbstevaluationstest");
		 
		//labelField.getStyle().set("minWidth", "250px");
		add(subtitle);

		HorizontalLayout layout1 = new HorizontalLayout();
		layout1.getStyle().set("width", "250px");

		layout1.add(createButtonTestButton("YBOCS Test"));
		add(layout1);

		HorizontalLayout layout2 = new HorizontalLayout();
		layout2.add(createButton("Tagebuch"));
		add(layout2);

		HorizontalLayout layout3 = new HorizontalLayout();
		layout3.add(createaButtonMoodButton("Stimmung"));
		add(layout3);
	}

	private Button createaButtonMoodButton(String oString) {
		return new Button(oString, event -> getUI().get().navigate("patient/moodtest"));
	}
	private Button createButtonTestButton(String oString) {
		return new Button(oString, event -> getUI().get().navigate("patient/ybocstest"));
	}
	private Button createButton(String opeation) {
		return new Button(opeation, event -> getUI().get().navigate("diaries"));
	}

	 void RouterLink() {
		 Div buttonsDiv = new Div();
		 buttonsDiv.add(new RouterLink("diaries", DiariesView.class));
		 
		Div buttonYbocsDiv = new Div();
		buttonYbocsDiv.add(new RouterLink("ybocstest", YbocsTestImpl.class));
		
		//Div buttonMoodDiv = new Div();
		//buttonMoodDiv.add(new RouterLink("your path name here", MoodImpl.class));
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
