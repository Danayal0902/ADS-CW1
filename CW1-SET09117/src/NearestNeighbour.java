
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class NearestNeighbour {
	
	final static int size = 1000;
//	private static final String FILE_INPUT = null;
    static double[][] distances = new double[size][size];
    
    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();
        NearestNeighbour instance = new NearestNeighbour();
//        System.out.println(
//                NearestNeighbour.readFromFile(FILE_INPUT).solveByNearest() );
        instance.solveMe();
        System.out.println("Total time: " + (System.nanoTime() - start) / 1000000 + "ms");
    }

    public void solveMe() throws Exception {
        String[] inputs = load("Users/danayaliftikhar/Desktop/TSP/rl304.tsp");
        double[][] coords = new double[size][size];
        for (int i = 0; i < size; i++) {
            String[] tokens = inputs[i].split(",");
            for (int j = 0; j < tokens.length - 2; j++) {
                coords[i][j] = Double.parseDouble(tokens[j + 2]);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                distances[i][j] = haversin(coords[i][0], coords[j][0], coords[i][1], coords[j][1]);
                distances[j][i] = distances[i][j];
            }
        }
        
        long start = System.nanoTime();
        int[] shortestPath = nearestNeighbour(distances);

        System.out.println("Nearest took: " + (System.nanoTime() - start) / 1000000 + "ms");
        //printPath(shortestPath);

        double bestShort = 0;
        for (int i = 0; i < size - 1; ++i) {
            bestShort += distances[shortestPath[i] - 1][shortestPath[i + 1] - 1];
        }
        bestShort += distances[shortestPath[size - 1]][shortestPath[0]];

        System.out.println("DONE w/ a distance of: " + bestShort);
        printPath(shortestPath);
    }

    /*  for each city in the graph,
            start there, and find the closest city not yet visited.
            set current location to that city, and add the distance.
            If the total distance is shorter than the previous best, update it
        return the path with the shortest distance found
    */
    public int[] nearestNeighbour(double[][] distances) {
        boolean[] copy = new boolean[size];
        int[] shortestPath = new int[size];
        int current = 0;
        double bestDistance = Double.MAX_VALUE;

        // nearest neighbour thingy
        int town = current;
        for (int a = 0; a < size; a++) {
            // reset distance array
            Arrays.fill(copy, true);
            double shortest = 0,  dist = 0;
            int[] temp = new int[size];
            int index = 0;
            temp[index++] = a + 1;
            current = a;

            for (int c = 0; c < size - 1; c++) {
                shortest = Double.MAX_VALUE; // reset closest

                for (int i = 0; i < size; i++) {
                    if(i == current) continue;
                    if (copy[i] && (distances[current][i] < shortest)) {
                        town = i;
                        shortest = distances[current][i];
                    }
                }

                copy[current] = false;
                temp[index++] = town + 1;
                current = town;
                dist += shortest;
            }

            dist += distances[temp[index - 1] - 1][temp[0] - 1];
            if (dist < bestDistance) {
                shortestPath = Arrays.copyOf(temp, temp.length);
                bestDistance = dist;
            }
        }
        return shortestPath;
    }

    public double haversin(double x1, double x2, double y1, double y2) {

        // difference between x and y co-ords
        double differenceInX = toRadians(x2 - x1);
        double differenceInY = toRadians(y2 - y1);

        // convert to radians
        // angle / 180.0 * PI
        x1 = toRadians(x1);
        x2 = toRadians(x2);

        // 2r is a constant, and presuming the radius is 6371lm
        return 12742.0 * asin(sqrt(sin(differenceInX / 2) * sin(differenceInX / 2) + sin(differenceInY / 2) * sin(differenceInY / 2) * cos(x1) * cos(x2)));
    }

    public void printPath(int[] path) {
        for (int i = 0; i < size - 1; ++i) {
            System.out.print(path[i] + ".");
        }
        System.out.println(path[size - 1]);
    }

    public String[] load(String path) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(path));
        StringBuilder contents = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            contents.append(line).append(System.getProperty("line.separator"));
        }
        in.close();
        return contents.toString().split(System.getProperty("line.separator"));
    }
}
