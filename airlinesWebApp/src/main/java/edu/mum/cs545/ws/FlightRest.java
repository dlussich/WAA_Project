/*package edu.mum.cs545.ws;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Named
@Path("flight")
public class FlightRest {
	
	@Inject
	private FlightService flightService;

	public void create(Flight flight) {
		flightService.create(flight);
	}

	public void delete(Flight flight) {
		flightService.delete(flight);
	}

	public Flight update(Flight flight) {
		return flightService.update(flight);
	}
		
	public Flight find(Flight flight) {
		return flightService.find(flight);
	}

	
	public List<Flight> findByNumber(String flightnr) {
		return flightService.findByNumber(flightnr);
	}

	public List<Flight> findByAirline(Airline airline) {
		return flightService.findByAirline(airline);
	}

	public List<Flight> findByOrigin(Airport airport) {
		return flightService.findByOrigin(airport);
	}

	public List<Flight> findByDestination(Airport airport) {
		return flightService.findByDestination(airport);
	}

	public List<Flight> findByArrival(Airplane airplane) {
		return flightService.findByArrival(airplane);
	}

	public List<Flight> findByArrival(Date datetime) {
		return flightService.findByArrival(datetime);
	}

	public List<Flight> findByArrivalBetween(Date datetimeFrom, Date datetimeTo) {
		return flightService.findByArrivalBetween(datetimeFrom, datetimeTo);
	}

	public List<Flight> findByDeparture(Date datetime) {
		return flightService.findByDeparture(datetime);
	}

	public List<Flight> findByDepartureBetween(Date datetimeFrom, Date datetimeTo) {
		return flightService.findByDepartureBetween(datetimeFrom, datetimeTo);
	}

	@GET
	public List<Flight> findAll() {
		return flightService.findAll();
	}
	
}
*/