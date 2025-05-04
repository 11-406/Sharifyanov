import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatalLoader {

    public static List<List<Point>> loadAllDatasets(String filename) {
        List<List<Point>> allDatasets = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<Point> dataset = parseLine(line);
                allDatasets.add(dataset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allDatasets;
    }

    private static List<Point> parseLine(String line) {
        List<Point> points = new ArrayList<>();
        String[] coords = line.trim().split(" ");

        for (int i = 0; i < coords.length; i += 2) {
            int x = Integer.parseInt(coords[i]);
            int y = Integer.parseInt(coords[i + 1]);
            points.add(new Point(x, y));
        }

        return points;
    }
}
