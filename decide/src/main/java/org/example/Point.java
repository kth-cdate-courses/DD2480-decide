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

    /**
     * Computes the angle from which Point p is the vertex.
     * @param p2 first outer point of the angle
     * @param p3 second outer point of the angle
     * @return the angle formed by (p,p2) and (p,p3) in rad
     */
    public double angle(Point p2, Point p3) {
        double scalarProduct = (p2.x - x) * (p3.x - x) + (p2.y - y) * (p3.y - y);
        return Math.acos(scalarProduct / (distance(p2) * distance(p3)));
    }
}
