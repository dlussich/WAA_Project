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
import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Path("airport")
public class AirportRest {
	@Inject
	private AirportService airportService;
	@Inject
	private FlightService flightService;

	@GET
	@Path("/")
	public List<Airport> getAirport() {
		return airportService.getAll();
	}

	@POST
	@Path("/")
	public String createAirport(Airport airport) {
		airportService.create(airport);
		return "OK";
	}
	
	@DELETE
	@Path("/{paramId}")
	public String deleteAirport(@PathParam("paramId") Long id) {
		System.out.println("Deleted Airport: " + id);
		Airport airportDel = new Airport();
		airportDel.setId(id);
		airportService.delete(airportService.find(airportDel));
		return "OK";
	}

	@PUT
	@Path("/")
	public String updateAirport(Airport airport) {
		Airport objAir = airportService.find(airport);
		objAir.setAirportcode(airport.getAirportcode());
		objAir.setCity(airport.getCity());
		objAir.setCountry(airport.getCountry());
		objAir.setName(airport.getName());
		airportService.update(objAir);
		return "OK";
	}
	
	@GET
	@Path("/{paramType}/{paramValue}")
	public List<Airport> getAirportBy(@PathParam("paramType") String type, @PathParam("paramValue") String value) {
		List<Airport> airport = new ArrayList<>();

		switch (type) {
		case "bycode":
			airport.add(airportService.findByCode(value));
			break;
		case "byname":
			airport = airportService.findByName(value);
			break;
		case "bycity":
			airport = airportService.findByCity(value);
			break;
		case "bycountry":
			airport = airportService.findByCountry(value);
			break;
		case "bydeparture":
			airport = airportService.findByDeparture(flightService.findByNumber(value).get(0));
			break;
		case "byarrival":
			airport = airportService.findByArrival(flightService.findByNumber(value).get(0));
			break;
		default:
			airport = null;
			break;
		}
		return airport;
	}
}
