package cs545.airline.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import cs545.airline.dao.AirlineDao;
import cs545.airline.model.Airline;
import cs545.airline.model.Flight;

@Named("airlines")
@ApplicationScoped
@Transactional
public class AirlineService {

	// These services should be evaluated to reconsider which methods should be
	// public

	@Inject
	private AirlineDao airlineDao;
	
	private List<Flight> airlineFlights;
	
	public void create(Airline airport) {
		airlineDao.create(airport);
	}

	public void delete(Airline airport) {
		airlineDao.delete(airport);
	}

	public Airline update(Airline airport) {
		return airlineDao.update(airport);
	}

	public Airline find(Airline airport) {
		return airlineDao.findOne(airport.getId());
	}

	public Airline findByName(String name) {
		return airlineDao.findOneByName(name);
	}
	
	public Airline findById(long id) {
		return airlineDao.findOne(id);
	}

	public List<Airline> findByFlight(Flight flight) {
		return airlineDao.findByFlight(flight.getId());
	}

	public List<Airline> getAll() {
		return airlineDao.findAll();
	}
	
	public List<Flight> showFlights(String id, String name){
		Airline airline=findById(Long.parseLong(id));
		airlineFlights=airline.getFlights();
		return airlineFlights;
	}
	
	public List<Flight> getAirlineFlights(){
		return airlineFlights;
	}
	
}
