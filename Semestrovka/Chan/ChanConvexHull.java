import  java.util.*;
public class ChanConvexHull {
    public static int iterationsUsed = 0;
    public static List<Point> grahamScan(List<Point> points) {
        if(points.size() <= 3) {
            return  new ArrayList<>(points);
        }

        Point p0 = points.get(0);
        for(Point p : points) {
            if(p.y < p0.y || (p.y == p0.y && p.x < p0.x)) {
                p0 = p;
            }
            iterationsUsed++;
        }

        List<Point> sorted = new ArrayList<>(points);
        Point pointZero = p0;
        sorted.sort((a, b) -> {
            int orient = pointZero.crossProduct(a, b);
            if(orient == 0) {
                return Integer.compare(pointZero.distanceSq(a), pointZero.distanceSq(b));
            }
            return  orient > 0 ? -1 : 1;
        });

        List<Point> hull = new ArrayList<>();
        for(Point p : sorted) {
            while(hull.size() >= 2) {
                Point last = hull.get(hull.size() - 1);
                Point secondLast = hull.get(hull.size() - 2);
                int orient = secondLast.crossProduct(last,p);
                if(orient <= 0) {
                    hull.remove(hull.size() - 1);
                } else {
                    break;
                }
                iterationsUsed++;
            }
            hull.add(p);
        }

        return hull;
    }

    public static ChanResult chanHull(List<Point> points) {
        int n = points.size();
        if (n <= 3) return new ChanResult(new ArrayList<>(points), 0);

        int maxIterations = 100;

        for (int t = 1; t <= maxIterations; t++) {
            iterationsUsed = t;
            int m = Math.min((int) Math.pow(2, Math.pow(2, t)), n);

            List<List<Point>> subsets = new ArrayList<>();
            for (int i = 0; i < n; i += m) {
                int end = Math.min(i + m, n);
                subsets.add(points.subList(i, end));
                iterationsUsed++;
            }

            List<List<Point>> partialHulls = new ArrayList<>();
            for (List<Point> subset : subsets) {
                partialHulls.add(grahamScan(subset));
                iterationsUsed++;
            }

            List<Point> hull = new ArrayList<>();
            Point startPoint = Collections.min(points, (a, b) ->
                    (a.y == b.y) ? Integer.compare(a.x, b.x) : Integer.compare(a.y, b.y));
            hull.add(startPoint);

            boolean hullCompleted = false;
            for (int k = 0; k < m; k++) {
                Point current = hull.get(hull.size() - 1);
                Point next = null;

                for (List<Point> ph : partialHulls) {
                    Point candidate = jarvisStep(current, ph);
                    if (next == null || current.crossProduct(next, candidate) < 0 ||
                            (current.crossProduct(next, candidate) == 0 &&
                                    current.distanceSq(candidate) > current.distanceSq(next))) {
                        next = candidate;
                    }
                    iterationsUsed++;
                }

                if (next.equals(startPoint)) {
                    hullCompleted = true;
                    break;
                }
                hull.add(next);
            }

            if (hullCompleted) {
                return new ChanResult(hull, iterationsUsed);
            }
        }

        return new ChanResult(Collections.emptyList(), iterationsUsed);
    }

    private static Point jarvisStep(Point current, List<Point> ph) {
        Point next = ph.get(0);
        for (Point p : ph) {
            iterationsUsed++;
            int orient = current.crossProduct(next, p);
            if (orient < 0 || (orient == 0 &&
                    current.distanceSq(p) > current.distanceSq(next))) {
                next = p;
            }
        }
        return next;
    }


}
