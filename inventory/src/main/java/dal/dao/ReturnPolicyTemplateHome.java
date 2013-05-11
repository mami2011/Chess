package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ReturnPolicyTemplate.
 * @see dal.dao.ReturnPolicyTemplate
 * @author Hibernate Tools
 */
@Stateless
public class ReturnPolicyTemplateHome {

	private static final Log log = LogFactory
			.getLog(ReturnPolicyTemplateHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ReturnPolicyTemplate transientInstance) {
		log.debug("persisting ReturnPolicyTemplate instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ReturnPolicyTemplate persistentInstance) {
		log.debug("removing ReturnPolicyTemplate instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ReturnPolicyTemplate merge(ReturnPolicyTemplate detachedInstance) {
		log.debug("merging ReturnPolicyTemplate instance");
		try {
			ReturnPolicyTemplate result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ReturnPolicyTemplate findById(int id) {
		log.debug("getting ReturnPolicyTemplate instance with id: " + id);
		try {
			ReturnPolicyTemplate instance = entityManager.find(
					ReturnPolicyTemplate.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
