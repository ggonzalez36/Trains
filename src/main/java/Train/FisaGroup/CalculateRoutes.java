package Train.FisaGroup;

import java.util.ArrayList;

import Train.FisaGroup.entities.City;
import Train.FisaGroup.entities.Route;
import Train.FisaGroup.exception.NoSuchRouteException;

public interface CalculateRoutes  {
	
	public int findDistanceBetweenCities(ArrayList<City>cities, Route route)  throws NoSuchRouteException;
	
	public int numberOfStopsBetweenCities(City origin, City destination, int limit, Route route) throws NoSuchRouteException;
	
	public int shortestRouteBetweenCities(City origin, City destination, Route route) throws NoSuchRouteException;
	
	public int numRoutesWithin(City origin, City dest, int maxDistance,Route route) throws NoSuchRouteException;
	
	

}
