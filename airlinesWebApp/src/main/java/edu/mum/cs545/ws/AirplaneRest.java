package edu.mum.cs545.ws;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.FlightService;

@Path("airplane")
public class AirplaneRest {
	@Inject
	private FlightService flightService;
	@Inject
	private AirplaneService airplaneService;
	

	@GET
	@Path("/")
	public List<Airplane> getAirlines() {
		return airplaneService.findAll();
	}
	
	@POST
	@Path("/")
	public String createAirplane(Airplane airplane) {
		airplaneService.create(airplane);
		return "OK";
	}

	@DELETE
	@Path("/{paramId}")
	public String deleteAirplane(@PathParam("paramId") Long id) {
		System.out.println("Deleted Airplane: " + id);
		Airplane airplane = new Airplane();
		airplane.setId(id);
		airplaneService.delete(airplaneService.find(airplane));
		return "OK";
	}
	
	@PUT
	@Path("/")
	public String updateAirplane(Airplane airplane) {
		Airplane objAirplane = airplaneService.find(airplane);
		objAirplane.setCapacity(airplane.getCapacity());
		objAirplane.setModel(airplane.getModel());
		objAirplane.setSerialnr(airplane.getSerialnr());
		airplaneService.update(objAirplane);
		return "OK";
	}

	@GET
	@Path("/{paramType}/{paramValue}")
	public List<Airplane> getAirplaneById(@PathParam("paramType") String type, @PathParam("paramValue") String value) {
		List<Airplane> airplane = new ArrayList<>();

		switch (type) {
		case "serial":
			airplane.add(airplaneService.findBySrlnr(value));
			break;
		case "model":
			airplane = airplaneService.findByModel(value);
			break;
		case "flight":
			airplane = airplaneService.findByFlight(flightService.findByNumber(value).get(0));
			break;
		default:
			airplane = null;
			break;
		}
		return airplane;
	}

}
