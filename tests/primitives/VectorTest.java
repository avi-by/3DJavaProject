package primitives;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    private Vector v1 = new Vector(1,2,3);
    private Vector v2 = new Vector(2,4,6);

    @Test
    public void add() {
        v1.add(v2);
        assertEquals("(3.0,6.0,9.0)",v1.toString());
    }

    @Test
    public void subtract() {
        Vector v3 = new Vector(v1);
        v1.subtract(v2);
        v2.subtract(v3);
        assertEquals("(-1.0,-2.0,-3.0)",v1.toString());
        assertEquals("(1.0,2.0,3.0)",v2.toString());
    }

    @Test
    public void scale() {
        v1.scale(2);
        assertEquals("(2.0,4.0,6.0)",v1.toString());
    }

    @Test
    public void length() {
        assertEquals(Math.sqrt(14),v1.length(),1e-10);
    }

    @Test
    public void normalize() {
        v1.normalize();
        assertEquals(1,v1.length(),1e-10);
        v1=new Vector(-21,-43,543);
        v1.normalize();
        assertEquals(1,v1.length(),1e-10);
    }

    @Test
    public void dotProduct() {
        v2=new Vector(4,-5,6);
        assertEquals(12.0, v1.dotProduct(v2),1e-10);

    }

    @Test
    public void crossProduct() {
        v1=new Vector(3,-3,1);
        v2=new Vector(4,9,2);
        v1=v1.crossProduct(v2);
        assertEquals("(-15.0,-2.0,39.0)",v1.toString());
    }
}