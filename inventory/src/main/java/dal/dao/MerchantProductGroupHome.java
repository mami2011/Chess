package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MerchantProductGroup.
 * @see dal.dao.MerchantProductGroup
 * @author Hibernate Tools
 */
@Stateless
public class MerchantProductGroupHome {

	private static final Log log = LogFactory
			.getLog(MerchantProductGroupHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MerchantProductGroup transientInstance) {
		log.debug("persisting MerchantProductGroup instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MerchantProductGroup persistentInstance) {
		log.debug("removing MerchantProductGroup instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MerchantProductGroup merge(MerchantProductGroup detachedInstance) {
		log.debug("merging MerchantProductGroup instance");
		try {
			MerchantProductGroup result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MerchantProductGroup findById(MerchantProductGroupId id) {
		log.debug("getting MerchantProductGroup instance with id: " + id);
		try {
			MerchantProductGroup instance = entityManager.find(
					MerchantProductGroup.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
