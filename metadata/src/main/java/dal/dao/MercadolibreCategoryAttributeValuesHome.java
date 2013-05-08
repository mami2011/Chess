package dal.dao;

// Generated May 8, 2013 9:53:22 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MercadolibreCategoryAttributeValues.
 * @see dal.dao.MercadolibreCategoryAttributeValues
 * @author Hibernate Tools
 */
@Stateless
public class MercadolibreCategoryAttributeValuesHome {

	private static final Log log = LogFactory
			.getLog(MercadolibreCategoryAttributeValuesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MercadolibreCategoryAttributeValues transientInstance) {
		log.debug("persisting MercadolibreCategoryAttributeValues instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MercadolibreCategoryAttributeValues persistentInstance) {
		log.debug("removing MercadolibreCategoryAttributeValues instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MercadolibreCategoryAttributeValues merge(
			MercadolibreCategoryAttributeValues detachedInstance) {
		log.debug("merging MercadolibreCategoryAttributeValues instance");
		try {
			MercadolibreCategoryAttributeValues result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MercadolibreCategoryAttributeValues findById(Integer id) {
		log.debug("getting MercadolibreCategoryAttributeValues instance with id: "
				+ id);
		try {
			MercadolibreCategoryAttributeValues instance = entityManager.find(
					MercadolibreCategoryAttributeValues.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
