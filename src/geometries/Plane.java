package geometries;
import primitives.*;

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
}
