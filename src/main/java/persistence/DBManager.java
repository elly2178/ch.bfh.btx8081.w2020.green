package persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBManager {

    private static DBManager dbm = null;
    private EntityManager em;
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


}

