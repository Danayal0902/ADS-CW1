
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class NearestNeighbour {
	
	public static double routeTaken(ArrayList<Point2D> cities ){ //array of 2D points which will return a result of the route taken
	
	long startTime = System.currentTimeMillis(); //log the start time of the algorithm
	
	ArrayList<Point2D> listCities = cities; //data structure containing all cities
	
	ArrayList<Point2D> result = new ArrayList<Point2D>(); //list of all cities to be visited in order
	
	
	Point2D currentCity = cities.remove(0); //use the first city in cities as a starting point
	
	while (cities.size() > 0){ //repeat until all cities have been added
		Point2D closest = null;
		result.add(currentCity); //add current city to the result
		double distance = Double.POSITIVE_INFINITY; //find the closest city to the current city and add it
		
		
		for (Point2D cityPossible : listCities) {
			if(getDistance(currentCity, cityPossible) < distance) {
				closest = currentCity;
				distance = getDistance(currentCity, cityPossible);
			} //end if
			
		} //end for loop
		
		cities.remove(closest); //remove the closest city so it isn't checked again
		currentCity = closest; //set next closest city to the current city
		
	} //end while loop
	
	long endTime = System.currentTimeMillis(); //log the end time of the algorithm
	long totalTime = endTime - startTime; //calculate the total runtime of the algorithm
	System.out.println("The total runtime is " + totalTime + " ms"); //displays the total runtime in milliseconds in the console
	return result;
	}

	private static double getDistance(Point2D currentCity, Point2D cityPossible) {
		ArrayList<Point2D> cities = cities;
		double distance = 0;
		return 0;
	}

//	public double getDistance(ArrayList<Point2D> cities) { //gets the distance of the route taken
//		
//		double distance = 0;
//		return 0;
//	}
}
