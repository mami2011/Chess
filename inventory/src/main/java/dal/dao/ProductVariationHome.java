package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ProductVariation.
 * @see dal.dao.ProductVariation
 * @author Hibernate Tools
 */
@Stateless
public class ProductVariationHome {

	private static final Log log = LogFactory
			.getLog(ProductVariationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProductVariation transientInstance) {
		log.debug("persisting ProductVariation instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProductVariation persistentInstance) {
		log.debug("removing ProductVariation instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProductVariation merge(ProductVariation detachedInstance) {
		log.debug("merging ProductVariation instance");
		try {
			ProductVariation result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductVariation findById(int id) {
		log.debug("getting ProductVariation instance with id: " + id);
		try {
			ProductVariation instance = entityManager.find(
					ProductVariation.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
