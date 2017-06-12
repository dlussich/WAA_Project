package cs545.airline.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import cs545.airline.model.Airline;
import edu.mum.gf.workaround.JpaUtil;

@Named
@ApplicationScoped
public class AirlineDao {

//	@PersistenceContext(unitName = "cs545")
//	private static EntityManager entityManager;
//  Couldn't figure out another way to inject the persistence context
	private EntityManager entityManager = JpaUtil.getEntityManager();


	public void create(Airline airline) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(airline);
		transaction.commit();
	}

	public Airline update(Airline airline) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		Airline airlineRet = entityManager.merge(airline);
		transaction.commit();
		return airlineRet;
		
	}

	public void delete(Airline airline) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(airline);
		transaction.commit();
	}

	public Airline findOne(long id) {
		return entityManager.find(Airline.class, id);
	}

	public Airline findOneByName(String name) {
		Query query = entityManager.createQuery("select a from Airline a where a.name=:name", Airline.class);
		query.setParameter("name", name);
		System.out.println("select a from Airline a where a.name=" + name);
		return (Airline) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Airline> findByFlight(long flightId) {
		Query query = entityManager
				.createQuery("select distinct a from Airline a join a.flights f where f.id=:flightId", Airline.class);
		query.setParameter("flightId", flightId);

		return query.getResultList();
	}

	public List<Airline> findAll() {
		return entityManager.createQuery("select a from Airline a", Airline.class).getResultList();
	}

}
