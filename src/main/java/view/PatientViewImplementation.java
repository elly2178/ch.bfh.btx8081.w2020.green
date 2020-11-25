package view;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class PatientViewImplementation extends VerticalLayout implements IPatientView{

	private TextField displayPID = new TextField();
	
	private List<IPatientViewListener> listeners = new ArrayList<IPatientViewListener>();
	
	public PatientViewImplementation() {
		displayPID.setReadOnly(false);
		add(displayPID);
	
	HorizontalLayout layout1 = new HorizontalLayout();
	layout1.add(createButton("Show: 145"));
	layout1.add(createButton("Reset"));
	add(layout1);
	}
	
	private Button createButton(String opeation) {
		return new Button(opeation, event -> {
			for (IPatientViewListener listener: listeners)
				listener.buttonClick(event.getSource().getText().charAt(0));
		});
	}
	
	@Override
	public void showPID(int pid) {
		displayPID.setValue(Double.toString(pid));
		
	}

	@Override
	public void addListener(IPatientViewListener listener) {
		listeners.add(listener);
		
	}
	

}
