package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test
    public void getNormal() {
        Plane p = new Plane(new Point3D(1,2,3),new Vector(5,0,4));
        assertEquals("(5.0,0.0,4.0)",p.getNormal().toString());
    }
}