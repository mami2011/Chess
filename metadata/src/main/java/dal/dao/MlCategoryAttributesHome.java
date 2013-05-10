package dal.dao;

// Generated May 10, 2013 2:06:06 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MlCategoryAttributes.
 * @see dal.dao.MlCategoryAttributes
 * @author Hibernate Tools
 */
@Stateless
public class MlCategoryAttributesHome {

	private static final Log log = LogFactory
			.getLog(MlCategoryAttributesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MlCategoryAttributes transientInstance) {
		log.debug("persisting MlCategoryAttributes instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MlCategoryAttributes persistentInstance) {
		log.debug("removing MlCategoryAttributes instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MlCategoryAttributes merge(MlCategoryAttributes detachedInstance) {
		log.debug("merging MlCategoryAttributes instance");
		try {
			MlCategoryAttributes result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MlCategoryAttributes findById(Integer id) {
		log.debug("getting MlCategoryAttributes instance with id: " + id);
		try {
			MlCategoryAttributes instance = entityManager.find(
					MlCategoryAttributes.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
