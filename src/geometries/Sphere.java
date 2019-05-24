package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere extends RadialGeometry {

    private Point3D center;

    public Sphere(double radius, Point3D center) {
        super(radius);
        this.center = center;
    }

    public Sphere() {
        super();
        center=new Point3D();
    }

    public Sphere(Sphere s){
        super(s.getRadius());
        center=new Point3D(s.center);
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "{"+getRadius()+","+center+"}";
    }

    @Override
    public Vector getNormal(Point3D p3d) {
        Vector v = new Vector(center,p3d);
        try {
            v.normalize();
        }catch(ArithmeticException e){
            return null;
        }
        return v;
    }

    @Override
    public int compareTo(RadialGeometry o) {
        if (!( o instanceof Sphere))
            return -1;
        return super.compareTo(o)+this.center.compareTo(((Sphere) o).center);
    }
}
