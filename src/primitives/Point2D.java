package primitives;

public class Point2D implements Comparable<Point2D> {
    protected Coordinate x;
    protected Coordinate y;

    public Point2D(Coordinate x, Coordinate y) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
    }


    public Point2D() {
        x = new Coordinate();
        y = new Coordinate();

    }
    public Point2D(Point2D p) {
        this.x = new Coordinate(p.x);
        this.y = new Coordinate(p.y);
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
        return "(" + x + ", " + y+")";
    }

    @Override
    public int compareTo(Point2D o) {
        if ((this.x.compareTo(o.x) + this.y.compareTo(o.y))==0)
            return 0;
        else
            return -1;
    }
}
