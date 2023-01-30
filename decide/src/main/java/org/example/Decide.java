package org.example;

import java.util.Arrays;
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

    public Boolean[] getConditionMetVector() {
        // Create a list of booleans, one for each LIC
        // For each LIC, check if it is true or false
        return new Boolean[] {
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

    public boolean decideHelper() {
        final Boolean[] conditionMetVector = getConditionMetVector();
        return validateFUV(new Boolean[]{});
    }

    public boolean validateFUV(Boolean[] finalUnlockingVector) {
        return Arrays.stream(finalUnlockingVector).allMatch((conditionMet) -> conditionMet);
    }

    public boolean condition0() {
        return IntStream.range(0, settings.NUMPOINTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(settings.POINTS[index + 1]) > settings.PARAMETERS.LENGTH1);
    }

    public boolean condition1() {
        return IntStream.range(0, settings.NUMPOINTS - 2).anyMatch(
                (index) -> Point.smallestCircleRadius(settings.POINTS[index],
                        settings.POINTS[index + 1],
                        settings.POINTS[index + 2]) > settings.PARAMETERS.RADIUS1);
    }

    public boolean condition2() {
        return true;
    }

    public boolean condition3() {
        return IntStream.range(0, settings.NUMPOINTS - 2).anyMatch(
                (index) -> Point.triangleArea(settings.POINTS[index], settings.POINTS[index + 1],
                        settings.POINTS[index + 2]) > settings.PARAMETERS.AREA1);
    }

    public boolean condition4() {
        return true;
    }

    public boolean condition5() {
        return true;
    }

    public boolean condition6() {
        return true;
    }

    public boolean condition7() {
        return settings.NUMPOINTS >= 3
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.K_PTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(
                        settings.POINTS[index + settings.PARAMETERS.K_PTS + 1]) > settings.PARAMETERS.LENGTH1);
    }

    public boolean condition8() {
        return true;
    }

    public boolean condition9() {
        Point[] POINTS = settings.POINTS;
        int C_PTS = settings.PARAMETERS.C_PTS;
        int D_PTS = settings.PARAMETERS.D_PTS;
        return settings.NUMPOINTS >= 5 && IntStream.range(0, settings.NUMPOINTS - 2 - C_PTS - D_PTS).anyMatch(
                (index) -> (POINTS[index + 1 + C_PTS].angle(POINTS[index], POINTS[index + 2 + C_PTS + D_PTS])
                        > Math.PI - settings.PARAMETERS.EPSILON));
    }

    public boolean condition10() {
        return settings.NUMPOINTS >= 5 && IntStream.range(0, settings.NUMPOINTS - 2 - settings.PARAMETERS.E_PTS -
                settings.PARAMETERS.F_PTS).anyMatch(
                (index) -> (Point.triangleArea(settings.POINTS[index],
                        settings.POINTS[index + 1 + settings.PARAMETERS.E_PTS],
                        settings.POINTS[index + 1 + settings.PARAMETERS.E_PTS + 1 + settings.PARAMETERS.F_PTS])
                        > settings.PARAMETERS.AREA1));
    }

    public boolean condition11() {
        return true;
    }

    public boolean condition12() {
        return condition7() && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.K_PTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(
                        settings.POINTS[index + settings.PARAMETERS.K_PTS + 1]) < settings.PARAMETERS.LENGTH2);
    }

    public boolean condition13() {
        return true;
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
