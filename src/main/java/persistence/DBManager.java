package persistence;

import model.Doctor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import model.*;

public class DBManager {

    private static DBManager dbm = null;
    private static EntityManager em;
    private static final String PERSISTENCE_UNIT_NAME = "ch.bfh.btx.8081.w2020.green";

    String url = "jdbc:postgresql://147.87.116.2013/jimen1";

    Properties props = new Properties();


    public static DBManager getInstance() {
        if(dbm == null){
            dbm = new DBManager();
        }
        return dbm;
    }

    private DBManager(){
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

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

}

