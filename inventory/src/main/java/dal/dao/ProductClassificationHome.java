package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ProductClassification.
 * @see dal.dao.ProductClassification
 * @author Hibernate Tools
 */
@Stateless
public class ProductClassificationHome {

	private static final Log log = LogFactory
			.getLog(ProductClassificationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProductClassification transientInstance) {
		log.debug("persisting ProductClassification instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProductClassification persistentInstance) {
		log.debug("removing ProductClassification instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProductClassification merge(ProductClassification detachedInstance) {
		log.debug("merging ProductClassification instance");
		try {
			ProductClassification result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductClassification findById(int id) {
		log.debug("getting ProductClassification instance with id: " + id);
		try {
			ProductClassification instance = entityManager.find(
					ProductClassification.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
