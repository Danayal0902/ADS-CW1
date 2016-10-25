import java.awt.geom.Point2D;
import java.util.ArrayList;

public class RouteLength {
	public static double routeLength(ArrayList<Point2D> cities) {
		//calculate the length of a TSP route held in an arraylist as a set of points
		
		double result = 0; //holds the route length
		Point2D prev = cities.get(cities.size()-1);
		//set the previous city as the last city in the arraylist as we
		//need to measure length of the entire loop
		
		for (Point2D city : cities) {
			//go through each city in turn
			result+= city.distance(prev);
			//get distance from the previous city
			prev = city;
			//current city will be the previous city next time
		}
		return result;
	}
}
