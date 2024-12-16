package org.epanikas.mathexcercise.operation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PowerOperation implements BinaryOperation {

    private final int power;
    private final Operation value;

    @Override
    public Operation getOperand1() {
        return value;
    }

    @Override
    public Operation getOperand2() {
        return IntNumber.create(power);
    }

    @Override
    public String asMathMl() {
        return "{" + value.asMathMl() + "}^" + this.power;
    }

    public static PowerOperation createRandom(int maxBase, int maxValue) {

        int base = IntNumber.createRandom(2, maxBase).getValue();
        int maxPower = (int) Math.ceil(Math.log(maxValue) / Math.log(base));
        int power = IntNumber.createRandom(0, maxPower).getValue();
        double value = Math.pow(base, power);
        System.out.println("base " + base + ", maxPower " + maxPower + ", power " + power + ", value " + value);
        while (value > maxValue && power >= 0) {
            power--;
            value = Math.pow(base, power);
        }

        return new PowerOperation(power, IntNumber.create(base));
    }

    @Override
    public int result() {
        return (int) Math.pow(value.result(), power);
    }
}
