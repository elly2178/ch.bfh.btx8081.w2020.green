package model;

import model.common.Patient;
import persistence.PatientRepository;

/**
 * Model class handles patient summary actions like save, edit, remove
 */
public class PatientSummaryModel {
	
	private PatientRepository patientRepository;
	
	public PatientSummaryModel() {
		patientRepository = new PatientRepository();
	}
	
	/**
	 * Persists a patient in the database.
	 * @param patient the patient to save.
	 */
	public void savePatient(Patient patient) {
		System.out.println("savePatient()");
		patientRepository.addPatient(patient);
	}
}