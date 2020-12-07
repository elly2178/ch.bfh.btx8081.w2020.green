package presenter;

import model.Patient;
import view.IPatientView;

public class PatientPresenter implements IPatientView.IPatientViewListener {

	private Patient model;
	private IPatientView view;
	private int ipdValue = 0;
	private String reset = "Reset";
	
	public PatientPresenter(Patient model, IPatientView view) {
		this.model = model;
		this.view = view;
		
		view.showPID(ipdValue);
		view.addListener(this);
	}
	@Override
	public void buttonClick(char opeation) {
		// add meth

		}
		
	}
	


