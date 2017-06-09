package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirportService;

@Named
@Path("airport")
public class AirportRest {
	
	@Inject
	private AirportService airportService;
	
	public void create(Airport airport) {
		airportService.create(airport);
	}

	public void delete(Airport airport) {
		airportService.delete(airport);
	}

	public Airport update(Airport airport) {
		return airportService.update(airport);
	}
		
	public Airport find(Airport airport) {
		return airportService.find(airport);
	}

	public Airport findByCode(String airportcode) {
		return airportService.findByCode(airportcode);
	}

	public List<Airport> findByArrival(Flight flight) {
		return airportService.findByArrival(flight);
	}

	public List<Airport> findByDeparture(Flight flight) {
		return airportService.findByDeparture(flight);
	}

	public List<Airport> findByCity(String city) {
		return airportService.findByCity(city);
	}

	public List<Airport> findByCountry(String country) {
		return airportService.findByCountry(country);
	}

	public List<Airport> findByName(String name) {
		return airportService.findByName(name);
	}

	
	@GET
	public List<Airport> findAll() {
		return airportService.findAll();
	}

}
