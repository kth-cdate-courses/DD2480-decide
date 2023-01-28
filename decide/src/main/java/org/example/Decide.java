package org.example;

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
        return true;
    }

    public boolean condition0() {
        return true;
    }

    public boolean condition1() {
        return true;
    }

    public boolean condition2() {
        return true;
    }

    public boolean condition3() {
        return true;
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
        return true;
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
        return true;
    }

    public boolean condition13() {
        return true;
    }

    public boolean condition14() {
        return true;
    }

}
