package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ImageGroup.
 * @see dal.dao.ImageGroup
 * @author Hibernate Tools
 */
@Stateless
public class ImageGroupHome {

	private static final Log log = LogFactory.getLog(ImageGroupHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ImageGroup transientInstance) {
		log.debug("persisting ImageGroup instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ImageGroup persistentInstance) {
		log.debug("removing ImageGroup instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ImageGroup merge(ImageGroup detachedInstance) {
		log.debug("merging ImageGroup instance");
		try {
			ImageGroup result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ImageGroup findById(int id) {
		log.debug("getting ImageGroup instance with id: " + id);
		try {
			ImageGroup instance = entityManager.find(ImageGroup.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
