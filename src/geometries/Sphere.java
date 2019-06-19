package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

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
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersectionPoints= new ArrayList<Point3D>(2);

        Vector u = new Vector(ray.getPOO(), this.getCenter());
        double tm = u.dotProduct(ray.getDirection());
        double d = Math.sqrt((u.length()*u.length()) - (tm*tm));

        if (d > this.getRadius())
            return intersectionPoints; // return null;

        double th = Math.sqrt((this.getRadius()*this.getRadius()) - (d*d));

        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 >= 0){
            Vector V = ray.getDirection();
            V.scale(t1);
            Point3D p = ray.getPOO();
            Point3D P1 =p.addVector(V);
            intersectionPoints.add(P1);
        }

        if (t2 >= 0){
            Vector V = ray.getDirection();
            V.scale(t2);
            Point3D p = ray.getPOO();
            Point3D P2 =p.addVector(V);
            intersectionPoints.add(P2);
        }

        return intersectionPoints;
    }

    @Override
    public int compareTo(RadialGeometry o) {
        if (!( o instanceof Sphere))
            return -1;
        return super.compareTo(o)+this.center.compareTo(((Sphere) o).center);
    }
}
