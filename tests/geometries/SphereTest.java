package geometries;

import org.junit.Test;
import primitives.Point3D;

import static org.junit.Assert.*;

public class SphereTest {

    @Test
    public void getNormal() {
        Sphere s = new Sphere(1, new Point3D(0, 0, 1));
        assertEquals("(0.0,1.0,0.0)",s.getNormal(new Point3D(0,1,1)).toString());
    }
}