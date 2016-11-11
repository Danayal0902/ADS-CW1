
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class NearestNeighbour {
	
	public static ArrayList<Point2D> getRoute(ArrayList<Point2D> cities){
	
	long startTime = System.currentTimeMillis(); //log the start time of the algorithm
	
	ArrayList<Point2D> listCities = cities; //data structure containing all cities
	
	ArrayList<Point2D> result = new ArrayList<Point2D>(); //list of all cities to be visited in order
	
	
	Point2D currentCity = cities.remove(0); //use the first city in cities as a starting point
	
	while (cities.size() > 0){ //repeat until all cities have been added
		Point2D closest = null;
		result.add(currentCity);
		double distance = Double.POSITIVE_INFINITY;
		
		
		for (Point2D cityPossible : listCities) {
			if(currentCity.distance(cityPossible) < distance) {
				closest = cityPossible;
				distance = currentCity.distance(cityPossible);
				
			}
		}
	}
	return result;
	}

	public double getDistance(ArrayList<Point2D> cities) {
		
		double distance = 0;
		return 0;
	}
}
