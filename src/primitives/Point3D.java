package primitives;

public class Point3D extends Point2D {
    private Coordinate z;

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.z = new Coordinate(z);
    }

    public Point3D() {
        super();
        z = new Coordinate();
    }

    public Point3D(Point3D p) {
        super(p.x, p.y);
        this.z = new Coordinate(p.z);
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = new Coordinate(z);
    }

    public Coordinate getZ() {
        return z;
    }

    public void setZ(Coordinate z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }

    @Override
    public int compareTo(Point2D p3d) {
        if (!(p3d instanceof Point3D)) {
            return -1;
        }
        Point2D tempP2d = new Point2D(p3d);
        Point2D tempThisP2d = new Point2D(this);

        if ((tempThisP2d.compareTo(tempP2d) + z.compareTo(((Point3D) p3d).z)) == 0)
            return 0;
        else
            return -1;
    }

    public Point3D add(Vector vector) {

        this.x.add(vector.getHead().getX());
        this.y.add(vector.getHead().getY());
        this.z.add(vector.getHead().getZ());
        return this;
    }

    public Point3D subtract(Vector vector) {

        this.x.subtract(vector.getHead().getX());
        this.y.subtract(vector.getHead().getY());
        this.z.subtract(vector.getHead().getZ());
        return this;
    }

}
