package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	
	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Airline airline) {
		airlineService.create(airline);
	}

	@Path("/")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Airline airline) {
		airlineService.delete(airline);
	}

	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Airline update(Airline airline) {
		return airlineService.update(airline);
	}

	
	@Path("/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airline findByName(@PathParam("name") String name) {
		return airlineService.findByName(name);
	}

	@GET
	public List<Airline> getAirlines() {
		return airlineService.getAll();
	}

}
