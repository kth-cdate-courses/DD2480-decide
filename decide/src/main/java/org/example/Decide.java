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

    public void decide() {
        System.out.println(decideHelper() ? "YES" : "NO");
    }

    public boolean decideHelper() {
        final Boolean[] conditionMetVector = getConditionMetVector();
        final Boolean[][] preliminaryUnlockingMatrix = computePreliminaryUnlockingMatrix(conditionMetVector);
        final Boolean[] finalUnlockingVector = computeFinalUnlockingVector(preliminaryUnlockingMatrix);
        return validateFUV(finalUnlockingVector);
    }

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
        return IntStream.range(0, settings.NUMPOINTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(settings.POINTS[index + 1]) > settings.PARAMETERS.LENGTH1);
    }

    /**
     * Checks LIC 1
     * @return true if any three consecutive data points cannot be contained on or within a circle with radius RADIUS1
     */
    public boolean condition1() {
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
        return IntStream.range(0, settings.NUMPOINTS - 2).anyMatch(
                (index) -> Point.triangleArea(settings.POINTS[index], settings.POINTS[index + 1],
                        settings.POINTS[index + 2]) > settings.PARAMETERS.AREA1);
    }

    public boolean condition4() {
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

    public boolean condition6() {
        Function<Integer, Point> getStart = (index) -> settings.POINTS[index];
        Function<Integer, Point> getEnd = (index) -> settings.POINTS[index + settings.PARAMETERS.N_PTS - 1];
        double DIST = settings.PARAMETERS.DIST;

        return settings.NUMPOINTS >= 3
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.N_PTS + 1)
                        .anyMatch((index) -> settings.POINTS[index]
                                .isEqualTo(settings.POINTS[index + settings.PARAMETERS.N_PTS - 1])
                                        // Index + 1 because we choose the first point as the coincident point
                                        ? IntStream.range(index + 1, index + settings.PARAMETERS.N_PTS - 1).reduce(0, (
                                                total,
                                                currentIndex) -> (int) (total + Math.round(settings.POINTS[index] // ! Rounding here could pose a problem, depending on accuracy it should be fine
                                                        .distance(settings.POINTS[currentIndex])))) > DIST
                                        : Arrays.stream(settings.POINTS, index, index + settings.PARAMETERS.N_PTS - 1)
                                                .anyMatch(
                                                        (currentPoint) -> (currentPoint
                                                                // Check distance from line
                                                                .getIntersectPoint(getStart.apply(index),
                                                                        getEnd.apply(index))
                                                                .distance(
                                                                        currentPoint) > DIST)));
                                                               
    }

    public boolean condition7() {
        return settings.NUMPOINTS >= 3
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.K_PTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(
                        settings.POINTS[index + settings.PARAMETERS.K_PTS + 1]) > settings.PARAMETERS.LENGTH1);
    }

    public boolean condition8() {
        return settings.NUMPOINTS >= 5
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.A_PTS - settings.PARAMETERS.B_PTS - 2).anyMatch(
                (index) -> Point.smallestCircleRadius(settings.POINTS[index],
                        settings.POINTS[index + settings.PARAMETERS.A_PTS + 1],
                        settings.POINTS[index + settings.PARAMETERS.A_PTS + settings.PARAMETERS.B_PTS + 2])
                        > settings.PARAMETERS.RADIUS1);
    }

    public boolean condition9() {
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

    public boolean condition10() {
        Predicate<Double> areaIsGreaterThanArea1 = a -> (a > settings.PARAMETERS.AREA1);
        return settings.NUMPOINTS >= 5 && spacedTriangleGivenAreaConstraintExists(areaIsGreaterThanArea1);
    }

    public boolean condition11() {
        return settings.NUMPOINTS >= 3
                && IntStream.range(0, settings.NUMPOINTS - 1 - settings.PARAMETERS.G_PTS).anyMatch(
                (index) -> settings.POINTS[index + settings.PARAMETERS.G_PTS + 1].x - settings.POINTS[index].x < 0);
    }

    public boolean condition12() {
        return condition7() && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.K_PTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(
                        settings.POINTS[index + settings.PARAMETERS.K_PTS + 1]) < settings.PARAMETERS.LENGTH2);
    }

    public boolean condition13() {
        return condition8()
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.A_PTS - settings.PARAMETERS.B_PTS - 2).anyMatch(
                (index) -> Point.smallestCircleRadius(settings.POINTS[index],
                        settings.POINTS[index + settings.PARAMETERS.A_PTS + 1],
                        settings.POINTS[index + settings.PARAMETERS.A_PTS + settings.PARAMETERS.B_PTS + 2])
                        <= settings.PARAMETERS.RADIUS2);
    }

    public boolean condition14() {
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
