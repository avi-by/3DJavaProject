package geometries;

public abstract class RadialGeometry extends Geometry implements Comparable<RadialGeometry> {

    private double radius;

    public RadialGeometry(double radius) {
        this.radius = radius;
    }

    public RadialGeometry() {
        radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(RadialGeometry o) {
        return radius == o.radius ? 0 : -1;
    }
}
