package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MerchantProductDescription.
 * @see dal.dao.MerchantProductDescription
 * @author Hibernate Tools
 */
@Stateless
public class MerchantProductDescriptionHome {

	private static final Log log = LogFactory
			.getLog(MerchantProductDescriptionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MerchantProductDescription transientInstance) {
		log.debug("persisting MerchantProductDescription instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MerchantProductDescription persistentInstance) {
		log.debug("removing MerchantProductDescription instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MerchantProductDescription merge(
			MerchantProductDescription detachedInstance) {
		log.debug("merging MerchantProductDescription instance");
		try {
			MerchantProductDescription result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MerchantProductDescription findById(int id) {
		log.debug("getting MerchantProductDescription instance with id: " + id);
		try {
			MerchantProductDescription instance = entityManager.find(
					MerchantProductDescription.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
