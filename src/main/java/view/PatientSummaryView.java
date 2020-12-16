package view;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.Crud.DeleteEvent;
import com.vaadin.flow.component.crud.Crud.SaveEvent;

import model.common.Patient;

/**
 * Interface defines interactions inside the patient summary view.
 */
public interface PatientSummaryView {

	/**
	 * Listener interface recognizes save patients events.
	 */
	interface PatientSummarySaveListener extends ComponentEventListener<SaveEvent<Patient>> {
	}

	/**
	 * Listener interface recognizes delete patients events.
	 */
	interface PatientSummaryDeleteListener extends ComponentEventListener<DeleteEvent<Patient>> {
	}

	public void addListener(PatientSummarySaveListener listener);
	public Crud<Patient> getCrud();
}