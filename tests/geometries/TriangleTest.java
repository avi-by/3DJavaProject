package geometries;

import org.junit.Test;
import primitives.Point3D;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void getNormal() {
        Triangle t = new Triangle( new Point3D(0.0,1.0,0.0),
                new Point3D(1.0,0.0,0.0),
                new Point3D(0.0,0.0,1.0));
        assertEquals("(0.5773502691896258,0.5773502691896258,0.5773502691896258)",t.getNormal(new Point3D()).toString());
    }
}