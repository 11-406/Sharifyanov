public class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int crossProduct(Point a, Point b) {
        return(a.x - this.x) * (b.y - this.y) - (a.y - this.y) *(b.x - this.x);
    }

    public int distanceSq(Point other) {
        return (this.x - other.x) * (this.x - other.x) +
                (this.y - other.y) * (this.y - other.y);
    }

}
