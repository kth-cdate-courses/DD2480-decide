package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {

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

    @Test
    void condition2_EPSILON_equals_PI_divided_by_3_angle_is_PI_divided_by_2_TRUE() {
        int numPoints = 3;
        Point[] points = {new Point(0,1), new Point(0,0), new Point(0, 1)};
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, Math.PI/3, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0,0, 0, 0, 0, 0);
        LogicalOperator[][] lcmNotUsed = new LogicalOperator[15][15];
        boolean[] puvNotUsed = new boolean[15];
        InitialSettings settings = new InitialSettings(numPoints, points, parameters, lcmNotUsed, puvNotUsed);
        Decide decide = new Decide(settings);
        assertTrue(decide.condition2());
    }

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
        InitialSettings.Parameters parameters = new InitialSettings.Parameters(0, 0, Math.PI/2, 0, 0, 0, 0, 0, 0, 0 , 0, 1, 1, 0,0, 0, 0, 0, 0);
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





}


