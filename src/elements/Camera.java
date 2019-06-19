package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera implements Comparable<Camera> {
    private Point3D centerView;
    private Vector VUP;
    private Vector VRIGHT;
    private Vector VTOWARD;

    public Camera(Point3D centerView, Vector VUP, Vector VTOWARD) {
        this.centerView = new Point3D(centerView);
        this.VUP = new Vector( VUP);
        this.VTOWARD = new Vector( VTOWARD);
        this.VRIGHT = new Vector( VTOWARD.crossProduct(VUP));
    }

    public Camera() {
        centerView = new Point3D(0,0,0);
        VUP = new Vector(0,0,1);
        VTOWARD = new Vector(1,0,0);
        VRIGHT =  new Vector( VTOWARD.crossProduct(VUP));
    }

    public Camera(Camera c){
        centerView = new Point3D(c.centerView);
        VUP = new Vector(c.VUP);
        VRIGHT = new Vector(c.VRIGHT);
        VTOWARD = new Vector(c.VTOWARD);
    }

    public Point3D getCenterView() {
        return new Point3D(centerView);
    }

    public void setCenterView(Point3D centerView) {
        this.centerView = centerView;
    }

    public Vector getVUP() {
        return new Vector( VUP);
    }

    public void setVUP(Vector VUP) {
        this.VUP = VUP;
    }

    public Vector getVRIGHT() {
        return new Vector( VRIGHT);
    }

    public void setVRIGHT(Vector VRIGHT) {
        this.VRIGHT = VRIGHT;
    }

    public Vector getVTOWARD() {
        return new Vector( VTOWARD);
    }

    public void setVTOWARD(Vector VTOWARD) {
        this.VTOWARD = VTOWARD;
    }

    @Override
    public int compareTo(Camera o) {
        return centerView.compareTo(o.centerView)+VTOWARD.compareTo(o.VTOWARD)+VRIGHT.compareTo(o.VRIGHT)+VUP.compareTo(o.VUP);
    }

    @Override
    public String toString() {
        return "{"+ centerView +
                ", " + VUP +
                ", " + VRIGHT +
                ", " + VTOWARD +
                '}';
    }

    public Ray constructRayThroughPixel(int Nx, int Ny, double i, double j,
                                        double screenDist, double screenWidth,
                                        double screenHeight){


        // Calculating the image center
        Vector vToward = new Vector(VTOWARD);
        Vector vRight = new Vector(VRIGHT);
        Vector vUP = new Vector(VUP);

        vToward.normalize();
        vRight.normalize();
        vUP.normalize();

        Point3D Pc = getCenterView().addVector(vToward.scale(screenDist));

        // Calculating x-y ratios
        double Rx = screenWidth  / Nx;
        double Ry = screenHeight / Ny;

        // Calculating P - the intersection point
        double y_j = (j - (Ny / 2.0)) * Ry + (Ry / 2.0);
        double x_i = (i - (Nx / 2.0)) * Rx + (Rx / 2.0);

        vRight.scale(x_i);
        vUP.scale(y_j);
        Vector deltaV = vRight.subtract(vUP);
        Point3D p_ij = Pc.addVector(deltaV);
        Vector V_ij = new Vector(getCenterView(), p_ij);
        V_ij.normalize();
        // returning the constructed ray between P0 and the intersection point
        return new Ray(getCenterView(), V_ij);
    }

}
