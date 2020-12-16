package presenter;

import com.vaadin.flow.component.crud.Crud.SaveEvent;

import model.PatientSummaryModel;
import model.common.Patient;
import view.PatientSummaryView;

/**
 * Presenter class links the view and the model.
 */
public class PatientSummaryPresenter
		implements PatientSummaryView.PatientSummarySaveListener { //, PatientSummaryView.PatientSummaryDeleteListener {

	private PatientSummaryModel model;
	private PatientSummaryView view;
	
	public PatientSummaryPresenter(PatientSummaryModel model, PatientSummaryView view) {
		this.model = model;
		this.view = view;
		this.view.addListener(this);
	}

	@Override
	public void onComponentEvent(SaveEvent<Patient> event) {
		model.savePatient(event.getItem());
	}
}