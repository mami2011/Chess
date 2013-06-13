package dal.dao;

// Generated May 10, 2013 2:06:06 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MlCategories.
 * @see dal.dao.MlCategories
 * @author Hibernate Tools
 */
@Stateless
public class MlCategoriesHome {

	private static final Log log = LogFactory.getLog(MlCategoriesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MlCategories transientInstance) {
		log.debug("persisting MlCategories instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MlCategories persistentInstance) {
		log.debug("removing MlCategories instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MlCategories merge(MlCategories detachedInstance) {
		log.debug("merging MlCategories instance");
		try {
			MlCategories result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MlCategories findById(Integer id) {
		log.debug("getting MlCategories instance with id: " + id);
		try {
			MlCategories instance = entityManager.find(MlCategories.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
