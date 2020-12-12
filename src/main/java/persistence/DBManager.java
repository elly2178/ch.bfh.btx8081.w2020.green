package persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DBManager {

    private static DBManager dbm = null;
    private EntityManager em;
    private static final String PERSISTENCE_UNIT_NAME = "ch.bfh.btx.8081.w2020.green";

    public static DBManager getInstance() {
        if(dbm == null){
            dbm = new DBManager();
        }
        return dbm;
    }

    private DBManager(){
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }
}

