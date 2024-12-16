package org.epanikas.mathexcercise.operation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogarithmOperation implements BinaryOperation {

    private final int base;
    private final Operation value;

    @Override
    public Operation getOperand1() {
        return IntNumber.create(base);
    }

    @Override
    public Operation getOperand2() {
        return value;
    }

    @Override
    public String asMathMl() {
        return "\\logarithm " + "_" + base + " " + value.asMathMl();
    }

    public static LogarithmOperation createRandom(int maxBase, int maxValue) {

        int base = IntNumber.createRandom(2, maxBase).getValue();
        int maxPower = (int) Math.ceil(Math.log(maxValue) / Math.log(base));
        int power = IntNumber.createRandom(0, maxPower).getValue();
        double value = Math.pow(base, power);
        System.out.println("base " + base + ", maxPower " + maxPower + ", power " + power + ", value " + value);
        while (value > maxValue && power >= 0) {
            power--;
            value = Math.pow(base, power);
        }

        return new LogarithmOperation(base, IntNumber.create((int) value));
    }

    @Override
    public int result() {
        return (int) (Math.log(value.result()) / Math.log(base));
    }
}
