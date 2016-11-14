import java.awt.geom.Point2D;
import java.util.ArrayList;

public class NNTest {

	public static void main(String[] args) {
		
		NearestNeighbour nearest = new NearestNeighbour();
		
        ArrayList<Point2D> citiesUnsorted = new ArrayList<Point2D>();
        
        ArrayList<Point2D> citiesSorted = new ArrayList<Point2D>();
        
        
        double distanceBefore = 0;
        
        double distanceAfter = 0;
        
        citiesUnsorted = TSPLib.loadTSPLib("/Users/danayaliftikhar/Desktop/TSP/rl1304.tsp");
        
        distanceBefore = nearest.getDistance(citiesUnsorted);
        
        citiesSorted = nearest.routeTaken(citiesUnsorted);
		
        distanceAfter = nearest.getDistance(citiesSorted);
        
        System.out.println("The tour length without NN is " + distanceBefore);
        
        System.out.println("The tour length is after is " + distanceAfter);
        
	}

}
