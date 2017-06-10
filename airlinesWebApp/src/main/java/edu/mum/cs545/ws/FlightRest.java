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

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Named
@Path("flight")
public class FlightRest {
	
	@Inject
	private FlightService flightService;

	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createFlight(Flight flight) {
		flightService.create(flight);
	}
	
	@Path("/")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteFlight(Flight flight) {
		flightService.delete(flight);
	}

	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Flight update(Flight flight) {
		return flightService.update(flight);
	}
	
	@Path("/number/{flightnr}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByNumber(@PathParam("flightnr") String flightnr) {
		return flightService.findByNumber(flightnr);
	}

	@GET
	public List<Flight> getFlights() {
		return flightService.getFlights();
	}
	
}
