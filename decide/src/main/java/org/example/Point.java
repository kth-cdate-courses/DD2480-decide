package org.example;

import java.util.Optional;

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
     * If one of the outer points coincides with the vertex, the angle is undefined.
     * We then return an empty optional value
     * @param p2 first outer point of the angle
     * @param p3 second outer point of the angle
     * @return Option containing either the angle formed by (p,p2) and (p,p3) in rad if it is defined, or empty value
     */
    public Optional<Double> angle(Point p2, Point p3) {
        if (distance(p2) == 0 || distance(p3) == 0)
        {
            return Optional.empty();
        }
        double scalarProduct = (p2.x - x) * (p3.x - x) + (p2.y - y) * (p3.y - y);
        return Optional.of(Math.acos(scalarProduct / (distance(p2) * distance(p3))));
    }

    /**
     * Computes the radius of the smallest circle containing all three points (p1, p2, p3)
     * If one angle of the triangle is obtuse:
     * the smallest circle containing the triangle has the opposite side as diameter
     * Else:
     * the smallest circle is the circumscribed circle.
     * the radius is computed with the formula : R = a * b * c / (4 * S)
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     * @return radius of the smallest circle containing p1, p2 and p3
     */
    public static double smallestCircleRadius(Point p1, Point p2, Point p3) {
        Optional<Double> angle1 = p1.angle(p2, p3);
        Optional<Double> angle2 = p2.angle(p1, p3);
        Optional<Double> angle3 = p3.angle(p1, p2);
        // checking if any of the angles is undefined or obtuse
        if (angle1.isEmpty() || p1.angle(p2, p3).get() > Math.PI / 2){
            return (p2.distance(p3) / 2);
        }
        if (angle2.isEmpty() || p2.angle(p1, p3).get() > Math.PI / 2) {
            return (p1.distance(p3)/2);
        }
        if (angle3.isEmpty() ||p3.angle(p1, p2).get() > Math.PI / 2) {
            return (p1.distance(p2)/2);
        }
        // else, computing the radius of the circumscribed circle
        else {
            return (p2.distance(p3) * p1.distance(p2) * p1.distance(p3) / (4 * triangleArea(p1, p2, p3)));
        }
    }

    /**
     * Determines the quadrant in which the point is set.
     * Priority is given to the first quadrant in the order I, II, III, IV in case of ambiguity.
     * @return int representing the quadrant I, II, III or IV
     */
    public int quadrant() {
        if (x >= 0) {
            if (y >= 0) {
                return 1;
            } else {
                return 2;
            }
        } else {
            if (y < 0) {
                return 3;
            } else {
                return 4;
            }
        }
    }

    /**
     * Returns a boolean stating whether a set of POINTS lie in more than QUADS quadrants.
     * We interpret "more" in a strict way.
     * @param points collection of points
     * @param quads number of quadrants
     * @return true if the points lie in strictly more than QUADS quadrants, else false
     */
    public static boolean quadrantRepartition(Point[] points, int quads){
        boolean[] occupiedQuads = new boolean[4];
        int quadrantCount = 0;
        for (Point point : points) {
            int quad = point.quadrant();
            if (!occupiedQuads[quad - 1]) {
                occupiedQuads[quad - 1] = true;
                quadrantCount += 1;
            }
        }
        return quadrantCount > quads;
    }

    public Boolean isEqualTo(Point other) {
        return x == other.x && y == other.y;
    }

    /*
     * Get intersect point between the line formed by p2 -> p3
     * and the perpendicular line through "this" point.
     */
    public Point getIntersectPoint(Point p2, Point p3) {
        // Get conflict point between p1 and p2
        int k1 = (p3.y - p2.y) / (p3.x - p2.x);
        int m1 = p2.y - k1 * p2.x;
        int k2 = -1 / k1;
        int m2 = y - k2 * x;
        int x = (m2 - m1) / (k1 - k2);
        int y = k1 * x + m1;
        return new Point(x, y);
    }
}
