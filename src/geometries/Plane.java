package geometries;
import primitives.*;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Geometry implements Comparable<Plane> {
    private Point3D p;
    private Vector normal;



    public Plane(Point3D p, Vector normal) {
        this.p = new Point3D(p);
        this.normal = new Vector(normal);
    }

    public Plane() {
        this.p = new Point3D();
        this.normal = new Vector(0,1,0);
    }

    public Plane(Plane pl){
        this.p =new Point3D(pl.p);
        this.normal = new Vector(pl.normal);
    }

    public Point3D getP() {
        return p;
    }

    public void setP(Point3D p) {
        this.p = p;
    }

    public Vector getNormal() {
        return normal;
    }

    public void setNormal(Vector normal) {
        this.normal = normal;
    }


    @Override
    public int compareTo(Plane o) {
        return this.p.compareTo(o.p)+this.normal.compareTo(o.normal);
    }

    @Override
    public Vector getNormal(Point3D p3d) {
        return this.normal;
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersectionPoints = new ArrayList<Point3D>();
        Point3D P0 = ray.getPOO();
        Point3D Q0 = this.getP();
        Vector N = this.getNormal(null);
        Vector V = ray.getDirection();

        if(N.dotProduct(V)==0)
        {
            // ray.getDirection() is parralel to the plane
            // no intersections points
            return intersectionPoints;
        }

        Vector u = new Vector(Q0, P0);
        double t = (N.dotProduct(u) * -1) / N.dotProduct(V);

        if (t >= 0) {
            V.scale(t);
            Point3D p = P0.addVector(V);
            intersectionPoints.add(p);
        }
        return intersectionPoints;
    }
}
