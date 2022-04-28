package Train.FisaGroup;

import java.util.ArrayList;

import Train.FisaGroup.entities.*;

import Train.FisaGroup.exception.NoSuchRouteException;

public class RoutesImplementation implements CalculateRoutes {

	
	  public int findDistanceBetweenCities(ArrayList<City>cities, Route route) throws NoSuchRouteException {

		    if (cities.size()<2){
		      return 0;
		    }

		    int distance, depth, index;
		    distance = depth = index = 0;

		    while (index < cities.size()-1){
		         if(route.directGraph.containsKey(cities.get(index))) {
		                Edge edge = route.directGraph.get(cities.get(index));
		                while(edge != null) {
		                    if(edge.destination.equals(cities.get(index + 1))) {
		                        distance += edge.weight;
		                        depth++;
		                        break;
		                    }
		                    edge = edge.next;
		                }
		            }
		            else
		                throw new NoSuchRouteException();
		            index++;
		        }

		        if(depth != cities.size() - 1){
		            throw new NoSuchRouteException();
		        }
		      return distance;
		  }

	  public int numberOfStopsBetweenCities(City origin, City destination, int limit, Route route) throws NoSuchRouteException{
		    return findRoutes(origin, destination, 0,limit, route)-1;
		  }

	  private int findRoutes(City origin, City dest, int depth, int limit, Route route) throws NoSuchRouteException {
		        int routes = 0;
		        if(route.directGraph.containsKey(origin) && route.directGraph.containsKey(dest)) {
		            if(depth == limit){ return 0;}
		            depth++;
		            origin.visited = true;

		            Edge edge = route.directGraph.get(origin);
		            while(edge != null) {
		                if(edge.destination.equals(dest)) {
		                    routes++;
		                    edge = edge.next;
		                    continue;
		                }
		                else if(!edge.destination.visited) {
		                    depth--;
		                    routes += findRoutes(edge.destination, dest, depth, limit,route);

		                }
		                edge = edge.next;
		            }
		        }
		        else{
		        	throw new NoSuchRouteException();
		        }

		        origin.visited = false;

		        return routes;
		    }

	  public int shortestRouteBetweenCities(City origin, City destination, Route route) throws NoSuchRouteException{
		    return findShortestRoute(origin, destination, 0, 0, route);
		  }

	  public int findShortestRoute(City origin, City dest, int distance, int shortestPath,Route route) throws NoSuchRouteException{
		    if(route.directGraph.containsKey(origin) && route.directGraph.containsKey(dest)) {
		            origin.visited = true;
		            Edge edge = route.directGraph.get(origin);
		            while(edge != null) {
		                if(edge.destination == dest || !edge.destination.visited){
		                  distance += edge.weight;
		                }

		                if(edge.destination.equals(dest)) {
		                    if(shortestPath == 0 || distance < shortestPath)
		                        shortestPath = distance;
		                    origin.visited = false;
		                    return shortestPath;
		                }
		              /*Some backtracking and recursion */
		                else if(!edge.destination.visited) {
		                    shortestPath = findShortestRoute(edge.destination, dest, distance, shortestPath, route);
		                    distance -= edge.weight;
		                }
		                edge = edge.next;
		            }
		        }
		        else{
		        	throw new NoSuchRouteException();
		        }

		        origin.visited = false;
		        return shortestPath;
		  }


	  public int numRoutesWithin(City origin, City dest, int maxDistance,Route route) throws NoSuchRouteException {
		        return findAllRoutesBetweenTowns(origin, dest, 0, maxDistance, route);
		    }
	  
	  private int findAllRoutesBetweenTowns(City origin, City destination, int weight, int maxDistance, Route route) throws NoSuchRouteException{
		        int routes = 0;
		        if(route.directGraph.containsKey(origin) && route.directGraph.containsKey(destination)) {

		            Edge edge = route.directGraph.get(origin);
		            while(edge != null) {
		                weight += edge.weight;
		                if(weight <= maxDistance) {
		                    if(edge.destination.equals(destination)) {
		                        routes++;
		                        routes += findAllRoutesBetweenTowns(edge.destination, destination, weight, maxDistance, route);
		                        edge = edge.next;
		                        continue;
		                    }
		                    else {
		                        routes += findAllRoutesBetweenTowns(edge.destination, destination, weight, maxDistance, route);
		                        weight -= edge.weight;
		                    }
		                }
		                else
		                    weight -= edge.weight;

		                edge = edge.next;
		            }
		        }
		        else{
		        	throw new NoSuchRouteException();

		          }
		        return routes;

		    }
}
