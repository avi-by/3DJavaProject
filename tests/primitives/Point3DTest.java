package primitives;

import org.junit.Test;

import static org.junit.Assert.*;

public class Point3DTest {
    private Point3D p = new Point3D(1,2,3);
    private Vector testVecter = new Vector(1,2,3);
    @Test
    public void testAdd() {
        p.add(testVecter);
        assertEquals("(2.0,4.0,6.0)",p.toString());
    }

    @Test
    public void testSubtract() {
        p.subtract(testVecter);
        assertEquals("(0.0,0.0,0.0)",p.toString());
    }
}