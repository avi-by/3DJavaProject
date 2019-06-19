package geometries;

import primitives.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        normalVector.scale(-1);
        return normalVector;
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        List<Point3D> intersectionPoints = new ArrayList<Point3D>(1);

        // Intersecting the triangular plane

        Point3D P0 = ray.getPOO();

        Vector N = getNormal(null);

        Plane plane = new Plane(p3, N);
        if (plane.FindIntersections(ray).isEmpty())
            return intersectionPoints;

        Point3D intersectionPlane = plane.FindIntersections(ray).get(0);

        // Checking if the interseculating point is bounded by the triangle
        Vector P_P0 = new Vector(P0, intersectionPlane);

        // Checking 1/3 triangular side
        Vector V1_1 = new Vector(P0, this.p1);
        Vector V2_1 = new Vector(P0, this.p2);
        Vector N1 = V1_1.crossProduct(V2_1);
        N1.normalize();
        double S1 = -P_P0.dotProduct(N1);

        // Checking 2/3 triangular side
        Vector V1_2 = new Vector(P0, this.p2);
        Vector V2_2 = new Vector(P0, this.p3);
        Vector N2 = V1_2.crossProduct(V2_2);
        N2.normalize();
        double S2 = -P_P0.dotProduct(N2);

        // Checking 1/3 triangular side
        Vector V1_3 = new Vector(P0, this.p3);
        Vector V2_3 = new Vector(P0, this.p1);
        Vector N3 = V1_3.crossProduct(V2_3);
        N3.normalize();
        double S3 = -P_P0.dotProduct(N3);

        if (((S1 > 0) && (S2 > 0) && (S3 > 0)) ||
                ((S1 < 0) && (S2 < 0) && (S3 < 0))) {
            intersectionPoints.add(intersectionPlane);
        }

        return intersectionPoints;

    }

    @Override
    public int compareTo(Triangle o) {
        return this.p1.compareTo(o.p1) + p2.compareTo(o.p2) + p3.compareTo(o.p3);
    }
}
