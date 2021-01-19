package persistence;


import model.common.Doctor;
import model.common.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class DoctorRepository {

    private static EntityManager em;

    public DoctorRepository(){
        em = DBManager.getInstance().getEntityManager();
    }
    /**
     *  Method adds a Doctor to the Database
     */
    public static void addDoctor(Doctor doctor){
        em.getTransaction().begin();
        em.persist(doctor);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Method gets a specific doctor from the Database with a specific ID
     * @param id unique ID
     */
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

    /**
     * Method gets a list of all doctors in the Database.
     */
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

    /**
     * Method removes a doctor from the database with a specific ID
     * @param id unique ID
     */
    public static void removeDoctor(int id){
        EntityTransaction et = null;
        Doctor doc = new Doctor();

        try {
            et = em.getTransaction();
            et.begin();
            doc = (Doctor) em.find(Person.class, id);
            em.remove(doc);
            em.persist(doc);
            et.commit();

        }catch (NoResultException exception){
            exception.printStackTrace();
        }


    }
}

