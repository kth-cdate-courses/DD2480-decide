package org.example;

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    public static double triangleArea(Point p1, Point p2, Point p3) {
        return Math.abs(p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0;
    }

    public Boolean isEqualTo(Point other) {
        return x == other.x && y == other.y;
    }

    /*
     * Get the intersect point between the line formed by p2 -> p3
     * and the perpendicular line through "this" point.
     */
    public Point getIntersectPoint(Point p2, Point p3) {
        // Get conflict point between p1 and p2
        int k1 = (p3.y - p2.y) / (p3.x - p2.x);
        int m1 = p2.y - k1 * p2.x;
        int k2 = k1 * -1;
        int m2 = y - k2 * x;
        int x = (m2 - m1) / (k1 - k2);
        int y = k1 * x + m1;
        return new Point(x, y);
    }
}
