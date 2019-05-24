package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Cylinder extends RadialGeometry{
    private Point3D axisPoint;
    private Vector axisDirection;

    public Cylinder() {
        super();
        axisPoint = new Point3D();
        axisDirection = new Vector();
    }

    public Cylinder (Cylinder c){
        super(c.getRadius());
        axisDirection = new Vector(c.axisDirection);
        axisPoint = new Point3D(c.axisPoint);
    }

    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection) {
        super(radius);
        this.axisPoint = axisPoint;
        this.axisDirection = axisDirection;
    }

    public Point3D getAxisPoint() {
        return axisPoint;
    }

    public void setAxisPoint(Point3D axisPoint) {
        this.axisPoint = axisPoint;
    }

    public Vector getAxisDirection() {
        return axisDirection;
    }

    public void setAxisDirection(Vector axisDirection) {
        this.axisDirection = axisDirection;
    }

    @Override
    public String toString() {
        return "{"+ axisPoint +
                "," + axisDirection +
                '}';
    }

    @Override
    public int compareTo(RadialGeometry o) {
        if (!(o instanceof Cylinder))
            return -1;
        return super.compareTo(o)+axisPoint.compareTo(((Cylinder) o).axisPoint)+axisDirection.compareTo(((Cylinder) o).axisDirection);
    }

    @Override
    public Vector getNormal(Point3D p3d) {
       //TODO
        return null;
    }

}
