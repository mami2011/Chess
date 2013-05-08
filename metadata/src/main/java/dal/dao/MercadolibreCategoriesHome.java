package dal.dao;

// Generated May 8, 2013 9:53:22 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MercadolibreCategories.
 * @see dal.dao.MercadolibreCategories
 * @author Hibernate Tools
 */
@Stateless
public class MercadolibreCategoriesHome {

	private static final Log log = LogFactory
			.getLog(MercadolibreCategoriesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MercadolibreCategories transientInstance) {
		log.debug("persisting MercadolibreCategories instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MercadolibreCategories persistentInstance) {
		log.debug("removing MercadolibreCategories instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MercadolibreCategories merge(MercadolibreCategories detachedInstance) {
		log.debug("merging MercadolibreCategories instance");
		try {
			MercadolibreCategories result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MercadolibreCategories findById(Integer id) {
		log.debug("getting MercadolibreCategories instance with id: " + id);
		try {
			MercadolibreCategories instance = entityManager.find(
					MercadolibreCategories.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
