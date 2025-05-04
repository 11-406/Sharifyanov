import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    private static final int MIN_COORD = -1000;
    private static final int MAX_COORD = 1000;
    private static final int min = 100;
    private static final int max = 10000;
    public static Random random;

    public static void main(String[] args) {
        String filename = "file_with_coord.txt";
        random = new Random();
        int[] sizes = new int[100];
        for(int i = 0; i < sizes.length; i++) {
            sizes[i] = getRadnomSize(min, max);
        }

        try(FileWriter writer = new FileWriter(filename)) {
            for(int size: sizes) {
                for(int i = 0; i < sizes.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; i < size; i++) {
                        int x = MIN_COORD + random.nextInt(MAX_COORD - MIN_COORD);

                        int y = MIN_COORD + random.nextInt(MAX_COORD - MIN_COORD);

                        sb.append(x).append(" ").append(y).append(" ");
                    }
                    sb.setLength(sb.length());
                    writer.write(sb + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRadnomSize(int min, int max) {
        int halfMax = max / 2;
        int halfMin = min / 2;
        return 2*random.nextInt(halfMax - halfMin + 1) + halfMin;

    }
}
