package org.example;

public class InitialSettings {
    public final int NUMPOINTS;
    public final Point[] POINTS;
    public final Parameters PARAMETERS;
    public final  LogicalOperator[][] LCM;
    public final boolean[] PUV;

    public InitialSettings(int numpoints, Point[] points, Parameters parameters, LogicalOperator[][] lcm, boolean[] puv) {
        NUMPOINTS = numpoints;
        POINTS = points;
        PARAMETERS = parameters;
        LCM = lcm;
        PUV = puv;
    }

    public static class Parameters {
        public final double LENGTH1; // Length in LIC 0, 7, 12
        public final double RADIUS1; // Radius in LIC 1, 8, 13
        public final double EPSILON; // Deviation from PI in LIC 2, 9
        public final double AREA1; // Area in LIC 3, 10, 14
        public final int Q_PTS; // Number of consecutive points in LIC 4
        public final int QUADS; // Number of quadrants in LIC 4
        public final double DIST; // Distance in LIC 6
        public final int N_PTS; // Number of consecutive points in LIC 6
        public final int K_PTS; // Number of intervening points in LIC 7, 12
        public final int A_PTS; // Number of intervening points in LIC 8, 13
        public final int B_PTS; // Number of intervening points in LIC 8, 13
        public final int C_PTS; // Number of intervening points in LIC 9
        public final int D_PTS; // Number of intervening points in LIC 9
        public final int E_PTS; // Number of intervening points in LIC 10, 14
        public final int F_PTS; // Number of intervening points in LIC 10, 14
        public final int G_PTS; // Number of intervening points in LIC 11
        public final double LENGTH2; // Maximum length in LIC 12
        public final double RADIUS2; // Maximum radius in LIC 13
        public final double AREA2; // Maximum area in LIC 14


        public Parameters(double length1, double radius1, double epsilon, double area1, int q_pts, int quads, double dist, int n_pts, int k_pts, int a_pts, int b_pts, int c_pts, int d_pts, int e_pts, int f_pts, int g_pts, double length2, double radius2, double area2) {
            LENGTH1 = length1;
            RADIUS1 = radius1;
            EPSILON = epsilon;
            AREA1 = area1;
            Q_PTS = q_pts;
            QUADS = quads;
            DIST = dist;
            N_PTS = n_pts;
            K_PTS = k_pts;
            A_PTS = a_pts;
            B_PTS = b_pts;
            C_PTS = c_pts;
            D_PTS = d_pts;
            E_PTS = e_pts;
            F_PTS = f_pts;
            G_PTS = g_pts;
            LENGTH2 = length2;
            RADIUS2 = radius2;
            AREA2 = area2;
        }
    }

    public static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
