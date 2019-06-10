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
        VUP.normalize();
        VTOWARD.normalize();
        VRIGHT.normalize();
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
        return centerView;
    }

    public void setCenterView(Point3D centerView) {
        this.centerView = centerView;
    }

    public Vector getVUP() {
        return VUP;
    }

    public void setVUP(Vector VUP) {
        this.VUP = VUP;
    }

    public Vector getVRIGHT() {
        return VRIGHT;
    }

    public void setVRIGHT(Vector VRIGHT) {
        this.VRIGHT = VRIGHT;
    }

    public Vector getVTOWARD() {
        return VTOWARD;
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

    public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,
                                  double screenDist, double screenWidth,
                                  double screenHeight){
        Vector temp =new Vector(VTOWARD);
        temp.scale(screenDist);
        Point3D pc = new Point3D(centerView);
        pc.add(temp);
        double Ry = screenHeight/Ny;
        double Rx = screenWidth/Nx;
        Point3D Pij=calculatePij(Nx, Ny, x, y, pc, Ry, Rx);
        Vector Vij =new Vector(centerView,Pij);
        Vij.normalize();
        Ray ray = new Ray(centerView,Vij);
        return ray;
    }

    private Point3D calculatePij(int Nx, int Ny, double i, double j, Point3D pc, double ry, double rx) {
       double yj = (j-Ny/2)*ry+ry/2;
       double xi =(i-Nx/2)*rx+rx/2;
       Vector Vright = new Vector(VRIGHT);
       Vector Vup = new Vector(VUP);
       Vright.scale(xi);
       Vup.scale(yj);
       Vector v =Vright.subtract(Vup);
       Point3D pij =pc.add(v);
       return pij;
    }

}
