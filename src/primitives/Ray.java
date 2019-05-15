package primitives;

public class Ray implements Comparable<Ray> {
    private Point3D POO;
    private Vector direction;

    public Ray() {
        POO = new Point3D();
        direction = new Vector();
    }

    public Ray(Point3D POO, Vector direction) {

        this.POO = new Point3D(POO);
        this.direction =new Vector(direction);
    }

    public Point3D getPOO() {
        return POO;
    }

    public void setPOO(Point3D POO) {
        this.POO = POO;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public Ray(Ray r){
        this.POO = new Point3D(r.POO);
        this.direction = new Vector(r.direction);
    }

    @Override
    public String toString() {
        return "{" + POO + "," + direction +'}';
    }

    @Override
    public int compareTo(Ray o) {
        return this.POO.compareTo(o.POO)+this.direction.compareTo(o.direction);
    }
}
