package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;
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
        return true;
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
        return true;
    }

}
