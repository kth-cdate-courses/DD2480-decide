package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {

    //Test should resolve to true. Parameters: LENGTH1 = 5. Max distances between points are 6. Test corresponds with LIC 0
    @Test
    void condition0_LENGTH1_equals_5_with_two_points_distances_longer_than_5_TRUE() {
        int numPoints = 2;
        Point[] points = {new Point(0,0), new Point(0,6)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(5, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition0());
    }

    //Test should resolve to false. Parameters: LENGTH1 = 5. Max distances between points are 4. Test corresponds with LIC 0
    @Test
    void condition0_LENGTH1_equals_5_with_no_points_distances_longer_than_5_FALSE() {
        int numPoints = 2;
        Point[] points = {new Point(0,0), new Point(0,4)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(5, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition0());
    }

    //Test should resolve to true. Parameters: RADIUS1 = 5. point4 not in circle. Test corresponds with LIC 1
    @Test
    void condition1_RADIUS1_equals_5_with_3_points_not_inside_circle_TRUE() {
        int numPoints = 4;
        Point[] points = {new Point(0,1), new Point(1,0), new Point(0, -1), new Point(5, -12)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 5, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition1());
    }

    //Test should resolve to false. Parameters: RADIUS1 = 5. All points in circle. Test corresponds with LIC 1
    @Test
    void condition1_RADIUS1_equals_5_with_all_points_inside_circle_FALSE() {
        int numPoints = 4;
        Point[] points = {new Point(0,1), new Point(1,0), new Point(0, -1), new Point(3, 4)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 5, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition1());
    }

    //Test should resolve to true. Parameters: EPSILON = PI/3. angle between points is PI/2. Test corresponds with LIC 2
    @Test
    void condition2_EPSILON_equals_PI_divided_by_3_angle_is_PI_divided_by_2_TRUE() {
        int numPoints = 3;
        Point[] points = {new Point(0,1), new Point(0,0), new Point(1, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, Math.PI/3, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition2());
    }

    //Test should resolve to false. Parameters: EPSILON = PI. angle between points is PI/2. Test corresponds with LIC 2
    @Test
    void condition2_EPSILON_equals_PI_angle_is_PI_divided_by_2_FALSE() {
        int numPoints = 3;
        Point[] points = {new Point(0,1), new Point(0,0), new Point(0, 1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, Math.PI, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition2());
    }

    //Test should resolve to true. Parameters: AREA1 = 1. max triangle area is 2 (between points 2,3,4). Test corresponds with LIC 3
    @Test
    void condition3_AREA1_equals_1_max_triangle_area_is_2_TRUE() {
        int numPoints = 4;
        Point[] points = {new Point(1, 2), new Point(0,2), new Point(0,0), new Point(2, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 1, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition3());
    }

    //Test should resolve to false. Parameters: AREA1 = 2. max triangle area is 1/2 (between points 1,2,3). Test corresponds with LIC 3
    @Test
    void condition3_AREA1_equals_2_max_triangle_area_is_1_divided_by_2_FALSE() {
        int numPoints = 4;
        Point[] points = {new Point(-1, 0), new Point(0,1), new Point(0,0), new Point(0, 1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 2, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition3());
    }

    //Test should resolve to true. Parameters: QUADS = 2, Q_PTS = 3. Points exist in 3 quadrants. Test corresponds with LIC 4
    @Test
    void condition4_QUADS_equals_2_QPTS_equals_3_points_in_3_quadrants_TRUE() {
        int numPoints = 4;
        Point[] points = {new Point(0, 2), new Point(1,1), new Point(1,-1), new Point(-1, -1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 3, 2, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition4());
    }

    //Test should resolve to false. Parameters: QUADS = 3, Q_PTS = 3. Points exist in 2 quadrants. Test corresponds with LIC 4
    @Test
    void condition4_QUADS_equals_3_QPTS_equals_3_points_in_2_quadrants_FALSE() {
        int numPoints = 4;
        Point[] points = {new Point(0, 2), new Point(1,1), new Point(1,2), new Point(1, -1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 3, 3, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition4());
    }

    //Test should resolve to true. Parameters: none. x-value of point 2 larger than x-value of point 3. Test corresponds with LIC 5
    @Test
    void condition5_two_consecutive_points_where_xj_minus_xi_less_than_0_TRUE() {
        int numPoints = 3;
        Point[] points = {new Point(0,1), new Point(2,2), new Point(1, 1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition5());
    }

    //Test should resolve to false. Parameters: none.
    //points ordered such that x-values are in ascending order, so conditions never met. Test corresponds with LIC 5
    @Test
    void condition5_no_consecutive_points_where_xj_minus_xi_less_than_0_FALSE() {
        int numPoints = 3;
        Point[] points = {new Point(0,1), new Point(1,2), new Point(2, 1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition5());
    }

    //Test should resolve to true. Parameters: N_PTS = 3, DIST = 2.
    //Point3 is distance 3 away from line between point2 and point4. Test corresponds with LIC 6
    @Test
    void condition6_NPTS_equals_3_DIST_equals_2_TRUE() {
        int numPoints = 4;
        Point[] points = {new Point(0,1), new Point(1,0), new Point(4, 1), new Point(1,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 0, 0, 2, 3, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition6());
    }

    //Test should resolve to false. Parameters: N_PTS = 3, DIST = 4.
    //Point3 is distance 3 away from line between point2 and point4. Test corresponds with LIC 6
    @Test
    void condition6_NPTS_equals_3_DIST_equals_4_FALSE() {
        int numPoints = 4;
        Point[] points = {new Point(0,1), new Point(1,0), new Point(4, 1), new Point(1,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 0, 0, 4, 3, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition6());
    }

    //Test should resolve to true. Parameters: K_PTS = 2, LENGTH1 = 2.
    //point2 and point5 separated by distance 4. Test corresponds with LIC 7
    @Test
    void condition7_KPTS_equals_2_LENGTH1_equals_2_exists_points_TRUE() {
        int numPoints = 5;
        Point[] points = {new Point(0,0), new Point(0,1), new Point(1,0), new Point(0, -1), new Point(0,5)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(2, 0, 0, 0, 0, 0, 2, 0, 2, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition7());
    }

    //Test should resolve to false. Parameters: K_PTS = 2, LENGTH1 = 5.
    //no points separated by more than distance 5. Test corresponds with LIC 7
    @Test
    void condition7_KPTS_equals_2_LENGTH1_equals_5_doesnt_exists_points_FALSE() {
        int numPoints = 5;
        Point[] points = {new Point(0,0), new Point(0,1), new Point(1,0), new Point(0, -1), new Point(0,5)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(5, 0, 0, 0, 0, 0, 2, 0, 2, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition7());
    }

    //Test should resolve to true. Parameters: RADIUS1 = 2, A_PTS = 1, B_PTS = 1.
    //point2, point4, and point6 cannot be contained in a circle with radius 2. Test corresponds with LIC 8
    @Test
    void condition8_RADIUS1_equals_2_APTS_equals_1_BPTS_equals_1_exists_points_TRUE() {
        int numPoints = 6;
        Point[] points = {new Point(0,0), new Point(0,0), new Point(0,1), new Point(1,0), new Point(0, -1), new Point(0,6)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 2, 0, 0, 0, 0, 0, 0, 0, 1 , 1, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition8());
    }

    //Test should resolve to false. Parameters: RADIUS1 = 2, A_PTS = 1, B_PTS = 1.
    //all points are grouped together in such a way that condition is never met. Test corresponds with LIC 8
    @Test
    void condition8_RADIUS1_equals_2_APTS_equals_1_BPTS_equals_1_doesnt_exists_points_FALSE() {
        int numPoints = 6;
        Point[] points = {new Point(0,0), new Point(0,0), new Point(0,1), new Point(1,0), new Point(0, -1), new Point(0,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 2, 0, 0, 0, 0, 0, 0, 0, 1 , 1, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition8());
    }

    //Test should resolve to true. Parameters: EPSILON = PI/3, C_PTS = 1, D_PTS = 1.
    //angle between point1, point3, and point 5 is PI/2. Test corresponds with LIC 9
    @Test
    void condition9_EPSILON_equals_PI_over_2_CPTS_equals_1_DPTS_equals_1_exists_points_TRUE() {
        int numPoints = 5;
        Point[] points = { new Point(1,0), new Point(2,1), new Point(0,0), new Point(1, 0), new Point(0,-1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, Math.PI/3, 0, 0, 0, 0, 0, 0, 0 , 0, 1, 1, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition9());
    }

    //Test should resolve to false. Parameters: EPSILON = PI/2, C_PTS = 1, D_PTS = 1.
    //angle between point1, point3, and point 5 is 2PI/3. Test corresponds with LIC 9
    @Test
    void condition9_EPSILON_equals_PI_over_2_CPTS_equals_1_DPTS_equals_1_doesnt_exist_points_FALSE() {
        int numPoints = 5;
        Point[] points = {new Point(0,1), new Point(1,1), new Point(0,0), new Point(-1, 0), new Point(1,-1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, Math.PI/2, 0, 0, 0, 0, 0, 0, 0 , 0, 1, 1, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition9());
    }

    //Test should resolve to true. Parameters: AREA1 = 1, E_PTS = 1, F_PTS = 1.
    //triangle with vertexes in point1, point3, and point5 has area 2. Test corresponds with LIC 10
    @Test
    void condition10_AREA1_equals_1_EPTS_equals1_FPTS_equals_1_exist_such_triangle_TRUE() {
        int numPoints = 5;
        Point[] points = { new Point(2,0), new Point(1,1), new Point(0,0), new Point(-1, 0), new Point(0,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 1, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 1,1, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition10());
    }

    //Test should resolve to false. Parameters: AREA1 = 3, E_PTS = 1, F_PTS = 1.
    //triangle with vertexes in point1, point3, and point5 has area 2. Test corresponds with LIC 10
    @Test
    void condition10_AREA1_equals_3_EPTS_equals1_FPTS_equals_1_exist_no_such_triangle_FALSE() {
        int numPoints = 5;
        Point[] points = { new Point(2,0), new Point(1,1), new Point(0,0), new Point(-1, 0), new Point(0,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 3, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 1,1, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition10());
    }

    //Test should resolve to true. Parameters: G_PTS = 1.
    //x-value of point2 larger than x-value of point4. Test corresponds with LIC 11
    @Test
    void condition11_GPTS_equals_1_exists_such_points_TRUE() {
        int numPoints = 4;
        Point[] points = { new Point(1,0), new Point(4,0), new Point(2,0), new Point(3, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 1, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition11());
    }

    //Test should resolve to false. Parameters: G_PTS = 1.
    //x-values of points separated by G_PTS is always larger for the rightmost point. Test corresponds with LIC 11
    @Test
    void condition11_GPTS_equals_1_exists_no_such_points_FALSE() {
        int numPoints = 4;
        Point[] points = { new Point(1,0), new Point(3,0), new Point(2,0), new Point(4, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 1, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition11());
    }

    //Test should resolve to true. Parameters: K_PTS = 1, LENGTH1 = 2, LENGTH2 = 3.
    //point1 and point3 are length 3 apart (greater than LENGTH1), point2 and point4 are length 2 apart (less than LENGTH2).
    //Test corresponds with LIC 12
    @Test
    void condition12_KPTS_equals_1_LENGTH1_equals_2_LENGTH2_equals_3_exist_such_points_TRUE() {
        int numPoints = 4;
        Point[] points = { new Point(0,0), new Point(2,0), new Point(3,0), new Point(4, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(2, 0, 0, 0, 0, 0, 0, 0, 1, 0 , 0, 0, 0, 0,0, 0, 3, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition12());
    }

    //Test should resolve to false. Parameters: K_PTS = 1, LENGTH1 = 2, LENGTH2 = 3.
    //point1 and point3 are length 1 apart (less than LENGTH1), point2 and point4 are length 2 apart (less than LENGTH2).
    //Test corresponds with LIC 12
    @Test
    void condition12_KPTS_equals_1_LENGTH1_equals_2_LENGTH2_equals_3_exist_no_such_points_FALSE() {
        int numPoints = 4;
        Point[] points = { new Point(0,0), new Point(2,0), new Point(1,0), new Point(4, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(2, 0, 0, 0, 0, 0, 0, 0, 1, 0 , 0, 0, 0, 0,0, 0, 3, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition12());
    }

    //Test should resolve to true. Parameters: RADIUS1 = 4, RADIUS2 = 11, A_PTS = 1, B_PTS = 1.
    //point1, point3, point5 cannot be contained in circle with radius 4, but can be contained within circle with radius 11.
    //Test corresponds with LIC 13
    @Test
    void condition13_RADIUS1_equals_4_RADIUS2_equals_11_APTS_equals_1_BPTS_equals_1_TRUE() {
        int numPoints = 5;
        Point[] points = { new Point(3,0), new Point(0,-1), new Point(0,3), new Point(2, 1), new Point(6,8)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 4, 0, 0, 0, 0, 0, 0, 0, 1 , 1, 0, 0, 0,0, 0, 0, 11, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition13());
    }

    //Test should resolve to false. Parameters: RADIUS1 = 11, RADIUS2 = 12, A_PTS = 1, B_PTS = 1.
    //point1, point3, point5 can be contained in circle with radius 11, and can be contained within circle with radius 12.
    //Test corresponds with LIC 13
    @Test
    void condition13_RADIUS1_equals_11_RADIUS2_equals_12_APTS_equals_1_BPTS_equals_1_FALSE() {
        int numPoints = 5;
        Point[] points = { new Point(3,0), new Point(0,-1), new Point(0,3), new Point(2, 1), new Point(6,8)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 11, 0, 0, 0, 0, 0, 0, 0, 1 , 1, 0, 0, 0,0, 0, 0, 12, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition13());
    }

    //Test should resolve to true. Parameters: AREA1 = 1, AREA2 = 3, E_PTS = 1, F_PTS = 1.
    //area of triangle with vertexes in point1, point3 and point5 has area 2, which is greater than AREA1 but smaller than AREA2.
    //Test corresponds with LIC 14
    @Test
    void condition14_AREA1_equals_1_AREA2_equals_3_EPTS_equals_1_FPTS_equals_1_such_points_exist_TRUE() {
        int numPoints = 5;
        Point[] points = { new Point(2,0), new Point(0,0), new Point(0,0), new Point(0, 0), new Point(0,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 1, 0, 0, 0, 0, 0, 1 , 0, 0, 0, 1,1, 0, 0, 0, 3);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition14());
    }

    //Test should resolve to false. Parameters: AREA1 = 1, AREA2 = 3, E_PTS = 1, F_PTS = 1.
    //area of triangle with vertexes in point1, point3 and point5 has area 4, which is greater than AREA1 and greater than AREA2.
    //Test corresponds with LIC 14
    @Test
    void condition14_AREA1_equals_1_AREA2_equals_3_EPTS_equals_1_FPTS_equals_1_no_such_points_exist_FALSE() {
        int numPoints = 5;
        Point[] points = { new Point(4,0), new Point(0,0), new Point(0,0), new Point(0, 0), new Point(0,4)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 1, 0, 0, 0, 0, 0, 1 , 0, 0, 0, 1,1, 0, 0, 0, 3);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition14());
    }

    //Test for whole application, should resolve to TRUE.
    //Test case designed such that all LICs should be true.
    //condition0: satisfied by p1, p2. LENGTH1 = 1
    //condition7: satisfied by p1, p4. LENGTH1 = 1, K_PTS = 2
    //condition12: satisfied by p1, p4. LENGTH1 = 1, LENGTH2 = 4, K_PTS = 2
    //condition1: satisfied by p5, p6, p7. RADIUS1 = 1
    //condition8: satisfied by p5, p7, p9. RADIUS1 = 1, A_PTS = 1, B_PTS = 1
    //condition13: satisfied by p5, p7, p9. RADIUS1 = 1, RADIUS2 = 3, A_PTS = 1, B_PTS = 1
    //condition2: satisfied by p10, p11, p12. EPSILON = PI/3
    //condition9: satisfied by p10, p12, p15. EPSILON = PI/3, C_PTS = 1, D_PTS = 1
    //condition3: satisfied by p16, p17, p18. AREA1 = 5
    //condition10: satisfied by p16, p18, p20. AREA1 = 5, E_pts = 1, F_pts = 1
    //condition14: satisfied by p16, p18, p20. AREA1 = 5, AREA2 = 7, E_pts = 1, F_pts = 1
    //condition4: satisfied by p21, p22, p23. Q_PTS = 3, QUADS = 2
    //condition9: satisfied by p24, p25.
    //condition6: satisfied by p26, p27, p28. DIST = 2, N_PTS = 3
    //condition11: satisfied by p28, p29. G_PTS = 1
    @Test
    void finalTestTrue() {
        int numPoints = 29;
        Point p1 = new Point(0,1);
        Point p2 = new Point(0,3);
        Point p3 = new Point(100,100);
        Point p4 = new Point(0,4);
        Point p5 = new Point(2,0);
        Point p6 = new Point(0,2);
        Point p7 = new Point(-2,0);
        Point p8 = new Point(101,101);
        Point p9 = new Point(0,-2);
        Point p10 = new Point(0,5);
        Point p11 = new Point(0,0);
        Point p12 = new Point(5,0);
        Point p13 = new Point(102,102);
        Point p14 = new Point(10,5);
        Point p15 = new Point(1,6);
        Point p16 = new Point(1,0);
        Point p17 = new Point(7,0);
        Point p18 = new Point(103,103);
        Point p19 = new Point(7,6);
        Point p20 = new Point(8,8);
        Point p21 = new Point(8,-8);
        Point p22 = new Point(-8,-8);
        Point p23 = new Point(10,0);
        Point p24 = new Point(9,0);
        Point p25 = new Point(11,0);
        Point p26 = new Point(14,0);
        Point p27 = new Point(11,2);
        Point p28 = new Point(13,0);
        Point p29 = new Point(12,0);
        Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(1, 1, Math.PI/3, 5, 3, 2, 2, 3, 2, 1 , 1, 1, 1, 1,1, 1, 4, 3, 7);
        LogicalOperator[][] lcm = {{LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR},
                {LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND},
                {LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR},
                {LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND},
                {LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR},
                {LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND},
                {LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR},
                {LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND},
                {LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR},
                {LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND},
                {LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR},
                {LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND},
                {LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR},
                {LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND},
                {LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR},
                {LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND, LogicalOperator.OR, LogicalOperator.AND}};
        boolean[] puv = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcm, puv);
        Decide decide = new Decide(settings);
        assertTrue(decide.decideHelper());
    }

    //invalid test length1 = -1
    @Test
    void InvalidTestCondition0() {
        int numPoints = 2;
        Point[] points = {new Point(0,0), new Point(0,6)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition0());
    }

    //invalid test RADIUS1 = -1
    @Test
    void InvalidTestCondition1() {
        int numPoints = 4;
        Point[] points = {new Point(0,1), new Point(1,0), new Point(0, -1), new Point(5, -12)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, -1, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition1());
    }

    //invalid test EPSILON = 2*PI
    @Test
    void InvalidTestCondition2() {
        int numPoints = 3;
        Point[] points = {new Point(0,1), new Point(0,0), new Point(1, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 2*Math.PI, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition2());
    }

    //invalid test AREA1 = -1
    @Test
    void InvalidTestCondition3() {
        int numPoints = 4;
        Point[] points = {new Point(1, 2), new Point(0,2), new Point(0,0), new Point(2, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, -1, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition3());
    }

    //invalid test QUADS = 4
    @Test
    void InvalidTestCondition4() {
        int numPoints = 4;
        Point[] points = {new Point(0, 2), new Point(1,1), new Point(1,-1), new Point(-1, -1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 3, 4, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition4());
    }

    //invalid test dist = -1
    @Test
    void InvalidTestCondition6() {
        int numPoints = 4;
        Point[] points = {new Point(0,1), new Point(1,0), new Point(4, 1), new Point(1,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 0, 0, -1, 3, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition6());
    }

    //invalid test K_PTS = -1
    @Test
    void InvalidTestCondition7() {
        int numPoints = 5;
        Point[] points = {new Point(0,0), new Point(0,1), new Point(1,0), new Point(0, -1), new Point(0,5)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(2, 0, 0, 0, 0, 0, 2, 0, 2, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition7());
    }

    //invalid input test A PTS+B PTS = 6
    @Test
    void InvalidTestCondition8() {
        int numPoints = 6;
        Point[] points = {new Point(0,0), new Point(0,0), new Point(0,1), new Point(1,0), new Point(0, -1), new Point(0,6)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 2, 0, 0, 0, 0, 0, 0, 0, 3 , 3, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition8());
    }

    //invalid input test  C PTS = -1
    @Test
    void InvalidTestCondition9() {
        int numPoints = 5;
        Point[] points = { new Point(1,0), new Point(2,1), new Point(0,0), new Point(1, 0), new Point(0,-1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, Math.PI/3, 0, 0, 0, 0, 0, 0, 0 , 0, -1, 1, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition9());
    }
    //invalid input test  E PTS = -1
    @Test
    void InvalidTestCondition10() {
        int numPoints = 5;
        Point[] points = { new Point(2,0), new Point(1,1), new Point(0,0), new Point(-1, 0), new Point(0,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 1, 0, 0, 0, 0, 0, 0 , 0, 0, 0, -1,1, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition10());
    }

    //invalid input test gpts = -1
    @Test
    void InvalidTestCondition11() {
        int numPoints = 4;
        Point[] points = { new Point(1,0), new Point(4,0), new Point(2,0), new Point(3, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, -1, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition11());
    }

    //invalid input test length2 = -1
    @Test
    void InvalidTestCondition12() {
        int numPoints = 4;
        Point[] points = { new Point(0,0), new Point(2,0), new Point(3,0), new Point(4, 0)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(2, 0, 0, 0, 0, 0, 0, 0, 1, 0 , 0, 0, 0, 0,0, 0, -1, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition12());
    }

    //invalid input test RADIUS2 = -1
    @Test
    void InvalidTestCondition13() {
        int numPoints = 5;
        Point[] points = { new Point(3,0), new Point(0,-1), new Point(0,3), new Point(2, 1), new Point(6,8)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 4, 0, 0, 0, 0, 0, 0, 0, 1 , 1, 0, 0, 0,0, 0, 0, -1, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition13());
    }

    //invalid input test AREA2 = -1
    @Test
    void InvalidTestCondition14() {
        int numPoints = 5;
        Point[] points = { new Point(2,0), new Point(0,0), new Point(0,0), new Point(0, 0), new Point(0,2)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, 0, 1, 0, 0, 0, 0, 0, 1 , 0, 0, 0, 1,1, 0, 0, 0, -1);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertFalse(decide.condition14());
    }


}


