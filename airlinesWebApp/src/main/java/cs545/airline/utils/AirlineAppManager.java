package cs545.airline.utils;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Named("manager")
@ApplicationScoped
public class AirlineAppManager {
	@Inject
	private AirlineService airlineService;
	
	@Inject
	private FlightService flightService;
	
	@Inject
	private AirportService airportService;
	
	private List<Flight> filteredFlights;
	
	public List<Flight> filterFlights(String airline,String origin,String destination){
		List<Flight> airlineList=null;
		List<Flight> originList=null;
		List<Flight> destinationList=null;
		filteredFlights.clear();
		
		if(!airline.isEmpty()){
			Airline objAir=airlineService.findByName(airline);
			airlineList=flightService.findByAirline(objAir);
		}
		if(!origin.isEmpty()){
			Airport objOrigin=airportService.findByCode(origin);
			originList=flightService.findByOrigin(objOrigin);
		}
		if(!destination.isEmpty()){
			Airport objDest=airportService.findByCode(destination);
			destinationList=flightService.findByDestination(objDest);
		}
		
		for(Flight f: airlineList){
			if(originList.contains(f)&&destinationList.contains(f)){
				filteredFlights.add(f);
			}
		}
		return filteredFlights;
	}
	
	public List<Flight> getFilteredFlights(){
		if(filteredFlights==null){
			filteredFlights=flightService.getFlights();
		}
		return filteredFlights;
	}
}
