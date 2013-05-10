package dal.dao;

// Generated May 10, 2013 11:43:56 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MlCategoryAttributeValues.
 * @see dal.dao.MlCategoryAttributeValues
 * @author Hibernate Tools
 */
@Stateless
public class MlCategoryAttributeValuesHome {

	private static final Log log = LogFactory
			.getLog(MlCategoryAttributeValuesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MlCategoryAttributeValues transientInstance) {
		log.debug("persisting MlCategoryAttributeValues instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MlCategoryAttributeValues persistentInstance) {
		log.debug("removing MlCategoryAttributeValues instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MlCategoryAttributeValues merge(
			MlCategoryAttributeValues detachedInstance) {
		log.debug("merging MlCategoryAttributeValues instance");
		try {
			MlCategoryAttributeValues result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MlCategoryAttributeValues findById(Integer id) {
		log.debug("getting MlCategoryAttributeValues instance with id: " + id);
		try {
			MlCategoryAttributeValues instance = entityManager.find(
					MlCategoryAttributeValues.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
