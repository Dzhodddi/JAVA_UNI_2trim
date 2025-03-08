package org.example;

public class Point{
    private final double x;
    private final double y;
    private final double z;
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lengthBetweenPoints(Point point) {
        return Math.sqrt((x - point.x) * (x - point.x) + (y - point.y) * (y - point.y) +
                (z - point.z) * (z - point.z));

    }

}
