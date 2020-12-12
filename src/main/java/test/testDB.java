package test;

import common.Address;
import model.Doctor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class testDB {

    private static final String PERSISTENCE_UNIT_NAME = "doctor";
    private EntityManager em;
    private Object Address;
    private Object Doctor;

    public testDB() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    public void setUp() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query q = em.createQuery("select d from Doctor d");

        boolean createNewEntries = (q.getResultList().size() == 0);

        if(createNewEntries){
            Doctor d = new Doctor();
            em.persist(Doctor);
            d.setTitle("Prof. dr.");
            d.setFirstName("Norman");
            d.setSecondName("Benkert");
            d.setGender(false);
            d.setAddress(null);
            d.setEmail("nobe@leafdoctors.io");
            d.setPhone("+417978789");

            em.persist(d);
        }

        em.flush();
        transaction.commit();
    }

    public void checkAvailablePeople(){}
    Query q = em.createQuery("select d from Doctor d");

    public void close(){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query q = em.createNativeQuery("SHUTDOWN COMPACT");
        q.executeUpdate();
        em.flush();
        transaction.commit();
        em.close();
    }

    public static void main(String[] args) {
        testDB test = new testDB();
        test.setUp();
        test.checkAvailablePeople();
        test.close();
    }
}
