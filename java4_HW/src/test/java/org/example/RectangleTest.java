package org.example;

public class RectangleTest {



    public static void main(String[] args) {
        Rectangle r = new Rectangle(0, 0, 5 , 4);
        System.out.println(r);
        r.move(2,3);
        System.out.println(r);
        r.move(-2,-3);
        System.out.println(r);
        System.out.println(r.checkIfPointInRectangle(2,2));
        r.joinOfTwoRectangles(new Rectangle(5, 3, 11, 10));
        Rectangle r1 = new Rectangle(2, 1, 5, 3);
        r1.joinOfTwoRectangles(new Rectangle(3, 2, 7, 4));
        Rectangle r2 = new Rectangle(-3, 3, -1, 6);
        r2.joinOfTwoRectangles(new Rectangle(0,0, 5, 4));
        Rectangle r3 = new Rectangle(0, 0, 7, 6);
        r3.joinOfTwoRectangles(new Rectangle(1, 5, 6 , 2));
        Rectangle r4 = new Rectangle(0, 0, 3, 4);
        r4.joinOfTwoRectangles(new Rectangle(3, 4, 6, 7));

    }

}