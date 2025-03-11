package org.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParallelepipedTest {
    public static Parallelepiped parallelepiped = new Parallelepiped(new Point(0,0,0),
            new Point(4,0,0),
            new Point(0,3,0), 5, 45);

    public static Parallelepiped parallelepiped1 = new Parallelepiped(new Point(0,0,0),
            new Point(6,0,0),
            new Point(0,5,0), 7, 30);


    public static Parallelepiped parallelepiped2 = new Parallelepiped(new Point(0,0,0), 4, 3, 90, 5, 45);
    public static Parallelepiped parallelepiped3 = new Parallelepiped(new Point(1,2,0), 6, 4, 60, 8, 30);

//    public static void main(String [] args) {
//        System.out.println(parallelepiped3.angleBAD);
//        System.out.println(parallelepiped3.surfaceArea());
//    }

    @Test
    public void testSurfaceArea() {
        assertTrue(12 == parallelepiped.surfaceArea());
        assertTrue(30 == parallelepiped1.surfaceArea());
        assertTrue(12 == parallelepiped2.surfaceArea());
        assertEquals(20.78 , parallelepiped3.surfaceArea(), 0.1);
    }
//    @Test
//    public void testFindHeight() {
//        assertEquals(3.5, parallelepiped.findHeight(), 0.1);
//        assertEquals(6, parallelepiped1.findHeight(), 0.1);
//        assertEquals(3.535, parallelepiped2.findHeight(), 0.1);
//        assertEquals(6.928, parallelepiped3.findHeight(), 0.1);
//    }
//    @Test
//    public void testFindExtent() {
//        assertEquals(42.42, parallelepiped.findExtent(), 0.1);
//        assertEquals(181.86, parallelepiped1.findExtent(), 0.1);
//        assertEquals(42.42, parallelepiped2.findExtent(), 0.1);
//        assertEquals(144, parallelepiped3.findExtent(), 0.1);
//    }






}