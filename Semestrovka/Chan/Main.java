import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<List<Point>> fullCoords = DatalLoader.loadAllDatasets("file_with_coord.txt");
        int i = 1;

        for(List<Point> dataset : fullCoords) {
            long startTime = System.nanoTime();
            ChanResult result = ChanConvexHull.chanHull(dataset);
            long endTime = System.nanoTime();

            int iterations = result.iterations;
            System.out.printf(i + " Набор из %d точек: итераций = %d, время = %.2f мс\n",
                    dataset.size(), iterations, (endTime - startTime) / 1e6);

            i++;
        }

    }
}
