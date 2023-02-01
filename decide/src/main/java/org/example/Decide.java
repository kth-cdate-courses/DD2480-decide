package org.example;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Decide {

    private InitialSettings settings;

    public Decide(InitialSettings settings) {
        this.settings = settings;
    }

    /**
     * Main function of the program:
     * calls the decideHelper function to get decision
     * prints out the launch decision on the standard output
     */
    public void decide() {
        System.out.println(decideHelper() ? "YES" : "NO");
    }

    /**
     * Computes all intermediate results from the conditions up to the final decision.
     * @return true if the launch is approved
     */
    public boolean decideHelper() {
        final Boolean[] conditionMetVector = getConditionMetVector();
        final Boolean[][] preliminaryUnlockingMatrix = computePreliminaryUnlockingMatrix(conditionMetVector);
        final Boolean[] finalUnlockingVector = computeFinalUnlockingVector(preliminaryUnlockingMatrix);
        return validateFUV(finalUnlockingVector);
    }

    /**
     * Calls methods for each of the 15 conditions.
     * @return boolean vector containing the result of each condition
     */
    public Boolean[] getConditionMetVector() {
        // Create a list of booleans, one for each LIC
        // For each LIC, check if it is true or false
        return new Boolean[]{
                condition0(),
                condition1(),
                condition2(),
                condition3(),
                condition4(),
                condition5(),
                condition6(),
                condition7(),
                condition8(),
                condition9(),
                condition10(),
                condition11(),
                condition12(),
                condition13(),
                condition14()
        };
    }

    /**
     * Takes the Condition Met Vector and computes the Preliminary Unlocking Matrix from it.
     * For that, uses the Logical Connector Matrix to see how to combine the LICs together.
     * @param conditionMetVector boolean vector containing the results from all conditions
     * @return boolean matrix representing the Preliminary Unlocking Matrix
     */
    public Boolean[][] computePreliminaryUnlockingMatrix(Boolean[] conditionMetVector) {
        Boolean[][] preliminaryUnlockingMatrix = new Boolean[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j <= i; j++) {
                boolean b = switch (settings.LCM[i][j]) {
                    case NOT_USED -> true;
                    case AND -> conditionMetVector[i] && conditionMetVector[j];
                    case OR -> conditionMetVector[i] || conditionMetVector[j];
                };
                preliminaryUnlockingMatrix[i][j] = b;
                preliminaryUnlockingMatrix[j][i] = b;
            }
        }
        return preliminaryUnlockingMatrix;
    }

    /**
     * Takes the Preliminary Unlocking Matrix and computes the Final Unlocking Vector from it.
     * For that, uses the Preliminary Unlocking Vector to see which LICs are to be considered.
     * @param preliminaryUnlockingMatrix boolean matrix representing the PUM
     * @return boolean vector representing the FUV
     */
    public Boolean[] computeFinalUnlockingVector(Boolean[][] preliminaryUnlockingMatrix) {
        Boolean[] finalUnlockingVector = new Boolean[15];
        for (int i = 0; i < 15; i++) {
            boolean allElementsTrue = true;
            for (int j = 0; j <= i; j++) {
                allElementsTrue = allElementsTrue && preliminaryUnlockingMatrix[i][j];
            }
            finalUnlockingVector[i] = !settings.PUV[i] || allElementsTrue;
        }
        return finalUnlockingVector;
    }


    public boolean validateFUV(Boolean[] finalUnlockingVector) {
        return Arrays.stream(finalUnlockingVector).allMatch((conditionMet) -> conditionMet);

    }

    /**
     * Checks LIC 0
     * @return true if one or more sets of two consecutive data points a distance greater than LENGTH1 apart exist.
     */
    public boolean condition0() {
        if (settings.PARAMETERS.LENGTH1 < 0)
            return false;
        return IntStream.range(0, settings.NUMPOINTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(settings.POINTS[index + 1]) > settings.PARAMETERS.LENGTH1);
    }

    /**
     * Checks LIC 1
     * @return true if any three consecutive data points cannot be contained on or within a circle with radius RADIUS1
     */
    public boolean condition1() {
        if (settings.PARAMETERS.RADIUS1 < 0)
            return false;
        return IntStream.range(0, settings.NUMPOINTS - 2).anyMatch(
                (index) -> Point.smallestCircleRadius(settings.POINTS[index],
                        settings.POINTS[index + 1],
                        settings.POINTS[index + 2]) > settings.PARAMETERS.RADIUS1);
    }

    /**
     * Checks LIC 2
     * @return true if angle formed from three consecutive points (middle point is vertex) is either less than PI-epsilon or
     * greater than PI + epsilon
     */
    public boolean condition2() {
        if (!(0 <= settings.PARAMETERS.EPSILON && settings.PARAMETERS.EPSILON < Math.PI))
            return false;
        Point[] POINTS = settings.POINTS;
        return settings.NUMPOINTS >= 3 && IntStream.range(0, settings.NUMPOINTS - 2).anyMatch(
                (index) -> (POINTS[index + 1].angle(POINTS[index], POINTS[index + 2]).isPresent()) &&
                        (
                                POINTS[index + 1].angle(POINTS[index], POINTS[index + 2]).get()
                                        < Math.PI - settings.PARAMETERS.EPSILON
                                    ||
                                POINTS[index + 1].angle(POINTS[index], POINTS[index + 2]).get()
                                        > Math.PI + settings.PARAMETERS.EPSILON
                        )
                );
    }

    /**
     * Checks LIC 3
     * @return true if some three consecutive points form triangle with area greater than AREA1
     */
    public boolean condition3() {
        if (settings.PARAMETERS.AREA1 < 0)
            return false;
        return IntStream.range(0, settings.NUMPOINTS - 2).anyMatch(
                (index) -> Point.triangleArea(settings.POINTS[index], settings.POINTS[index + 1],
                        settings.POINTS[index + 2]) > settings.PARAMETERS.AREA1);
    }

    /**
     * Checks LIC 4.
     * See spec. for more details
     * @return true if Q_PTS consecutive points are located in more than QUADS quadrants.
     */
    public boolean condition4() {
        if (!(2 <= settings.PARAMETERS.Q_PTS && settings.PARAMETERS.Q_PTS <= settings.NUMPOINTS) &&
                1 <= settings.PARAMETERS.QUADS && settings.PARAMETERS.QUADS <= 3) {
            return false;
        }
        return IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.Q_PTS + 1).anyMatch(
                (index) -> Point.quadrantRepartition(
                        Arrays.copyOfRange(settings.POINTS, index, index + settings.PARAMETERS.Q_PTS),
                        settings.PARAMETERS.QUADS));
    }

    /**
     * Checks LIC 5
     * @return true if there are two consecutive points Pi and Pj such that X[Pj] - [Pi] < 0, (i = j - 1)
     */
    public boolean condition5() {
        return IntStream.range(0, settings.NUMPOINTS - 1).anyMatch(
                (index) -> settings.POINTS[index + 1].x - settings.POINTS[index].x < 0);
    }

    /**
     * Checks LIC 6
     * See spec. for more on particular cases
     * @return true if there exists N_PTS consecutive points with one of them
     * laying further than DIST from the line joining the first and last of the points.
     */
    public boolean condition6() {
        if (!(3 <= settings.PARAMETERS.N_PTS && settings.PARAMETERS.N_PTS <= settings.NUMPOINTS && 0 <= settings.PARAMETERS.DIST))
            return false;
        Function<Integer, Point> getStart = (index) -> settings.POINTS[index];
        Function<Integer, Point> getEnd = (index) -> settings.POINTS[index + settings.PARAMETERS.N_PTS - 1];
        double DIST = settings.PARAMETERS.DIST;

        return settings.NUMPOINTS >= 3
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.N_PTS + 1)
                        .anyMatch((index) -> settings.POINTS[index]
                                .isEqualTo(settings.POINTS[index + settings.PARAMETERS.N_PTS - 1])
                                        // Index + 1 because we choose the first point as the coincident point
                                        ? IntStream.range(index + 1, index + settings.PARAMETERS.N_PTS - 1).mapToDouble(
                                                index1 -> settings.POINTS[index1].distance(settings.POINTS[index]))
                                                .sum() > DIST
                                        : Arrays.stream(settings.POINTS, index, index + settings.PARAMETERS.N_PTS - 1)
                                                .anyMatch(
                                                        (currentPoint) -> (currentPoint
                                                                // Check distance from line
                                                                .getIntersectPoint(getStart.apply(index),
                                                                        getEnd.apply(index))
                                                                .distance(
                                                                        currentPoint) > DIST)));
                                                               
    }

    /**
     * Checks LIC 7
     * @return true if two points greater than LENGTH1 apart are separated by K_PTS consecutive points in between, and
     * NUMPOINTS >= 3
     */
    public boolean condition7() {
        if (!(1 <= settings.PARAMETERS.K_PTS && settings.PARAMETERS.K_PTS <= settings.NUMPOINTS - 2))
            return false;
        return settings.NUMPOINTS >= 3
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.K_PTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(
                        settings.POINTS[index + settings.PARAMETERS.K_PTS + 1]) > settings.PARAMETERS.LENGTH1);
    }

    /**
     * Checks LIC 8
     * See spec. for more details
     * @return true if cannot constrain all three points, separated by first A_PTS and then B_PTS points between, on/within
     * circle of radius RADIUS1
     */
    public boolean condition8() {
        if (!(1 <= settings.PARAMETERS.A_PTS && 1 <= settings.PARAMETERS.B_PTS &&
                settings.PARAMETERS.A_PTS + settings.PARAMETERS.B_PTS <= settings.NUMPOINTS - 3)) {
            return false;
        }
        return settings.NUMPOINTS >= 5
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.A_PTS - settings.PARAMETERS.B_PTS - 2).anyMatch(
                (index) -> Point.smallestCircleRadius(settings.POINTS[index],
                        settings.POINTS[index + settings.PARAMETERS.A_PTS + 1],
                        settings.POINTS[index + settings.PARAMETERS.A_PTS + settings.PARAMETERS.B_PTS + 2])
                        > settings.PARAMETERS.RADIUS1);
    }

    /**
     * Checks LIC 9
     * See spec. for more details
     * @return true if three points with first C_PTS and then D_PTS between them (middle is vertex) forms angle fulfills
     * either angle < PI - epsilon or angle > PI + epsilon
     */
    public boolean condition9() {
        if (!(1 <= settings.PARAMETERS.C_PTS && 1 <= settings.PARAMETERS.D_PTS &&
                settings.PARAMETERS.C_PTS + settings.PARAMETERS.D_PTS <= settings.NUMPOINTS - 3)) {
            return false;
        }
        Point[] POINTS = settings.POINTS;
        int C_PTS = settings.PARAMETERS.C_PTS;
        int D_PTS = settings.PARAMETERS.D_PTS;
        return settings.NUMPOINTS >= 5 && IntStream.range(0, settings.NUMPOINTS - 2 - C_PTS - D_PTS).anyMatch(
                (index) -> (POINTS[index + 1 + C_PTS].angle(POINTS[index], POINTS[index + 2 + C_PTS + D_PTS]).isPresent()) &&
                        (
                                POINTS[index + 1 + C_PTS].angle(POINTS[index], POINTS[index + 2 + C_PTS + D_PTS]).get()
                                        < Math.PI - settings.PARAMETERS.EPSILON
                                    ||
                                POINTS[index + 1 + C_PTS].angle(POINTS[index], POINTS[index + 2 + C_PTS + D_PTS]).get()
                                        > Math.PI + settings.PARAMETERS.EPSILON)
                );
    }

    /**
     * Checks LIC 10
     * See spec. for more details
     * @return true if three points separated by E_PTS and F_PTS consecutive points between form triangle with area greater
     * than AREA1
     */
    public boolean condition10() {
        if (!(1 <= settings.PARAMETERS.E_PTS && 1 <= settings.PARAMETERS.F_PTS &&
                settings.PARAMETERS.E_PTS + settings.PARAMETERS.F_PTS <= settings.NUMPOINTS - 3)) {
            return false;
        }
        Predicate<Double> areaIsGreaterThanArea1 = a -> (a > settings.PARAMETERS.AREA1);
        return settings.NUMPOINTS >= 5 && spacedTriangleGivenAreaConstraintExists(areaIsGreaterThanArea1);
    }

    /**
     * Checks LIC 11
     * See spec. for more details
     * @return true if there exists two points Pi and Pj such that i < j, fulfill X[Pi] - X[Pj] < 0,
     * and there are G_PTS between Pi and Pj
     */
    public boolean condition11() {
        if (!(1 <= settings.PARAMETERS.G_PTS && settings.PARAMETERS.G_PTS <= settings.NUMPOINTS - 2))
            return false;
        return settings.NUMPOINTS >= 3
                && IntStream.range(0, settings.NUMPOINTS - 1 - settings.PARAMETERS.G_PTS).anyMatch(
                (index) -> settings.POINTS[index + settings.PARAMETERS.G_PTS + 1].x - settings.POINTS[index].x < 0);
    }

    /**
     * Checks LIC 12
     * See spec. for more details. This is only a rough overview. Condition 7 is a subset of this condition.
     * @return true if two sets of two points (sets must not be unique) fulfill distance criteria. Points for set 1 should
     * be of distance greater than LENGTH1 and points for set 2 should be of distance less LENGTH2.
     */
    public boolean condition12() {
        if (!(0 <= settings.PARAMETERS.LENGTH2))
            return false;
        return condition7() && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.K_PTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(
                        settings.POINTS[index + settings.PARAMETERS.K_PTS + 1]) < settings.PARAMETERS.LENGTH2);
    }

    /**
     * Checks LIC 13
     * See spec. for more details. Condition 8 is a subset of this condition.
     * @return true if set of three points with A_PTS and B_PTS in between cannot be contained on/within circle of radius
     * RADIUS1 and some three points with same constrains as previously can  be contained on/within circle of radius RADIUS 2
     */
    public boolean condition13() {
        if (!(0 <= settings.PARAMETERS.RADIUS2))
            return false;
        return condition8()
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.A_PTS - settings.PARAMETERS.B_PTS - 2).anyMatch(
                (index) -> Point.smallestCircleRadius(settings.POINTS[index],
                        settings.POINTS[index + settings.PARAMETERS.A_PTS + 1],
                        settings.POINTS[index + settings.PARAMETERS.A_PTS + settings.PARAMETERS.B_PTS + 2])
                        <= settings.PARAMETERS.RADIUS2);
    }

    /**
     * Checks LIC 14
     * See spec. for more details. Condition 10 is a subset of this.
     * @return true if there exists triangle with area greater than AREA1 and a triangle with area less than AREA2. Triangles
     * can be the same. The three points forming a triangle should be separated by first E_PTS and then F_PTS consecutive points.
     */
    public boolean condition14() {
        if (!(0 <= settings.PARAMETERS.AREA2))
            return false;
        Predicate<Double> areaIsLessThanArea2 = a -> (a < settings.PARAMETERS.AREA2);
        Predicate<Double> areaIsGreaterThanArea1 = a -> (a > settings.PARAMETERS.AREA1);
        return settings.NUMPOINTS >= 5 && spacedTriangleGivenAreaConstraintExists(areaIsLessThanArea2) &&
                spacedTriangleGivenAreaConstraintExists(areaIsGreaterThanArea1);
    }

    private boolean spacedTriangleGivenAreaConstraintExists(Predicate<Double> areaConstraint) {
        return IntStream.range(0, settings.NUMPOINTS - 2 - settings.PARAMETERS.E_PTS -
                settings.PARAMETERS.F_PTS).anyMatch(
                (index) -> areaConstraint.test(
                        Point.triangleArea(settings.POINTS[index],
                                settings.POINTS[index + 1 + settings.PARAMETERS.E_PTS],
                                settings.POINTS[index + 1 + settings.PARAMETERS.E_PTS + 1 + settings.PARAMETERS.F_PTS])
                ));
    }

}
