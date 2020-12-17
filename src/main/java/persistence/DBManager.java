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

}
