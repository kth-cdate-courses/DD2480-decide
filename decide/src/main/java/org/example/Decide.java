package org.example;

import java.util.function.Function;
import java.util.stream.IntStream;
import org.example.InitialSettings.Point;

import org.example.InitialSettings.Point;

public class Decide {

    private InitialSettings settings;

    public Decide(InitialSettings settings) {
        this.settings = settings;
    }

    public void decide() {
        System.out.println(decideHelper() ? "YES" : "NO");
    }

    public boolean decideHelper() {
        // TODO do stuff here
        return true;
    }

    public boolean condition0() {
        return IntStream.range(0, settings.NUMPOINTS - 1).anyMatch(
                (index) -> settings.POINTS[index].distance(settings.POINTS[index + 1]) > settings.PARAMETERS.LENGTH1);
    }

    public boolean condition1() {
        return true;
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
        Function<Integer, Point> getStart = (index) -> settings.POINTS[index];
        Function<Integer, Point> getEnd = (index) -> settings.POINTS[index + settings.PARAMETERS.N_PTS];
        double DIST = settings.PARAMETERS.DIST;

        return settings.NUMPOINTS >= 3
                && IntStream.range(0, settings.NUMPOINTS - settings.PARAMETERS.N_PTS)
                        .anyMatch((index) -> settings.POINTS[index]
                                .isEqualTo(settings.POINTS[index + settings.PARAMETERS.N_PTS])
                                        ? IntStream.range(index + 1, index + settings.PARAMETERS.N_PTS).reduce(0, (
                                                total,
                                                currentIndex) -> (int) (total + Math.round(settings.POINTS[index] // ! Rounding here could pose a problem, depending on accuracy it should be fine
                                                        .distance(settings.POINTS[currentIndex])))) > DIST
                                        : IntStream.range(index, index + settings.PARAMETERS.N_PTS)
                                                .mapToObj((innerIndex) -> settings.POINTS[innerIndex])
                                                .anyMatch(
                                                        (currentPoint) -> (currentPoint
                                                                // Check distance from line
                                                                .getIntersectPoint(getStart.apply(index),
                                                                        getEnd.apply(index))
                                                                .distance(
                                                                        currentPoint) > DIST
                                                                // If too close to line it might still be
                                                                // fine if the point is not between p2 and p3
                                                                || currentPoint.x > getStart.apply(index).x
                                                                        && currentPoint.x > getEnd.apply(index).x
                                                                || currentPoint.x < getStart.apply(index).x
                                                                        && currentPoint.x < getEnd.apply(index).x)
                                                                // Check distance from point to start and end
                                                                && currentPoint.distance(
                                                                        getStart.apply(index)) > DIST
                                                                && currentPoint
                                                                        .distance(getEnd.apply(index)) > DIST));
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
        return true;
    }

    public boolean condition10() {
        return true;
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
        return true;
    }

}
