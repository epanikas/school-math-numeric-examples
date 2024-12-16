package org.epanikas.mathexcercise.operation;

public class IntNumber implements UnaryOperation {

    private final int value;

    private IntNumber(int value) {
        this.value = value;
    }

    public static IntNumber createRandom(int min, int max) {
        double t = 10000 * Math.random();
        double part = 10000. / (max - min);

//        System.out.println("requested " + min + ": " + max + ", t " + t + ", part " + part + ", frac " + t / part + ", res " + (min + (int)Math.ceil(t / part)));

        return new IntNumber(min + (int)Math.round(t / part));
    }

    public static IntNumber create(int value) {
        return new IntNumber(value);
    }

    @Override
    public Operation getOperand() {
        return this;
    }

    @Override
    public String asMathMl() {
        return Integer.toString(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int result() {
        return value;
    }
}
