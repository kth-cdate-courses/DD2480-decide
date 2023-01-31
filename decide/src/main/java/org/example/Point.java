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
     *
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
     * the radius is computed with the formula : R = a * b * c / (4 * S)
     *
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     * @return radius of the smallest circle containing p1, p2 and p3
     */
    public static double smallestCircleRadius(Point p1, Point p2, Point p3) {
        // checking if any of the angles is obtuse
        if (p1.angle(p2, p3) > Math.PI / 2) {
            return (p2.distance(p3) / 2);
        }
        if (p2.angle(p1, p3) > Math.PI / 2) {
            return (p1.distance(p3) / 2);
        }
        if (p3.angle(p1, p2) > Math.PI / 2) {
            return (p1.distance(p2) / 2);
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
     * Get the intersect point between the line formed by p2 -> p3
     * and the perpendicular line through "this" point.
     */
    public Point getIntersectPoint(Point p2, Point p3) {

        // If p2 and p3 are the same then 
        if (p2.isEqualTo(p3)) {
            throw new Error("p2 and p3 are the same point");
        }


        // Edge case here when k1 is completely horizontal (or vertical)
        // That will create a division by 0 if we don't have this check  
        if (p3.y == p2.y) {
            return new Point(x, p2.y);
        } else if (p3.x == p2.x) {
            return new Point(p2.x, y);
        }

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

