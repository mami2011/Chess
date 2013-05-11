package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ProductSpecification.
 * @see dal.dao.ProductSpecification
 * @author Hibernate Tools
 */
@Stateless
public class ProductSpecificationHome {

	private static final Log log = LogFactory
			.getLog(ProductSpecificationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProductSpecification transientInstance) {
		log.debug("persisting ProductSpecification instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProductSpecification persistentInstance) {
		log.debug("removing ProductSpecification instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProductSpecification merge(ProductSpecification detachedInstance) {
		log.debug("merging ProductSpecification instance");
		try {
			ProductSpecification result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductSpecification findById(int id) {
		log.debug("getting ProductSpecification instance with id: " + id);
		try {
			ProductSpecification instance = entityManager.find(
					ProductSpecification.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
