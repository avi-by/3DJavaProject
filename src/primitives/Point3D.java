package primitives;

public class Point3D extends Point2D {
    Coordinate z;

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        super();
        z.coordinate=0;
    }
}
