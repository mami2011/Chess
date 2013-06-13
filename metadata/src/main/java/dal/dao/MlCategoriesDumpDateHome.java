package dal.dao;

// Generated May 10, 2013 2:06:06 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MlCategoriesDumpDate.
 * @see dal.dao.MlCategoriesDumpDate
 * @author Hibernate Tools
 */
@Stateless
public class MlCategoriesDumpDateHome {

	private static final Log log = LogFactory
			.getLog(MlCategoriesDumpDateHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MlCategoriesDumpDate transientInstance) {
		log.debug("persisting MlCategoriesDumpDate instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MlCategoriesDumpDate persistentInstance) {
		log.debug("removing MlCategoriesDumpDate instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MlCategoriesDumpDate merge(MlCategoriesDumpDate detachedInstance) {
		log.debug("merging MlCategoriesDumpDate instance");
		try {
			MlCategoriesDumpDate result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MlCategoriesDumpDate findById(String id) {
		log.debug("getting MlCategoriesDumpDate instance with id: " + id);
		try {
			MlCategoriesDumpDate instance = entityManager.find(
					MlCategoriesDumpDate.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
