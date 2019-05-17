package geometries;

import primitives.*;

import java.awt.*;

public class Triangle extends Geometry implements Comparable<Triangle> {

    private Point3D p1;
    private Point3D p2;
    private Point3D p3;

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        this.p1 = new Point3D(p1);
        this.p2 = new Point3D(p2);
        this.p3 = new Point3D(p3);
    }

    public Triangle() {
        this.p1 = new Point3D(1, 0, 0);
        this.p2 = new Point3D(0, 1, 0);
        this.p3 = new Point3D(0, 0, 1);
    }

    public Triangle(Triangle t) {
        this.p1 = new Point3D(t.p1);
        this.p2 = new Point3D(t.p2);
        this.p3 = new Point3D(t.p3);
    }

    public Point3D getP1() {
        return p1;
    }

    public void setP1(Point3D p1) {
        this.p1 = p1;
    }

    public Point3D getP2() {
        return p2;
    }

    public void setP2(Point3D p2) {
        this.p2 = p2;
    }

    public Point3D getP3() {
        return p3;
    }

    public void setP3(Point3D p3) {
        this.p3 = p3;
    }

    @Override
    public Vector getNormal(Point3D p3d) {
        Vector normalVector = (new Vector(p2, p1).crossProduct(new Vector(p3, p1)));
        try {
            normalVector.normalize();
        } catch (ArithmeticException e) {

        }
        return normalVector;
    }

    @Override
    public int compareTo(Triangle o) {
        return this.p1.compareTo(o.p1) + p2.compareTo(o.p2) + p3.compareTo(o.p3);
    }
}
