package dal.dao;

// Generated May 10, 2013 11:09:54 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Listing.
 * @see dal.dao.Listing
 * @author Hibernate Tools
 */
@Stateless
public class ListingHome {

	private static final Log log = LogFactory.getLog(ListingHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Listing transientInstance) {
		log.debug("persisting Listing instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Listing persistentInstance) {
		log.debug("removing Listing instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Listing merge(Listing detachedInstance) {
		log.debug("merging Listing instance");
		try {
			Listing result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Listing findById(int id) {
		log.debug("getting Listing instance with id: " + id);
		try {
			Listing instance = entityManager.find(Listing.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
