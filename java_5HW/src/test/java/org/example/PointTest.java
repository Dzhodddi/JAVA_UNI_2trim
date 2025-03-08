package org.example;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PointTest {

    @Test
    public void lengthBetweenPoints() {
        Point point = new Point(3,0, 0);
        Point point2 = new Point(0,4, 0);
        Point point3 = new Point(-3,0, 0);
        assertTrue(0 == point.lengthBetweenPoints(point));
        assertTrue(5 == point.lengthBetweenPoints(point2));
        assertTrue(5 == point2.lengthBetweenPoints(point));
        assertTrue(6 == point.lengthBetweenPoints(point3));
        assertTrue(5 == point3.lengthBetweenPoints(point2));
    }


}