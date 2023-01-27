package org.example;

public class InitialSettings {
    public final int NUMPOINTS;
    public final Point[] POINTS;
    public final Parameters PARAMETERS;
    public final  LogicalOperator[][] LCM;

    public class Parameters {
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
        public final int G_PTS;
        public final double LENGTH2;
        public final double RADIUS2;
        public final double AREA2;
    }

    public class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
