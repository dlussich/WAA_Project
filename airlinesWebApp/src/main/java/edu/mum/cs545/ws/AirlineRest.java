package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

@Named
@Path("airline")
public class AirlineRest {
	
	@Inject
	private AirlineService airlineService;
	
	public void create(Airline airport) {
		airlineService.create(airport);
	}

	public void delete(Airline airport) {
		airlineService.delete(airport);
	}

	public Airline update(Airline airport) {
		return airlineService.update(airport);
	}

	public Airline find(Airline airport) {
		return airlineService.find(airport);
	}
	
	@Path("/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airline findByName(@PathParam("name") String name) {
		return airlineService.findByName(name);
	}

	public List<Airline> findByFlight(Flight flight) {
		return airlineService.findByFlight(flight);
	}

	@GET
	public List<Airline> findAll() {
		return airlineService.findAll();
	}

}
