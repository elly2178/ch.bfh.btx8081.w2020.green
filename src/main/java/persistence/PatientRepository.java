package persistence;

import model.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

//TO BE ALLOCATED PROPERLY
public class PatientRepository {

    private static EntityManager em;

    public static void addPatient(int id, String title, String firstName, String secondName, String phone, String email, boolean gender){
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Patient patient = new Patient();
            patient.setFirstName(firstName);
            patient.setSecondName(secondName);
            patient.setPhone(phone);
            patient.setEmail(email);
            patient.setGender(gender);
            em.persist(patient);
            et.commit();
        } catch (Exception ex){
            if(et != null){
                et.rollback();
            }
        }
    }

    public static void getPatient(int id){
        String query = "SELECT p FROM Patient p WHERE p.id = :patID";
        TypedQuery<Patient> tq = em.createQuery(query, Patient.class);
        tq.setParameter("patID", id);
        Patient pat;
        try{
            pat = tq.getSingleResult();
            System.out.println(pat.getFirstName());
        }catch(NoResultException exception){
            exception.printStackTrace();
        }
    }

    public static void getPatients(){
        String strQuery = "SELECT p FROM Patient p WHERE p.id IS NOT NULL";
        TypedQuery<Patient> tq = em.createQuery(strQuery, Patient.class);
        List<Patient> pats;
        try {
            pats = tq.getResultList();
            for (Patient pat : pats) {
                System.out.println(pat.getFirstName());
            }
        }catch(NoResultException exception){
            exception.printStackTrace();
        }
    }

    public static void removePatient(int id){

    }
}
