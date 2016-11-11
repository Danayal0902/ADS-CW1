import java.awt.geom.Point2D;
import java.util.ArrayList;

public class NNTest {

	public static void main(String[] args) {
		long start = System.nanoTime();
        NearestNeighbour near = new NearestNeighbour();
        
        ArrayList<Point2D> Cities = new ArrayList<Point2D>();
        
        double distance = 0;
        
        Cities = TSPLib.loadTSPLib("Users/danayaliftikhar/Desktop/TSP/rl304.tsp");
        
        distance = near.getDistance(Cities);
        
        System.out.println("Total time taken: " + (System.nanoTime() - start) / 1000 + "ms");
        
        System.out.println("The total distance is " + distance);

	}

}
