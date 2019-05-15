package primitives;

public class Vector implements Comparable<Vector> {
    private Point3D head;

    public Vector(Point3D head) {
        this.head = new Point3D(head);
    }

    public Vector() {
        this.head = new Point3D();
    }

    public  Vector(Vector v){
        this.head = new Point3D(v.head);
    }

    public Point3D getHead() {
        return head;
    }

    public void setHead(Point3D head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return ""+head;
    }

    @Override
    public int compareTo(Vector o) {
        return this.head.compareTo(o.head);
    }

    public void add(Vector v){
        head.add(v);
    }

    public void subtract(Vector v){
        head.subtract(v);
    }

    public void scale(double scalingFacor){
        this.head.setX(new Coordinate(head.getX().getCoordinate()*scalingFacor));
        this.head.setY(new Coordinate(head.getY().getCoordinate()*scalingFacor));
        this.head.setZ(new Coordinate(head.getZ().getCoordinate()*scalingFacor));
    }

    public double length() {
        return Math.sqrt(Math.pow(head.getX().getCoordinate(), 2) + Math.pow(head.getY().getCoordinate(), 2) + Math.pow(head.getZ().getCoordinate(), 2));
    }

    public void normalize() throws ArithmeticException // Throws exception if length = 0
    {
        double len = length();
        if (len == 0) {
            throw new ArithmeticException("length is 0");
        }
        scale(1.0/len);
    }

    public double dotProduct(Vector v) {
        return this.head.getX().getCoordinate()*v.head.getX().getCoordinate()
                + this.head.getY().getCoordinate()*v.head.getY().getCoordinate()
                + this.head.getZ().getCoordinate()*v.head.getZ().getCoordinate();
    }

    public Vector crossProduct(Vector vector) {
        Vector v = new Vector();
        v.head.setX(new Coordinate(head.getY().getCoordinate() * vector.head.getZ().getCoordinate() - head.getZ().getCoordinate() * vector.head.getY().getCoordinate()));
        v.head.setY(new Coordinate(head.getZ().getCoordinate() * vector.head.getX().getCoordinate() - head.getX().getCoordinate() * vector.head.getZ().getCoordinate()));
        v.head.setZ(new Coordinate(head.getX().getCoordinate() * vector.head.getY().getCoordinate() - head.getY().getCoordinate() * vector.head.getX().getCoordinate()));

        return v;
    }
}
