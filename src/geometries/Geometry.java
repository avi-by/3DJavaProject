package geometries;

import primitives.*;

import java.awt.Color;

public abstract class Geometry {
    private Color color;

    public Geometry(Color color) {
        this.color = color;
    }

    public Geometry() {
        this.color = Color.black;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract Vector getNormal(Point3D p3d);
}
