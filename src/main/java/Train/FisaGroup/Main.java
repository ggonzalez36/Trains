package Train.FisaGroup;
import java.util.ArrayList;

import Train.FisaGroup.entities.City;
import Train.FisaGroup.entities.Edge;
import Train.FisaGroup.entities.Route;
import Train.FisaGroup.exception.NoSuchRouteException;

public class Main {
	
	public static void main(String[] args)  {

   

        // CREATING THE CITIES
        City  a = new City("A");
        City  b = new City("B");
        City  c = new City("C");
        City  d = new City("D");
        City  e = new City("E");
        
        //MAPPING ROUTES 
        Route route = new Route();
        //Mapping route AB5 AD5 and AE7 
        route.directGraph.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
        // Mapping route BC4
        route.directGraph.put(b, new Edge(b,c,4));
        // Mapping route CD8 and CE2
        route.directGraph.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
        // Mapping route DC8 and DE6
        route.directGraph.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
        // Mapping route EB3
        route.directGraph.put(e, new Edge(e,b,3));

        // Calculate Distances
        //1. Calculate  distance of route A-B-C
        ArrayList<City> distance1 = new ArrayList<City>();
        distance1.add(a);
        distance1.add(b);
        distance1.add(c);
        
        CalculateRoutes calculateRoute= new RoutesImplementation();

		try {
			System.out.println("Output#1  " + calculateRoute.findDistanceBetweenCities(distance1,route));
		} catch (NoSuchRouteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        //2. Calculate distance of route A-D
        ArrayList<City> distance2 = new ArrayList<City>();
        distance2.add(a);
        distance2.add(d);
        try {
			System.out.println("Output#2  " + calculateRoute.findDistanceBetweenCities(distance2,route));
		} catch (NoSuchRouteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        //3. Calculate distance of route A-D-C
        ArrayList<City> distance3 = new ArrayList<City>();
        distance3.add(a);
        distance3.add(d);
        distance3.add(c);
        
		try {
			System.out.println("Output#3  " + calculateRoute.findDistanceBetweenCities(distance3, route));
		} catch (NoSuchRouteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


        //4. Calculate distance of route A-E-B-C-D
        ArrayList<City> distance4 = new ArrayList<City>();
        distance4.add(a);
        distance4.add(e);
        distance4.add(b);
        distance4.add(c);
        distance4.add(d);

        try {
			System.out.println("Output#4  " + calculateRoute.findDistanceBetweenCities(distance4, route));
		} catch (NoSuchRouteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        //5. Calculate distance of route A-E-D
        ArrayList<City> distance5 = new ArrayList<City>();
        distance5.add(a);
        distance5.add(e);
        distance5.add(d);
        try {
			System.out.println("Output#5  " + calculateRoute.findDistanceBetweenCities(distance5, route));
		} catch (NoSuchRouteException e1) {

			System.out.println("Output#5  " +e1);
		}

        //6. Number of trips starting at C,ending at C with 3 stops max
        try {
			System.out.println("Output#6  " + calculateRoute.numberOfStopsBetweenCities(c,c,3,route));
		} catch (NoSuchRouteException e1) {

			e1.printStackTrace();
		}

        //7. Number of trips starting at A,ending at C with 4 stops max
        try {
			System.out.println("Output#7  " + calculateRoute.numberOfStopsBetweenCities(a,c,4,route));
		} catch (NoSuchRouteException e1) {

			e1.printStackTrace();
		}

        //8.The length of the shortest route from A to C.
        try {
			System.out.println("Output#8  " + calculateRoute.shortestRouteBetweenCities(a,c,route));
		} catch (NoSuchRouteException e1) {

			e1.printStackTrace();
		}

        //9.The length of the shortest route from B to B.

        try {
			System.out.println("Output#9  " + calculateRoute.shortestRouteBetweenCities(b,b,route));
		} catch (NoSuchRouteException e1) {

			e1.printStackTrace();
		}

        //10.The number of different routes from C to C with a distance of less than 30
        try {
			System.out.println("Output#10  " + calculateRoute.numRoutesWithin(c,c,30,route));
		} catch (NoSuchRouteException e1) {

			e1.printStackTrace();
		}

    }

}
