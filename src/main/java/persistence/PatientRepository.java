package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.common.Patient;

/**
 * Repository provides database functions for patient data.
 */
public class PatientRepository {

	private EntityManager em;

	/**
	 * Constructor inits class.
	 */
	public PatientRepository() {
		em = DBManager.getInstance().getEntityManager();
	}

	/**
	 * Saves the given patient.
	 * @param patient the patient to store in database.
	 */
	public void addPatient(Patient patient) {
		em.getTransaction().begin();
		em.persist(patient);
		em.getTransaction().commit();
		em.close();
	}

	public void getPatient(int id) {
		try {
			String query = "SELECT p FROM Patient p WHERE p.id = :patID";
			TypedQuery<Patient> tq = em.createQuery(query, Patient.class);
			tq.setParameter("patID", id);
			Patient pat;
			pat = tq.getSingleResult();
			System.out.println(pat.getFirstName());
		} catch (NoResultException exception) {
			exception.printStackTrace();
			// TODO - throw error ("Patient with ID x not found");
		}
	}

	public List<Patient> getPatients() {
		TypedQuery<Patient> tq = em.createQuery("SELECT p FROM Patient p", Patient.class);
		List<Patient> pats = tq.getResultList();
		for (Patient pat : pats) {
			System.out.println(pat.getFirstName());
		}
		return pats;
	}

	public void removePatient(int id) {

	}
}
