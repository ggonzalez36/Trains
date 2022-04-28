package Train.FisaGroup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Train.FisaGroup.entities.City;
import Train.FisaGroup.entities.Edge;
import Train.FisaGroup.entities.Route;
import Train.FisaGroup.exception.NoSuchRouteException;


public class CalculateRoutesTest {
	

    CalculateRoutes calculateRoutes = new RoutesImplementation();    
	
    @Test
    public void findDistanceBetweenCitiesSuccess() throws NoSuchRouteException {
    	
        City  a = new City("A");
        City  b = new City("B");
        City  c = new City("C");
        City  d = new City("D");
        City  e = new City("E");
        
        Route route = new Route();
        route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
        route.directGraph.put(b, new Edge(b,c,4));
        route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
        route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
        route.directGraph.put(e, new Edge(e,b,3));
    	
        ArrayList<City> distance = new ArrayList<City>();
        distance.add(a);
        distance.add(b);
        distance.add(c);
    	
    	assertEquals(calculateRoutes.findDistanceBetweenCities(distance, route), 9);
    }
    
    
    @Test
    public void findDistanceBetweenCitiesless() throws NoSuchRouteException {
    	
        City  a = new City("A");
        City  b = new City("B");
        City  c = new City("C");
        City  d = new City("D");
        City  e = new City("E");
        
        Route route = new Route();
        route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
        route.directGraph.put(b, new Edge(b,c,4));
        route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
        route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
        route.directGraph.put(e, new Edge(e,b,3));
    	
        ArrayList<City> distance = new ArrayList<City>();
        distance.add(a);

    	
    	assertEquals(calculateRoutes.findDistanceBetweenCities(distance, route), 0);
    }
    
    @Test(expected = NoSuchRouteException.class)
    public void findDistanceBetweenCitiesnotfoundIndex() throws NoSuchRouteException {
    	
        City  a = new City("A");
        City  b = new City("B");
        City  c = new City("C");
        City  d = new City("D");
        City  e = new City("E");
        City  f = new City("F");
        City  g = new City("G");
        
        Route route = new Route();
        route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
        route.directGraph.put(b, new Edge(b,c,4));
        route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
        route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
        route.directGraph.put(e, new Edge(e,b,3));
    	
        ArrayList<City> distance = new ArrayList<City>();
        distance.add(f);
        distance.add(g);

    	
    	assertEquals(calculateRoutes.findDistanceBetweenCities(distance, route), 0);
    }


    @Test(expected = NoSuchRouteException.class)
    public void findDistanceBetweenCitiesException() throws NoSuchRouteException {
    	
        City  a = new City("A");
        City  b = new City("B");
        City  c = new City("C");
        City  d = new City("D");
        City  e = new City("E");
        
        Route route = new Route();
        route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
        route.directGraph.put(b, new Edge(b,c,4));
        route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
        route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
        route.directGraph.put(e, new Edge(e,b,3));
        
        ArrayList<City> distance5 = new ArrayList<City>();
        distance5.add(a);
        distance5.add(e);
        distance5.add(d);
        
        assertEquals(calculateRoutes.findDistanceBetweenCities(distance5, route),4);

    }
    
    @Test 
    public void numberofStopbetweencitiesSucess() throws NoSuchRouteException {
        City  a = new City("A");
        City  b = new City("B");
        City  c = new City("C");
        City  d = new City("D");
        City  e = new City("E");
        
        Route route = new Route();
        route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
        route.directGraph.put(b, new Edge(b,c,4));
        route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
        route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
        route.directGraph.put(e, new Edge(e,b,3));
        
        assertEquals(calculateRoutes.numberOfStopsBetweenCities(c,c,3,route),2);
    	
    }
    
    @Test(expected = NoSuchRouteException.class)
    public void numberofStopbetweencitiesException() throws NoSuchRouteException {
        City  a = new City("A");
        City  b = new City("B");
        City  c = new City("C");
        City  d = new City("D");
        City  e = new City("E");
        City  f = new City("F");
        City  g = new City("G");
        
        Route route = new Route();
        route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
        route.directGraph.put(b, new Edge(b,c,4));
        route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
        route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
        route.directGraph.put(e, new Edge(e,b,3));
        
        assertEquals(calculateRoutes.numberOfStopsBetweenCities(f,g,3,route),2);
    	
    }
    
    @Test
    public void shortestRouteBetweenCitiesSucess() throws NoSuchRouteException{
    	 City  a = new City("A");
         City  b = new City("B");
         City  c = new City("C");
         City  d = new City("D");
         City  e = new City("E");

         
         Route route = new Route();
         route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
         route.directGraph.put(b, new Edge(b,c,4));
         route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
         route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
         route.directGraph.put(e, new Edge(e,b,3));
         
         assertEquals(calculateRoutes.shortestRouteBetweenCities(a,c,route),9);
    	
    }
    
    @Test(expected = NoSuchRouteException.class)
    public void shortestRouteBetweenCitiesException() throws NoSuchRouteException{
    	 City  a = new City("A");
         City  b = new City("B");
         City  c = new City("C");
         City  d = new City("D");
         City  e = new City("E");
         City  f = new City("F");
         City  g = new City("G");
         
         Route route = new Route();
         route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
         route.directGraph.put(b, new Edge(b,c,4));
         route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
         route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
         route.directGraph.put(e, new Edge(e,b,3));
         
         assertEquals(calculateRoutes.shortestRouteBetweenCities(f,g,route),9);
    	
    }
    
    @Test
    public void numRoutesWithinSucess() throws NoSuchRouteException{
    	 City  a = new City("A");
         City  b = new City("B");
         City  c = new City("C");
         City  d = new City("D");
         City  e = new City("E");
         
         Route route = new Route();
         route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
         route.directGraph.put(b, new Edge(b,c,4));
         route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
         route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
         route.directGraph.put(e, new Edge(e,b,3));
         
         assertEquals(calculateRoutes.numRoutesWithin(c,c,30,route),7);
    	
    }
    
    @Test(expected = NoSuchRouteException.class)
    public void numRoutesWithinException() throws NoSuchRouteException{
    	 City  a = new City("A");
         City  b = new City("B");
         City  c = new City("C");
         City  d = new City("D");
         City  e = new City("E");
         City  f = new City("F");
         City  g = new City("G");
         
         Route route = new Route();
         route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
         route.directGraph.put(b, new Edge(b,c,4));
         route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
         route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
         route.directGraph.put(e, new Edge(e,b,3));
         
         assertEquals(calculateRoutes.numRoutesWithin(f,f,30,route),7);
    	
    }
    
    


}
