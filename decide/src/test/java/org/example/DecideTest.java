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


}