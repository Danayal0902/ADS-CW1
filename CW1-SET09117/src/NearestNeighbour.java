
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class NearestNeighbour {
	
	public static ArrayList<Point2D> routeTaken(ArrayList<Point2D> cities){ //array of 2D points which will return a result of the route taken
	
	long startTime = System.currentTimeMillis(); //log the start time of the algorithm
	
	ArrayList<Point2D> listCities = cities; //data structure containing all cities
	
	ArrayList<Point2D> result = new ArrayList<Point2D>(); //list of all cities to be visited in order
	
	
	
	Point2D currentCity = cities.remove(0); //use the first city in cities as a starting point
	
	while (cities.size() > 0){ //repeat until all cities have been added
		Point2D closest = null;
		result.add(currentCity); //add current city to the result
		double distance = Double.POSITIVE_INFINITY; //find the closest city to the current city and add it
		
		
		for (Point2D cityPossible : listCities) {
			if(currentCity.distance(cityPossible) < distance){ //currentCity.distance returns the distance between 2 cities
				//if it is closer than any examined so far
				closest = cityPossible; //the closest city becomes the next possible city in the loop
				distance = currentCity.distance(cityPossible);
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

	
	public double getDistance(ArrayList<Point2D> cities) {
		//calculate the length of a TSP route held in an array list as a set of points
		
		ArrayList<Point2D> listCities = cities; //creates an array list instance of cities object
		
		double result = 0; //holds the route length
		Point2D prev = listCities.get(listCities.size()-1);
		//set the previous city as the last city in the array list as we
		//need to measure length of the entire loop
		
		for (Point2D city : listCities) {
			//go through each city in turn
			result+= city.distance(prev);
			//get distance from the previous city
			prev = city;
			//current city will be the previous city next time
		}
		return result;
	}
}
