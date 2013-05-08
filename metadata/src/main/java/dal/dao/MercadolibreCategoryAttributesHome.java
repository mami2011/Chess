package dal.dao;

// Generated May 8, 2013 9:53:22 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MercadolibreCategoryAttributes.
 * @see dal.dao.MercadolibreCategoryAttributes
 * @author Hibernate Tools
 */
@Stateless
public class MercadolibreCategoryAttributesHome {

	private static final Log log = LogFactory
			.getLog(MercadolibreCategoryAttributesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MercadolibreCategoryAttributes transientInstance) {
		log.debug("persisting MercadolibreCategoryAttributes instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MercadolibreCategoryAttributes persistentInstance) {
		log.debug("removing MercadolibreCategoryAttributes instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MercadolibreCategoryAttributes merge(
			MercadolibreCategoryAttributes detachedInstance) {
		log.debug("merging MercadolibreCategoryAttributes instance");
		try {
			MercadolibreCategoryAttributes result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MercadolibreCategoryAttributes findById(Integer id) {
		log.debug("getting MercadolibreCategoryAttributes instance with id: "
				+ id);
		try {
			MercadolibreCategoryAttributes instance = entityManager.find(
					MercadolibreCategoryAttributes.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
