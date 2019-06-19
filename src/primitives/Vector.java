package primitives;
import static java.lang.StrictMath.sqrt;

public class Vector implements Comparable<Vector> {
    private Point3D head;

    public Vector(Point3D head) {
        if (head.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("not explicit Point(0,0,0) allowed");
        }
        this.head = new Point3D(head);
    }

    public Vector() {
        this.head = new Point3D();
    }

    public Vector(Vector v) {
        this.head = new Point3D(v.head);
    }

    public Vector(Point3D pt1, Point3D pt2) {

        if (pt1.equals(pt2)) {
            throw new IllegalArgumentException("pt1 == pt2");
        }
        setHead(new Point3D(
                pt2.getX().subtract(pt1.getX()),
                pt2.getY().subtract(pt1.getY()),
                pt2.getZ().subtract(pt1.getZ())));
    }


    public Vector(double x, double y, double z) {
        this.head = new Point3D(x, y, z);
    }

    public Point3D getHead() {
        return head;
    }

    public void setHead(Point3D head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "" + head;
    }

    @Override
    public int compareTo(Vector o) {
        return this.head.compareTo(o.head);
    }

    public void add(Vector v) {
        head.add(v);
    }

    public Vector subtract(Vector v) {

        head.subtract(v);
        return this;
    }

    public Vector scale(double scalingFactor) {
        this.head.setX(head.getX().scale(scalingFactor));
        this.head.setY(head.getY().scale(scalingFactor));
        this.head.setZ(head.getZ().scale(scalingFactor));

        return this;
    }

    public double length() {
        double x = this.getHead().getX().getCoordinate();
        double z = this.getHead().getZ().getCoordinate();
        double y = this.getHead().getY().getCoordinate();

        return sqrt(
                Util.uadd(
                        Util.uadd(
                                Util.uscale(x, x),
                                Util.uscale(y, y)),
                        Util.uscale(z, z)));

    }

    public Vector normalize() throws ArithmeticException // Throws exception if length = 0
    {
        double len = length();
        if (len == 0) {
            throw new ArithmeticException("length is 0");
        }
        scale(1.0 / len);
        return this;
    }

    public double dotProduct(Vector vector) {

        double x1 = this.getHead().getX().getCoordinate();
        double y1 = this.getHead().getY().getCoordinate();
        double z1 = this.getHead().getZ().getCoordinate();

        double x2 = vector.getHead().getX().getCoordinate();
        double y2 = vector.getHead().getY().getCoordinate();
        double z2 = vector.getHead().getZ().getCoordinate() ;

        return Util.uadd(
                Util.uadd(
                        Util.uscale(x1, x2),
                        Util.uscale(y1, y2)),
                Util.uscale(z1, z2));

    }

    public Vector crossProduct(Vector vector) {

        double x1 = this.getHead().getX().getCoordinate();
        double y1 = this.getHead().getY().getCoordinate();
        double z1 = this.getHead().getZ().getCoordinate();

        double x2 = vector.getHead().getX().getCoordinate();
        double y2 = vector.getHead().getY().getCoordinate();
        double z2 = vector.getHead().getZ().getCoordinate();

        Point3D pt = new Point3D(
                new Coordinate(Util.usubtract(Util.uscale(y1, z2), Util.uscale(z1, y2))),
                new Coordinate(Util.usubtract(Util.uscale(z1, x2), Util.uscale(x1, z2))),
                new Coordinate(Util.usubtract(Util.uscale(x1, y2), Util.uscale(y1, x2))));
        if (pt.equals(Point3D.ZERO)) {
            return new Vector();
        }
        return new Vector(pt);
    }
}
