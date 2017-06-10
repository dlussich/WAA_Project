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

import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;


@Named
@Path("airplane")
public class AirplaneRest {
	
	@Inject
	private AirplaneService airplaneService;
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Airplane airplane) {
		airplaneService.create(airplane);
	}

	@Path("/")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Airplane airplane) {
		airplaneService.delete(airplane);
	}

	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Airplane update(Airplane airplane) {
		return airplaneService.update(airplane);
	}

	@Path("/{serialno}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airplane findBySrlnr(@PathParam("serialno") String serialno) {
		return airplaneService.findBySrlnr(serialno);
	}
	
	@GET
	public List<Airplane> findAll() {
		return airplaneService.findAll();
	}

}
