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

    /**
     * Computes the radius of the smallest circle containing all three points (p1, p2, p3)
     * If one angle of the triangle is obtuse:
     * the smallest circle containing the triangle has the opposite side as diameter
     * Else:
     * the smallest circle is the circumscribed circle.
     * the radius is computed thanks to the law of sines : R = a * b * c / (4 * S)
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     * @return radius of the smallest circle containing p1, p2 and p3
     */
    public static double smallestCircleRadius(Point p1, Point p2, Point p3) {
        // checking if any of the angles is obtuse
        if (p1.angle(p2, p3) > Math.PI) {
            return (p2.distance(p3)/2);
        }
        if (p2.angle(p1, p3) > Math.PI) {
            return (p1.distance(p3)/2);
        }
        if (p3.angle(p1, p2) > Math.PI) {
            return (p1.distance(p2)/2);
        }
        // else, computing the radius of the circumscribed circle
        else {
            return (p2.distance(p3) * p1.distance(p2) * p1.distance(p3) / (4 * triangleArea(p1, p2, p3)));
        }
    }

}
