package primitives;

public class Point2D implements Comparable<Point2D> {
    Coordinate x;
    Coordinate y;

    public Point2D(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }


    public Point2D() {
        x.coordinate=0;
        y.coordinate=0;

    }
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    public Coordinate getX() {
        return x;
    }

    public void setX(Coordinate x) {
        this.x = x;
    }

    public Coordinate getY() {
        return y;
    }

    public void setY(Coordinate y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D x =" + x +
                ", y=" + y;
    }

    @Override
    public int compareTo(Point2D o) {
        if (this.x==o.x && this.y==o.y)
        return 1;
        else return 0;
    }
}
