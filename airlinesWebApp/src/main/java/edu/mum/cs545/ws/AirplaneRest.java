package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;


@Named
@Path("airplane")
public class AirplaneRest {
	
	@Inject
	private AirplaneService airplaneService;
	
	public void create(Airplane airplane) {
		airplaneService.create(airplane);
	}

	public void delete(Airplane airplane) {
		airplaneService.delete(airplane);
	}

	public Airplane update(Airplane airplane) {
		return airplaneService.update(airplane);
	}

	
	public Airplane find(Airplane airplane) {
		return airplaneService.find(airplane);
	}

	public Airplane findBySrlnr(@PathParam("serialno") String serialno) {
		return airplaneService.findBySrlnr(serialno);
	}

	public List<Airplane> findByFlight(Flight flight) {
		return airplaneService.findByFlight(flight);
	}

	public List<Airplane> findByModel(@PathParam("model") String model) {
		return airplaneService.findByModel(model);
	}

	
	@GET
	public List<Airplane> findAll() {
		return airplaneService.findAll();
	}

}
