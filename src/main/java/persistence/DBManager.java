package persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Database manager encapsulates the database connection. A EntityManager
 * singleton is provided by this class.
 */
public class DBManager {

	private static final String PERSISTENCE_UNIT_NAME = "jimen1";
	private static DBManager dbm;
	private EntityManager em;

	static DBManager getInstance() {
		if (dbm == null) {
			dbm = new DBManager();
		}
		return dbm;
	}

	EntityManager getEntityManager() {
		return em;
	}

	private DBManager() {
		this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	// TODO - the following code needs to be extracted into specific repositories. 
	
	// public static void addDoctor(int id, String title, String firstName, String
	// secondName, String location,
	// String phone, String email, boolean gender) {
	// EntityTransaction et = null;
	// try {
	// et = em.getTransaction();
	// et.begin();
	// Doctor doc = new Doctor();
	// doc.setTitle(title);
	// doc.setFirstName(firstName);
	// doc.setSecondName(secondName);
	// doc.setLocation(location);
	// doc.setPhone(phone);
	// doc.setEmail(email);
	// doc.setGender(gender);
	// em.persist(doc);
	// et.commit();
	// } catch (Exception ex) {
	// if (et != null) {
	// et.rollback();
	// }
	// }
	// }
	//
	// public static void getDoctor(int id) {
	// String query = "SELECT d FROM Doctor d WHERE d.id = :docID";
	// TypedQuery<Doctor> tq = em.createQuery(query, Doctor.class);
	// tq.setParameter("docID", id);
	// Doctor doc;
	// try {
	// doc = tq.getSingleResult();
	// System.out.println(doc.getFirstName());
	// } catch (NoResultException exception) {
	// exception.printStackTrace();
	// }
	// }
	//
	// public static void getDoctors() {
	// String strQuery = "SELECT d FROM Doctor d WHERE d.id IS NOT NULL";
	// TypedQuery<Doctor> tq = em.createQuery(strQuery, Doctor.class);
	// List<Doctor> docs;
	// try {
	// docs = tq.getResultList();
	// for (Doctor doc : docs) {
	// System.out.println(doc.getFirstName());
	// }
	// } catch (NoResultException exception) {
	// exception.printStackTrace();
	// }
	// }
	//
	// public static void removeDoctor(int id) {
	//
	// }
	//
	// public static void addPatient(int id, String title, String firstName, String
	// secondName, String phone, String email,
	// boolean gender) {
	// EntityTransaction et = null;
	// try {
	// et = em.getTransaction();
	// et.begin();
	// Patient patient = new Patient();
	// patient.setFirstName(firstName);
	// patient.setSecondName(secondName);
	// patient.setPhone(phone);
	// patient.setEmail(email);
	// patient.setGender(gender);
	// em.persist(patient);
	// et.commit();
	// } catch (Exception ex) {
	// if (et != null) {
	// et.rollback();
	// }
	// }
	// }
	//
	// public static void getPatient(int id) {
	// String query = "SELECT p FROM Patient p WHERE p.id = :patID";
	// TypedQuery<Patient> tq = em.createQuery(query, Patient.class);
	// tq.setParameter("patID", id);
	// Patient pat;
	// try {
	// pat = tq.getSingleResult();
	// System.out.println(pat.getFirstName());
	// } catch (NoResultException exception) {
	// exception.printStackTrace();
	// }
	// }
	//
	// public static void getPatients() {
	// String strQuery = "SELECT p FROM Patient p WHERE p.id IS NOT NULL";
	// TypedQuery<Patient> tq = em.createQuery(strQuery, Patient.class);
	// List<Patient> pats;
	// try {
	// pats = tq.getResultList();
	// for (Patient pat : pats) {
	// System.out.println(pat.getFirstName());
	// }
	// } catch (NoResultException exception) {
	// exception.printStackTrace();
	// }
	// }
	//
	// public static void removePatient(int id) {
	//
	// }

}
