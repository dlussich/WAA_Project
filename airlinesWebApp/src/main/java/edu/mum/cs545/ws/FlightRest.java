package edu.mum.cs545.ws;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Path("flight")
public class FlightRest {

	@Inject
	private FlightService flightService;
	@Inject
	private AirlineService airlineService;
	@Inject
	private AirportService airportService;
	@Inject
	private AirplaneService airplaneService;

	@GET
	@Path("/")
	public List<Flight> getFlights() {
		return flightService.getFlights();
	}
	
	@POST
	@Path("/")
	public String createFlight(Flight flight) {
		System.out.println("Flight: " + flight);
		flightService.create(flight);
		return "OK";
	}

	@DELETE
	@Path("/{paramId}")
	public String deleteFlight(@PathParam("paramId") Long id) {
		System.out.println("Deleted Flight: " + id);
		Flight flight = new Flight();
		flight.setId(id);
		flightService.delete(flightService.find(flight));
		return "OK";
	}
	

	@PUT
	@Path("/")
	public String updateFlight(Flight flight) {
		Flight objFlight = flightService.find(flight);
		objFlight.setFlightnr(flight.getFlightnr());
		objFlight.setArrivalDate(flight.getArrivalDate());
		objFlight.setArrivalTime(flight.getArrivalTime());
		objFlight.setDepartureDate(flight.getDepartureDate());
		objFlight.setDepartureTime(flight.getDepartureTime());
		flightService.update(objFlight);
		return "OK";
	}

	@GET
	@Path("/{paramType}/{paramValue}")
	public List<Flight> getBy(@PathParam("paramType") String type, @PathParam("paramValue") String value) throws ParseException {
		List<Flight> flight = new ArrayList<>();

		switch (type) {
		case "BYAIRPLANE":
			flight = getFlightByAirplaneModel(value);
			break;
		case "BYARRDATE":
			flight = findByArrivalDate(value);
			break;
		case "BYDEPDATE":
			flight = findByDepartureDate(value);
			break;
		case "BYNUMBER":
			flight = flightService.findByNumber(value);
			break;
		case "BYAIRLINE":
			flight = flightService.findByAirline(airlineService.findByName(value));
			break;
		case "BYORIGIN":
			flight = flightService.findByOrigin(airportService.findByCode(value));
			break;
		case "BYDESTINY":
			flight = flightService.findByDestination(airportService.findByCode(value));
			break;
		default:
			flight = null;
			break;
		}
		return flight;
	}

	private List<Flight> getFlightByAirplaneModel(String model) {
		List<Airplane> listAirplane = null;
		List<Flight> listFlights = null;
		listAirplane = airplaneService.findByModel(model);
		for (Airplane airplane : listAirplane) {
			listFlights = flightService.findByArrival(airplane);
		}
		return listFlights;
	}

	private List<Flight> findByDepartureDate(String date) throws ParseException {
		try {
			DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
			Date dateNew = (Date) formatter.parse(date);
			return flightService.findByDeparture(dateNew);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Flight> findByArrivalDate(String date) throws ParseException {
		try {
			DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
			Date dateArrival = (Date) formatter.parse(date);
			return flightService.findByArrival(dateArrival);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}