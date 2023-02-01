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

    //Test should resolve to false. Parameters: QUADS = 3, Q_PTS = 3. Points exist in 2 quadrants. Test corresponds with LIC 44
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



}


