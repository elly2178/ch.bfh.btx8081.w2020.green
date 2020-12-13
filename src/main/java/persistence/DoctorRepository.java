/*
package persistence;

import model.Doctor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class DoctorRepository {

    private static EntityManager em;

    public static void addDoctor(int id, String title, String firstName, String secondName, String location, String phone, String email, boolean gender){
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Doctor doc = new Doctor();
            doc.setTitle(title);
            doc.setFirstName(firstName);
            doc.setSecondName(secondName);
            doc.setLocation(location);
            doc.setPhone(phone);
            doc.setEmail(email);
            doc.setGender(gender);
            em.persist(doc);
            et.commit();
        } catch (Exception ex){
            if(et != null){
                et.rollback();
            }
        }
    }

    public static void getDoctor(int id){
        String query = "SELECT d FROM Doctor d WHERE d.id = :docID";
        TypedQuery<Doctor> tq = em.createQuery(query, Doctor.class);
        tq.setParameter("docID", id);
        Doctor doc;
        try{
            doc = tq.getSingleResult();
            System.out.println(doc.getFirstName());
        }catch(NoResultException exception){
            exception.printStackTrace();
        }
    }

    public static void getDoctors(){
        String strQuery = "SELECT d FROM Doctor d WHERE d.id IS NOT NULL";
        TypedQuery<Doctor> tq = em.createQuery(strQuery, Doctor.class);
        List<Doctor> docs;
        try {
            docs = tq.getResultList();
            for (Doctor doc : docs) {
                System.out.println(doc.getFirstName());
            }
        }catch(NoResultException exception){
            exception.printStackTrace();
        }
    }

    public static void removeDoctor(int id){

    }
}
*/
