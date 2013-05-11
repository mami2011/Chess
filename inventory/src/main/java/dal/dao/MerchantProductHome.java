package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MerchantProduct.
 * @see dal.dao.MerchantProduct
 * @author Hibernate Tools
 */
@Stateless
public class MerchantProductHome {

	private static final Log log = LogFactory.getLog(MerchantProductHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MerchantProduct transientInstance) {
		log.debug("persisting MerchantProduct instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MerchantProduct persistentInstance) {
		log.debug("removing MerchantProduct instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MerchantProduct merge(MerchantProduct detachedInstance) {
		log.debug("merging MerchantProduct instance");
		try {
			MerchantProduct result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MerchantProduct findById(int id) {
		log.debug("getting MerchantProduct instance with id: " + id);
		try {
			MerchantProduct instance = entityManager.find(
					MerchantProduct.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
