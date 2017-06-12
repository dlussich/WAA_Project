package edu.mum.cs545.ws;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Path("airline")
public class AirlineRest {

	@Inject
	private AirlineService airlineService;
	
	@POST
	@Path("/")
	public String createAirline(Airline airline) {
		airlineService.create(airline);
		return "OK";
	}
	
	@DELETE
	@Path("/{paramId}")
	public String deleteAirline(@PathParam("paramId") Long id) {
		System.out.println("Deleted Airline: " + id);
		Airline airline = airlineService.findById(id);
		airlineService.delete(airline);
		return "OK";
	}
	
	@PUT
	@Path("/")
	public String updateAirline(Airline clientAirline) {
		Airline airline = airlineService.findById(clientAirline.getId());
		airline.setName(clientAirline.getName());
		airlineService.update(airline);
		return "OK";
	}

	@GET
	@Path("/")
	public List<Airline> getAllAirlines() {
		return airlineService.getAll();
	}

	@GET
	@Path("/{paramType}/{paramValue}")
	public Airline getAirlineById(@PathParam("paramType") String type, @PathParam("paramValue") String value) {
		Airline airline;
		switch (type) {
		case "BYID":
			airline = airlineService.findById(Long.valueOf(value));
			break;
		case "BYNAME":
			airline = airlineService.findByName(value);
			break;
		default:
			airline = null;
			break;
		}
		return airline;
	}

}
