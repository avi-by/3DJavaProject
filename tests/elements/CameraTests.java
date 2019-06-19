package elements;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class CameraTests {

    @Test
    public void constructRayThroughPixel_1() {
        //System.out.println("Test Ray Through Pixel");

        Vector vup = new Vector(0, 1, 0);
        Vector vto = new Vector(0, 0, -1);

        Camera c = new Camera(new Point3D(), vup, vto);

        Ray ray = c.constructRayThroughPixel(3, 3, 3
                , 3, 100, 150, 150);
        Point3D centerPoint = new Point3D(0,0,0);
        Vector direction = new Vector(0.5773502691896258, -0.5773502691896258, -0.5773502691896258);

        Ray answer = new Ray(centerPoint, direction);
        assertEquals(answer.toString(), ray.toString());
        assertTrue(answer.getPOO().compareTo( ray.getPOO())==0);

    }

}