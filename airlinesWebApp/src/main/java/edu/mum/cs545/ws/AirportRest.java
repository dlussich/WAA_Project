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
import javax.ws.rs.core.MediaType;

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

	@Path("/")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Airport airport) {
		airportService.delete(airport);
	}

	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Airport update(Airport airport) {
		return airportService.update(airport);
	}

	public Airport findByCode(String airportcode) {
		return airportService.findByCode(airportcode);
	}
	
	@Path("/{name}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Airport> getAirportByName(@PathParam("name") String name) {
		return airportService.findByName(name);
	}

	
	@GET
	public List<Airport> findAll() {
		return airportService.findAll();
	}

}
